package VideojuegoEstados;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author SergioSanzSacristan
 */
public class Principal extends StateBasedGame {
    
    private AppGameContainer container;
    private Vidas vidas = new Vidas(6);
    
    public Principal() throws SlickException {
        super("Danger Flask");
        container = new AppGameContainer(this);
        container.setDisplayMode(1220, 640, false);
        container.setShowFPS(false);
        container.start();
    }
    
    @Override
    public void initStatesList(GameContainer arg0) throws SlickException {
        this.addState(new Menu());          //0
        this.addState(new Dialogo());       //1
        this.addState(new Mapa1(vidas));    //2
        this.addState(new Mapa2(vidas));    //3
        this.addState(new Mapa3(vidas));    //4
        this.addState(new Mapa4(vidas));    //5
        this.addState(new DialogoFinal());  //6
        this.addState(new Portada());       //7
        this.addState(new Controles());     //8
        this.addState(new Opciones());      //9
    }
    
    public static void main(String[] argv) {
        try {
            Principal juego = new Principal();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
    
}
