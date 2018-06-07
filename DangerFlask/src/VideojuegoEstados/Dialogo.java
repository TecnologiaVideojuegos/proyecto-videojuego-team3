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
public class Dialogo extends BasicGameState {

    private Image julian, zacarias;
    private int i = 0;

    public Dialogo() {
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        julian = new Image("./juego/julian.png");
        zacarias = new Image("./juego/zacarias.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.scale(6f, 6f);
        julian.draw(10, 20);
        zacarias.draw(170, 60);
        g.resetTransform();
        g.drawRect(170, 130, 875, 145);
        g.drawRect(140, 370, 875, 145);
        g.drawString("JULIAN:", 180, 140);
        g.drawString("ZACARIAS:", 150, 380);
        g.drawString("Pulse ENTER para avanzar", 10, 10);
        if (i == 1) {
            g.drawString("TEXTO1", 180, 160);
        }
        if (i == 2) {
            g.drawString("TEXTO2", 150, 400);
        }
        if (i == 3) {
            g.drawString("TEXTO3", 180, 160);
        }
        if (i == 4) {
            g.drawString("TEXTO4", 150, 400);
        }
        if (i == 5) {
            g.drawString("TEXTO5", 180, 160);
        }
        if (i == 6) {
            g.drawString("TEXTO6", 150, 400);
        }
        if (i == 7) {
            g.drawString("TEXTO7", 180, 160);
        }
        if (i == 8) {
            g.drawString("TEXTO8", 150, 400);
        }
        if (i == 9) {
            g.drawString("TEXTO9", 180, 160);
        }
        if (i == 10) {
            g.drawString("TEXTO10", 150, 400);
        }
        if (i == 11){
            game.enterState(0);
        }
        //CUANDO EL DIALOGO ESTE ESCRITO SE TERMINARA
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (container.getInput().isKeyPressed(Input.KEY_ENTER)) {
            i++;
        }
    }

    @Override
    public int getID() {
        return 5;
    }
}
