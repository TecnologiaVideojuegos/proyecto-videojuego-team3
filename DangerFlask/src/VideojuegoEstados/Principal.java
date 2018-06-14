package VideojuegoEstados;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author SergioSanzSacristan
 */
public class Principal extends StateBasedGame {

    //Atributos
    private AppGameContainer container;
    private Vidas vidas = new Vidas(6);
    private Sonido sonido = new Sonido();
    private Music menutheme = new Music("./Musica/Menu.ogg");

    //Constructor
    public Principal() throws SlickException {
        super("Danger Flask");
        container = new AppGameContainer(this);
        container.setDisplayMode(1220, 640, false);
        container.setShowFPS(false);
        container.start();
    }

    //Iniciamos los estados
    @Override
    public void initStatesList(GameContainer arg0) throws SlickException {
        this.addState(new Menu(sonido, menutheme));     //0
        this.addState(new Dialogo());                   //1
        this.addState(new Mapa1(vidas, sonido));        //2
        this.addState(new Mapa2(vidas, sonido));        //3
        this.addState(new Mapa3(vidas, sonido));        //4
        this.addState(new Mapa4(vidas, sonido));        //5
        this.addState(new DialogoFinal());              //6
        this.addState(new GameOver());                  //7
        this.addState(new Controles());                 //8
        this.addState(new Opciones(sonido, menutheme)); //9
    }

    public static void main(String[] argv) {
        try {
            Principal juego = new Principal();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
