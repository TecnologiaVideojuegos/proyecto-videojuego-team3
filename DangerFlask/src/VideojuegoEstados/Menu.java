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

    //Atributos
    private Image fondo, jugar, controles, opciones;
    private Music menutheme;
    private boolean b = false;
    private Sonido sonido;

    //Constructor
    public Menu(Sonido sonido, Music menutheme) {
        this.menutheme = menutheme;
        this.sonido = sonido;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        //Iniciamos el fondo y los botones del menú
        fondo = new Image("./Botones/Fondo.png");
        jugar = new Image("./Botones/ButtonPlay.png");
        controles = new Image("./Botones/ButtonControls.png");
        opciones = new Image("./Botones/ButtonOptions.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        //Colocamos el fondo y los botones
        fondo.draw(2, 0);
        jugar.draw(105, 522);
        controles.draw(465, 522);
        opciones.draw(820, 522);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        //Si el boolean b que sirve para detectar cuando nos encontramos en este estado...
        //... y la música está activada, iniciamos la música del menú
        if (!b && sonido.isMusicaOn()) {
            menutheme.loop(1, 0.5f);
            b = true;
        }
        //Detectamos cuando clickamos en el menú
        if (container.getInput().isMouseButtonDown(0)) {
            //Si damos al botón JUGAR para la música pone el b a falso y entra en el estado 1
            if (container.getInput().getMouseX() < 388 && container.getInput().getMouseX() > 105
                    && container.getInput().getMouseY() < 590 && container.getInput().getMouseY() > 522) {
                menutheme.stop();
                b = false;
                game.enterState(1);
            }
            //Si damos al botón CONTROLES entramos al estado 8
            if (container.getInput().getMouseX() < 746 && container.getInput().getMouseX() > 465
                    && container.getInput().getMouseY() < 590 && container.getInput().getMouseY() > 522) {
                game.enterState(8);
            }
            //Si damos al botón OPCIONES entramos al estado 9
            if (container.getInput().getMouseX() < 1100 && container.getInput().getMouseX() > 820
                    && container.getInput().getMouseY() < 590 && container.getInput().getMouseY() > 522) {
                game.enterState(9);
            }
        }
    }

    //Este estado es el estado 0
    @Override
    public int getID() {
        return 0;
    }
}
