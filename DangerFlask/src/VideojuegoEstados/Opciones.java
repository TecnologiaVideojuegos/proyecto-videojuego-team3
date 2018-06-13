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
public class Opciones extends BasicGameState {

    private Image opciones, contorno, contorno2;
    private Sonido sonido;

    public Opciones(Sonido sonido) {
        this.sonido = sonido;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        opciones = new Image("./Botones/Opciones.png");
        contorno = new Image("./Botones/contorno.png");
        contorno2 = new Image("./Botones/contorno2.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        opciones.draw(0, 0);
        if (sonido.isMusicaOn()) {
            contorno.draw(775, 170);
        }
        if (!sonido.isMusicaOn()) {
            contorno.draw(275, 170);
        }
        if (sonido.isSonidoOn()) {
            contorno2.draw(943, 390);
        }
        if (!sonido.isSonidoOn()) {
            contorno2.draw(120, 393);
        }
        g.drawString("Pulse ESC para volver al menú.", 10, 10);
        //g.drawString("X: " + container.getInput().getMouseX() + " Y: " + container.getInput().getMouseY(), 10, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (container.getInput().isKeyDown(Input.KEY_ESCAPE)) {
            game.enterState(0);
        }
        if (container.getInput().isMouseButtonDown(0)) {
            if (container.getInput().getMouseX() < 930 && container.getInput().getMouseX() > 780
                    && container.getInput().getMouseY() < 315 && container.getInput().getMouseY() > 180) {
                sonido.setMusicaOn(true);
            }
            if (container.getInput().getMouseX() < 430 && container.getInput().getMouseX() > 280
                    && container.getInput().getMouseY() < 315 && container.getInput().getMouseY() > 180) {
                sonido.setMusicaOn(false);
            }
            if (container.getInput().getMouseX() < 1075 && container.getInput().getMouseX() > 953
                    && container.getInput().getMouseY() < 482 && container.getInput().getMouseY() > 400) {
                sonido.setSonidoOn(true);
            }
            if (container.getInput().getMouseX() < 252 && container.getInput().getMouseX() > 130
                    && container.getInput().getMouseY() < 485 && container.getInput().getMouseY() > 403) {
                sonido.setSonidoOn(false);
            }
        }
    }

    @Override
    public int getID() {
        return 9;
    }
}
