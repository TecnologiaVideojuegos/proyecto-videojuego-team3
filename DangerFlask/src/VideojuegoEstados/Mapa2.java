package VideojuegoEstados;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
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
    private Personajes personaje = new Personajes(col, 0, 0, 0, 0, 0, 0);
    private LimitesMapa limiteMapa = new LimitesMapa();
    private Vidas vidas;
    private Objetos obj = new Objetos(col);

    public Mapa2(Vidas vidas) {
        this.vidas = vidas;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapa = new TiledMap("./juego/mapa_final2.1.tmx", "juego");
        personaje.iniciarPers();
        personaje.iniciarEnem();
        obstaculo = limiteMapa.crearLimite2(mapa);
        personaje.colisiones(0, 0, 0, 0, 0, 0);
        obj.creaObjetos();
        obj.colObj(0, 0, 0, 0, 0, 0);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        g.scale(0.5f, 0.5f);
        mapa.render(0, 0);
        g.resetTransform();
        personaje.dibujarPers(x, y);
        g.drawString("Coordenada X:" + x, 100, 10);
        g.drawString("Coordenada Y:" + y, 500, 10);
        col.dibujar(g);
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
        x = personaje.getX();
        y = personaje.getY();
        col.actualizar(x, y);
        col.actualizar(x, y);
        if (col.cambiarMapa2()) {
            game.enterState(2);
        }
        dentro = true;
    }

    @Override
    public int getID() {
        return 1;
    }
}
