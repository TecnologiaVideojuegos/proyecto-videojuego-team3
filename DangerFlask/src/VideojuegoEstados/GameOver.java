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
public class GameOver extends BasicGameState {

      //Atributos
  private Image gameover;

     //Constructor
   public GameOver() {
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        //Iniciamos la imagen
        gameover = new Image("./Botones/gameover.jpg");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        //Dibujamos la imagen
        gameover.draw(41, 0);
        
        //Instrucciones a seguir en este estado
        g.drawString("Pulse ESC para volver al menú principal", 10, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        //Si pulsamos ESC nos manda al estado 0
        if (container.getInput().isKeyDown(Input.KEY_ESCAPE)) {
            game.enterState(0);
        }
    }

    //Este estado es el estado 7
    @Override
    public int getID() {
        return 7;
    }
}
