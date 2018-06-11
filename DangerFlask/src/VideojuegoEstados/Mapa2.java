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
public class Mapa2 extends BasicGameState {

    private TiledMap mapa;
    private float x = 34f, y = 483f;
    private boolean dentro = true;
    private int i;
    private Colisiones col = new Colisiones(x, y);
    private boolean[][] obstaculo;
    private Personajes personaje = new Personajes(col, 32, 352, 640, 288, -100, 512);
    private LimitesMapa limiteMapa = new LimitesMapa();
    private Vidas vidas;
    private Objetos obj = new Objetos(col, 640, 112, 432, 416, 640, 416);
    private Sonido sonido = new Sonido();
    private FadeInTransition entra = new FadeInTransition();
    private FadeOutTransition sale = new FadeOutTransition();

    public Mapa2(Vidas vidas) {
        this.vidas = vidas;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapa = new TiledMap("./juego/mapa_final2.1.tmx", "juego");
        personaje.iniciarPersZacarias();
        personaje.iniciarEnemBab();
        obstaculo = limiteMapa.crearLimite2(mapa);
        personaje.colisionesBab(256, 496, 256, 560, -100, 992);
        obj.creaObjetos();
        obj.colObj();
        sonido.iniciarSonidos();
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.scale(0.5f, 0.5f);
        mapa.render(0, 0);
        g.resetTransform();
        personaje.dibujarPers(x, y);
        personaje.dibujarEnem(256, 496, 256, 560, -100, 992);
        vidas.dibujar(g);
        obj.dibuja();
        g.drawString("Tarjetas recogidas: " + col.getTarjeta2() + "/2", 400, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (col.animDentro2(obstaculo, x, y)) {
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
        personaje.movimientoEnem2(delta);
        x = personaje.getX();
        y = personaje.getY();
        col.actualizar(x, y);
        personaje.actualizarEnem();

        if (personaje.muere()) {
            sonido.getZacariasDead().play();
            x = 34;
            y = 483;
            obj.setB(true);
            obj.setC(true);
            col.setTarjeta2(0);
            vidas.setVidas(vidas.getVidas() - 1);
            if (vidas.getVidas() == 0) {
                game.enterState(7, entra, sale);
            }
        }
        if (col.cambiarMapa2()) {
            sonido.getPuerta().play();
            game.enterState(4);
        }
        dentro = true;
        if (obj.botCol() && vidas.getVidas() < 6) {
            vidas.setVidas(vidas.getVidas() + 1);
            obj.setA(false);
            sonido.getAdrenalina().play();
        }
        if (obj.tar1Col()) {
            col.setTarjeta2(col.getTarjeta2() + 1);
            obj.setB(false);
            sonido.getTarjeta().play();
        }
        if (obj.tar2Col()) {
            col.setTarjeta2(col.getTarjeta2() + 1);
            obj.setC(false);
            sonido.getTarjeta().play();
        }
    }

    @Override
    public int getID() {
        return 3;
    }
}
