package Sesion3_estados;

/**
 *
 * @author SergioSanzSacristan
 */
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;

public class Principal extends StateBasedGame {

    private AppGameContainer contenedor;

    public Principal(String title) throws SlickException {
        //Necesitamos llamar al constructor padre.
        //title es la cadena de caracteres que aparecera en la barra de titulo
        super(title);
        contenedor = new AppGameContainer(this);
        contenedor.setDisplayMode(640, 360, false);
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
        g.drawString("Hola, Slick", 100, 200);
        g.drawLine(50,60,100,90);
        g.fillRect(250, 100, 50, 20);
        g.fillOval(60, 90, 100, 100);
    }

    /**
     * Inicializar el juego
     *
     * @param container contenedor del juego
     */
    @Override
    public void init(GameContainer container) throws SlickException {

    }

    /**
     * Actualizar nuestro juego
     *
     * @param container contenedor del juego
     * @param delta numero de milisegundos que fue llamado update
     */
    @Override
    public void update(GameContainer container, int delta) throws SlickException {

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
