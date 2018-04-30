package Videojuego;

/**
 *
 * @author SergioSanzSacristan
 */
import org.newdawn.slick.*;

/*import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;*/
public class HolaSlick extends BasicGame {

    private AppGameContainer contenedor;
    private Image sprite;
    private Input entrada;
    private float x = 100, y = 150;

    public HolaSlick(String title) throws SlickException {
        //Necesitamos llamar al constructor padre.
        //title es la cadena de caracteres que aparecera en la barra de titulo
        super(title);
        contenedor = new AppGameContainer(this);
        contenedor.setDisplayMode(850, 500, false);
    }

    public void iniciar() throws SlickException {
        contenedor.start();
    }

    /**
     * Renderizar en pantalla un juego
     *
     * @param container el contenedor de juegos
     * @param g controlador grafico de nuestro juego
     */
    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        /*g.drawString("Hola, Slick", 100, 200);
        g.drawLine(50, 60, 100, 90);
        g.fillRect(250, 100, 50, 20);
        g.fillOval(60, 90, 100, 100);
        g.drawImage(sprite, 300, 250);*/
        //Que solo se vea esta imagen si solo se pulsa espacio

        sprite.draw(x, y);
    }

    /**
     * Inicializar el juego
     *
     * @param container contenedor del juego
     */
    @Override
    public void init(GameContainer container) throws SlickException {
        sprite = new Image("./testdata/logo.gif");
        entrada = contenedor.getInput();
    }

    /**
     * Actualizar nuestro juego
     *
     * @param container contenedor del juego
     * @param delta numero de milisegundos que fue llamado update
     */
    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        /**
         * Si hemos pulsado una tecla de direccion, desplazamos la imagen en el
         * sentido UP -> Subimos la imagen DOWN -> Bajamos la imagen LEFT -> Izq
         * RIGHT -> Der
         */
        if (entrada.isKeyDown(Input.KEY_UP)) {
            y--;
        }
        if (entrada.isKeyDown(Input.KEY_DOWN)) {
            y++;
        }
        if(entrada.isKeyDown(Input.KEY_LEFT)){
            x--;
        }
        if(entrada.isKeyDown(Input.KEY_RIGHT)){
            x++;
        }
    }

    public static void main(String args[]) {
        try {
            HolaSlick hola = new HolaSlick("Hola, Slick");
            hola.iniciar();
        } catch (SlickException slick) {
            slick.printStackTrace();
        }
    }
}
