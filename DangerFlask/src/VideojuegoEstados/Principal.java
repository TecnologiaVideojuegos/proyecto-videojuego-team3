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
    private Vidas vidas = new Vidas(1);

    public Principal() throws SlickException {
        super("Danger Flask");
        container = new AppGameContainer(this);
        container.setDisplayMode(1220, 640, false);
        container.setShowFPS(false);
        container.start();
    }

    @Override
    public void initStatesList(GameContainer arg0) throws SlickException {
        this.addState(new Mapa1(vidas));
        this.addState(new Mapa2(vidas));
        this.addState(new Mapa3(vidas));
        this.addState(new Mapa4(vidas));
        this.addState(new Portada());
    }

    public static void main(String[] argv) {
        try {
            Principal juego = new Principal();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

}
