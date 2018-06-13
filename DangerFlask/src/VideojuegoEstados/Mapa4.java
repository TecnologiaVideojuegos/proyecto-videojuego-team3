package VideojuegoEstados;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
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
public class Mapa4 extends BasicGameState {

    private TiledMap mapa;
    private float x = 34f, y = 275f;
    private boolean dentro = true, b = false;
    private int i;
    private Colisiones col = new Colisiones(x, y);
    private boolean[][] obstaculo;
    private Personajes personaje = new Personajes(col, 368, 912, 480, 368, 432, 592);
    private LimitesMapa limiteMapa = new LimitesMapa();
    private Vidas vidas;
    private Objetos obj = new Objetos(col, 1152, 576, 240, 384, 1024, 176);
    private Sonido sonido;
    private FadeInTransition entra = new FadeInTransition();
    private FadeOutTransition sale = new FadeOutTransition();
    private Music zacariastheme;

    public Mapa4(Vidas vidas, Sonido sonido) {
        this.vidas = vidas;
        this.sonido = sonido;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapa = new TiledMap("./juego/mapa_final2.2.tmx", "juego");
        personaje.iniciarPersZacarias();
        personaje.iniciarEnemMono();
        obstaculo = limiteMapa.crearLimite4(mapa);
        personaje.colisionesMono(272, 288, 576, 416, 1072, 656);
        obj.creaObjetos();
        obj.colObj();
        sonido.iniciarSonidos();
        zacariastheme = new Music("./Musica/ZacariasTheme.ogg");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        g.scale(0.5f, 0.5f);
        mapa.render(0, 0);
        g.resetTransform();
        personaje.dibujarPers(x, y);
        personaje.dibujarEnem(272, 288, 576, 416, 1072, 656);
        vidas.dibujar(g);
        obj.dibuja();
        g.drawString("Tarjetas recogidas: " + col.getTarjeta4() + "/2", 400, 10);
        g.drawString("Pulse ESC para pausar.", 700, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (!b) {
            zacariastheme.loop(1, 0.5f);
            b = true;
        }
        if (col.animDentro4(obstaculo, x, y)) {
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
        personaje.movimientoEnem4(delta);
        x = personaje.getX();
        y = personaje.getY();
        col.actualizar(x, y);
        personaje.actualizarEnem();

        if (container.getInput().isKeyDown(Input.KEY_ESCAPE)) {
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mapa1.class.getName()).log(Level.SEVERE, null, ex);
            }
            game.enterState(9);
        }

        if (personaje.muere()) {
            sonido.getZacariasDead().play();
            x = 34;
            y = 275;
            obj.setB(true);
            obj.setC(true);
            col.setTarjeta4(0);
            vidas.setVidas(vidas.getVidas() - 1);
            if (vidas.getVidas() == 0) {
                game.enterState(7, entra, sale);
            }
        }
        if (col.cambiarMapa4()) {
            sonido.getPuerta().play();
            game.enterState(6);
        }
        dentro = true;
        if (obj.botCol() && vidas.getVidas() < 6) {
            vidas.setVidas(vidas.getVidas() + 1);
            obj.setA(false);
            sonido.getAdrenalina().play();
        }
        if (obj.tar1Col()) {
            col.setTarjeta4(col.getTarjeta4() + 1);
            obj.setB(false);
            sonido.getTarjeta().play();
        }
        if (obj.tar2Col()) {
            col.setTarjeta4(col.getTarjeta4() + 1);
            obj.setC(false);
            sonido.getTarjeta().play();
        }
    }

    @Override
    public int getID() {
        return 5;
    }
}
