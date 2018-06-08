/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VideojuegoEstados;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Usuario
 */
public class Menu extends BasicGameState {

    private Image fondo, jugar, controles, opciones;
    private Rectangle rectJugar;

    public Menu() {
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        fondo = new Image("./Botones/Fondo.png");
        jugar = new Image("./Botones/ButtonPlay.png");
        controles = new Image("./Botones/ButtonControls.png");
        opciones = new Image("./Botones/ButtonOptions.png");
        rectJugar = new Rectangle(105, 522, 283, 69);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        fondo.draw(2, 0);
        jugar.draw(105, 522);
        controles.draw(465, 522);
        opciones.draw(820, 522);
        g.draw(rectJugar);
        g.drawString("X: " + container.getInput().getMouseX() + " Y: " + container.getInput().getMouseY(), 10, 10);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
//        if (container.getInput().isMouseButtonDown(Input.KEY_LEFT)) {
//            if (container.getInput().getMouseX() < 388 && container.getInput().getMouseX() > 105
//                    && container.getInput().getMouseY() < 591 && container.getInput().getMouseY() > 522) {
//                game.enterState(5);
//            }
//        }
    }

    @Override
    public int getID() {
        return 6;
    }
}
