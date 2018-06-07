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
public class Mapa1 extends BasicGameState {

    private TiledMap mapa;
    private float x = 49f, y = 288f;
    private boolean dentro = true;
    private int i;
    private Colisiones col = new Colisiones(x, y);
    private boolean[][] obstaculo;
    private Personajes personaje = new Personajes(col, 96, 304, 416, 368, 544, 400);//variable en movimiento de los enemigos
    private LimitesMapa limiteMapa = new LimitesMapa();
    private Vidas vidas;
    private Objetos obj = new Objetos(col, 992, 96, 48, 128, 1072, 176);//Coordenadas de objetos
    private Sonido sonido = new Sonido();
    private FadeInTransition entra = new FadeInTransition();
    private FadeOutTransition sale = new FadeOutTransition();

    public Mapa1(Vidas vidas) {
        this.vidas = vidas;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapa = new TiledMap("./juego/mapa_final1.1.tmx", "juego");
        personaje.iniciarPersJulian();
        personaje.iniciarEnemBab();
        obstaculo = limiteMapa.crearLimite1(mapa);
        personaje.colisionesBab(576, 224, 496, 656, 816, 816);//variables estaticas de los enemigos
        obj.creaObjetos();
        obj.colObj();//posicion de los objetos
        sonido.iniciarSonidos();
        //tarjeta = new Sound("./Sonidos/coger_tarjeta.ogg");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.scale(0.5f, 0.5f);
        mapa.render(0, 0);
        g.resetTransform();
        personaje.dibujarPers(x, y);
        personaje.dibujarEnem(576, 224, 496, 656, 816, 816);
        vidas.dibujar(g);
        col.dibujar(g);
        obj.dibuja();
        g.drawString("Tarjetas recogidas: " + col.getTarjeta1() + "/2", 400, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (col.animDentro1(obstaculo, x, y)) {
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
        personaje.movimientoEnem1(delta);
        x = personaje.getX();
        y = personaje.getY();
        col.actualizar(x, y);
        personaje.actualizarEnem();

        if (personaje.muere()) {
            sonido.getJulian().play();
            x = 49;
            y = 288;
            obj.setB(true);
            obj.setC(true);
            col.setTarjeta1(0);
            vidas.setVidas(vidas.getVidas() - 1);
            if (vidas.getVidas() == 0) {
                game.enterState(4, entra, sale);
            }
        }
        if (col.cambiarMapa1()) {
            sonido.getPuerta().play();
            game.enterState(1);
        }
        dentro = true;
        if (obj.botCol() && vidas.getVidas() < 6) {
            vidas.setVidas(vidas.getVidas() + 1);
            obj.setA(false);
            sonido.getAdrenalina().play();
        }
        if (obj.tar1Col()) {
            col.setTarjeta1(col.getTarjeta1() + 1);
            obj.setB(false);
            sonido.getTarjeta().play();
        }
        if (obj.tar2Col()) {
            col.setTarjeta1(col.getTarjeta1() + 1);
            obj.setC(false);
            sonido.getTarjeta().play();
        }
    }

    @Override
    public int getID() {
        return 0;
    }
}
