package VideojuegoEstados;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author SergioSanzSactistan
 */
public class Menu extends BasicGameState {

    private Image fondo, jugar, controles, opciones;
    private Music menutheme;

    public Menu() {
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        fondo = new Image("./Botones/Fondo.png");
        jugar = new Image("./Botones/ButtonPlay.png");
        controles = new Image("./Botones/ButtonControls.png");
        opciones = new Image("./Botones/ButtonOptions.png");
        menutheme = new Music("./Musica/Menu.ogg");
        menutheme.loop(1f, 0.5f);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        fondo.draw(2, 0);
        jugar.draw(105, 522);
        controles.draw(465, 522);
        opciones.draw(820, 522);
        //g.drawString("X: " + container.getInput().getMouseX() + " Y: " + container.getInput().getMouseY(), 10, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (container.getInput().isMouseButtonDown(0)) {
            if (container.getInput().getMouseX() < 388 && container.getInput().getMouseX() > 105
                    && container.getInput().getMouseY() < 590 && container.getInput().getMouseY() > 522) {
                menutheme.stop();
                game.enterState(1);
            }
            if (container.getInput().getMouseX() < 746 && container.getInput().getMouseX() > 465
                    && container.getInput().getMouseY() < 590 && container.getInput().getMouseY() > 522) {
                game.enterState(8);
            }
            if (container.getInput().getMouseX() < 1100 && container.getInput().getMouseX() > 820
                    && container.getInput().getMouseY() < 590 && container.getInput().getMouseY() > 522) {
                game.enterState(9);
            }
        }
    }

    @Override
    public int getID() {
        return 0;
    }
}
