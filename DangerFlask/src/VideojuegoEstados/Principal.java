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

    public Principal() throws SlickException {
        super("Danger Flask");
        container = new AppGameContainer(this);
        container.setDisplayMode(1220, 640, false);
        container.setShowFPS(false);
        container.start();
    }

    @Override
    public void initStatesList(GameContainer arg0) throws SlickException {
        this.addState(new Mapa1());
        this.addState(new Mapa2());
        this.addState(new Mapa3());
        this.addState(new Mapa4());
    }

    public static void main(String[] argv) {
        try {
            Principal juego = new Principal();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
