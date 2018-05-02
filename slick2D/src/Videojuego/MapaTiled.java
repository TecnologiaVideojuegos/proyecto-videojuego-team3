package Videojuego;

/*import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;*/
import java.util.ArrayList;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

/**
 * A test of the tile map system based around the TilED
 * (http://www.mapeditor.org) tool
 *
 * @author kevin
 */
public class MapaTiled extends BasicGame {

    /**
     * The tile map we're going to load and render
     */
    private TiledMap mapa;
    private AppGameContainer container;
    private SpriteSheet spriteD, spriteI, spriteAr, spriteAb;
    private Animation animD, animI, animAr, animAb;
    private float x = 160.0f, y = 300.0f;
    private boolean derecha = true, dentro = true, arriba = false, izquierda = false, abajo = false;
    private Rectangle homer, rect1, rect2;
    private int i;
    private Colisiones col = new Colisiones();
    private ArrayList coor = new ArrayList();

    public MapaTiled() throws SlickException {
        super("PARTE DE ARRIBA DE LA VENTANA");
        container = new AppGameContainer(this);
        container.setDisplayMode(1220, 640, false);
    }

    public void iniciar() throws SlickException {
        container.start();
    }

    public static void main(String[] argv) {
        try {
            MapaTiled mapaTiled = new MapaTiled();
            mapaTiled.iniciar();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException {

        mapa = new TiledMap("./juego/mapa_final1.tmx", "juego");
        spriteD = new SpriteSheet("./juego/animD.png", 16, 25);
        animD = new Animation(spriteD, 100);
        spriteI = new SpriteSheet("./juego/animI.png", 16, 25);
        animI = new Animation(spriteI, 100);
        spriteAr = new SpriteSheet("./juego/animAr.png", 17, 27);
        animAr = new Animation(spriteAr, 100);
        spriteAb = new SpriteSheet("./juego/animAb.png", 17, 27);
        animAb = new Animation(spriteAb, 100);
        col.paredes(x, y, animD);
        /*homer = new Rectangle(x, y, animD.getWidth(), animD.getHeight());
        rect1 = new Rectangle(256 + 17, 160, 160 - 34, 256);
        rect2 = new Rectangle(128 + 17, 320, 384 - 34, 96);*/
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        if (col.animDentro()) {
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

        /*homer.setX(x);
        homer.setY(y);*/
        col.actualizar(x, y);
        dentro = true;
    }

    @Override
    public void render(GameContainer container, Graphics g) {

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
        /*if (homer.intersects(rect1)) {
            g.drawString("ESTA DENTRO", 1000, 10);
        }*/
        //g.drawRect(homer.getX(), homer.getY(), homer.getWidth(), homer.getHeight());
    }

}
