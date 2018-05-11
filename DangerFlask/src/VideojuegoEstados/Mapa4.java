package VideojuegoEstados;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author SergioSanzSacristan
 */
public class Mapa4 extends BasicGameState {

    private TiledMap mapa;
    private SpriteSheet spriteD, spriteI, spriteAr, spriteAb;
    private Animation animD, animI, animAr, animAb;
    private float x = 34f, y = 275f;
    private boolean derecha = true, dentro = true, arriba = false, izquierda = false, abajo = false;
    private int i;
    private Colisiones col = new Colisiones(x, y);
    private boolean[][] obstaculo;

    public Mapa4() {

    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        mapa = new TiledMap("./juego/mapa_final2.2.tmx", "juego");
        spriteD = new SpriteSheet("./juego/animD.png", 16, 25);
        animD = new Animation(spriteD, 100);
        spriteI = new SpriteSheet("./juego/animI.png", 16, 25);
        animI = new Animation(spriteI, 100);
        spriteAr = new SpriteSheet("./juego/animAr.png", 17, 27);
        animAr = new Animation(spriteAr, 100);
        spriteAb = new SpriteSheet("./juego/animAb.png", 17, 27);
        animAb = new Animation(spriteAb, 100);
        int totalTilesWidth = mapa.getWidth() * 2;
        int totalTilesHeight = mapa.getHeight() * 2;
        obstaculo = new boolean[totalTilesWidth][totalTilesHeight];
        for (int i = 0; i < totalTilesWidth; i++) {
            for (int j = 0; j < totalTilesHeight; j++) {
                obstaculo[i][j] = ((mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 4")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 3")) != 0) || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 2")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de Patrones 1")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 5")) != 0));
            }
        }
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {

        g.scale(0.5f, 0.5f);
        mapa.render(0, 0);
        g.resetTransform();
        if (derecha) {
            animD.draw(x, y);
        }
        if (izquierda) {
            animI.draw(x, y);
        }
        if (arriba) {
            animAr.draw(x, y);
        }
        if (abajo) {
            animAb.draw(x, y);
        }
        g.drawString("Coordenada X:" + x, 100, 10);
        g.drawString("Coordenada Y:" + y, 500, 10);
        col.dibujar(g);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
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
        if (container.getInput().isKeyDown(Input.KEY_RIGHT) && dentro) {
            derecha = true;
            arriba = false;
            izquierda = false;
            abajo = false;
            animD.start();
            x += 100 * (float) delta / 1000;
            i = 6;
        } else if (container.getInput().isKeyDown(Input.KEY_LEFT) && dentro) {
            derecha = false;
            arriba = false;
            izquierda = true;
            abajo = false;
            animI.start();
            x -= 100 * (float) delta / 1000;
            i = 4;
        } else if (container.getInput().isKeyDown(Input.KEY_UP) && dentro) {
            derecha = false;
            arriba = true;
            izquierda = false;
            abajo = false;
            animAr.start();
            y -= 100 * (float) delta / 1000;
            i = 8;
        } else if (container.getInput().isKeyDown(Input.KEY_DOWN) && dentro) {
            derecha = false;
            arriba = false;
            izquierda = false;
            abajo = true;
            animAb.start();
            y += 100 * (float) delta / 1000;
            i = 2;
        } else {
            animD.stop();
            animI.stop();
            animAr.stop();
            animAb.stop();
            animD.setCurrentFrame(1);
            animI.setCurrentFrame(1);
            animAr.setCurrentFrame(1);
            animAb.setCurrentFrame(1);
        }

        col.actualizar(x, y);
        if (col.cambiarMapa4()) {
            game.enterState(4);
        }
        dentro = true;
    }

    @Override
    public int getID() {
        return 3;
    }
}
