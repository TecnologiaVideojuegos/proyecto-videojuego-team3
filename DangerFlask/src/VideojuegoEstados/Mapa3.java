package VideojuegoEstados;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author SergioSanzSacristan
 */
public class Mapa3 extends BasicGameState {

    private TiledMap mapa;
    private float x = 34f, y = 499f;
    private boolean dentro = true;
    private int i;
    private Colisiones col = new Colisiones(x, y);
    private boolean[][] obstaculo;
    private Personajes personaje = new Personajes(col, 272, 848, 1040, 112, 112, 368);
    private LimitesMapa limiteMapa = new LimitesMapa();
    private Vidas vidas;
    private Objetos obj = new Objetos(col, 576, 128, 64, 592, 1152, 224);
    private FadeInTransition entra = new FadeInTransition();
    private FadeOutTransition sale = new FadeOutTransition();

    public Mapa3(Vidas vidas) {
        this.vidas = vidas;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapa = new TiledMap("./juego/mapa_final1.2.tmx", "juego");
        personaje.iniciarPersJulian();
        personaje.iniciarEnem();
        obstaculo = limiteMapa.crearLimite3(mapa);
        personaje.colisiones(448, 432, 368, 128, 992, 336);
        obj.creaObjetos();
        obj.colObj();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.scale(0.5f, 0.5f);
        mapa.render(0, 0);
        g.resetTransform();
        personaje.dibujarPers(x, y);
        personaje.dibujarEnem(448, 432, 368, 128, 992, 336);
        vidas.dibujar(g);
        col.dibujar(g);
        obj.dibuja();
        g.drawString("Tarjetas recogidas: " + col.getTarjeta3() + "/2", 400, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (col.animDentro3(obstaculo, x, y)) {
            dentro = false;
            if (i == 6) {
                x = x - 1;
            }
            if (i == 4) {
                x = x + 1;
            }
            if (i == 2) {
                y = y - 1;
            }
            if (i == 8) {
                y = y + 1;
            }
        }
        i = personaje.movimiento(dentro, x, y, container, delta);
        personaje.movimientoEnem3(delta);
        x = personaje.getX();
        y = personaje.getY();
        col.actualizar(x, y);
        personaje.actualizarBab();

        if (personaje.muere()) {
            x = 34;
            y = 499;
            obj.setB(true);
            obj.setC(true);
            col.setTarjeta3(0);
            vidas.setVidas(vidas.getVidas() - 1);
            if (vidas.getVidas() == 0) {
                game.enterState(4, entra, sale);
            }
        }
        if (col.cambiarMapa3()) {
            game.enterState(3);
        }
        dentro = true;
        if (obj.botCol() && vidas.getVidas() < 6) {
            vidas.setVidas(vidas.getVidas() + 1);
            obj.setA(false);
        }
        if (obj.tar1Col()) {
            col.setTarjeta3(col.getTarjeta3() + 1);
            obj.setB(false);
        }
        if (obj.tar2Col()) {
            col.setTarjeta3(col.getTarjeta3() + 1);
            obj.setC(false);
        }
    }

    @Override
    public int getID() {
        return 2;
    }
}
