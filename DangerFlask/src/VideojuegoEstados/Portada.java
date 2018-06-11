package VideojuegoEstados;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author SergioSanzSacristan
 */
public class Portada extends BasicGameState {

    private Image portada;

    public Portada() {
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        portada = new Image("./juego/portada.jpg");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        portada.draw(41, 0);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        
    }

    @Override
    public int getID() {
        return 7;
    }
}
