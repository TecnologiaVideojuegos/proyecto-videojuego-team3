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
public class Mapa1 extends BasicGameState {

    private TiledMap mapa;
    private float x = 49f, y = 288f;
    private boolean dentro = true;
    private int i;
    private Colisiones col = new Colisiones(x, y);
    private boolean[][] obstaculo;
    private Personajes personaje = new Personajes();
    private LimitesMapa limiteMapa = new LimitesMapa();

    public Mapa1() {

    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapa = new TiledMap("./juego/mapa_final1.1.tmx", "juego");
        personaje.iniciarPers();
        obstaculo = limiteMapa.crearLimite1(mapa);
//        int totalTilesWidth = mapa.getWidth() * 2;
//        int totalTilesHeight = mapa.getHeight() * 2;
//        obstaculo = new boolean[totalTilesWidth][totalTilesHeight];
//        for (int i = 0; i < totalTilesWidth; i++) {
//            for (int j = 0; j < totalTilesHeight; j++) {
//                obstaculo[i][j] = ((mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 4")) != 0)
//                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 3")) != 0) || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 2")) != 0));
//            }
//        }
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
        x = personaje.getX();
        y = personaje.getY();
        col.actualizar(x, y);
        if (col.cambiarMapa1()) {
            game.enterState(1);
        }
        dentro = true;
    }

    @Override
    public int getID() {
        return 0;
    }
}
