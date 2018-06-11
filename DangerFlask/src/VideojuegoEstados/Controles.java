package VideojuegoEstados;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author SergioSanzSacristan
 */
public class Controles extends BasicGameState {

    private Image controles;

    public Controles() {
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        controles = new Image("./Botones/Controles.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        controles.draw(0, 0);
        g.drawString("Pulse ESC para volver al menú.", 10, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if(container.getInput().isKeyDown(Input.KEY_ESCAPE)){
            game.enterState(0);
        }
    }

    @Override
    public int getID() {
        return 8;
    }
}
