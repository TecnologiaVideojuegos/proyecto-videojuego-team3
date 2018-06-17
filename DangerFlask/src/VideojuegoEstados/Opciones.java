package VideojuegoEstados;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author SergioSanzSacristan
 */
public class Opciones extends BasicGameState {

    //Atributos
    private Image opciones, contorno, contorno2;
    private final Sonido sonido;
    private final Music menutheme;

    //Constructor
    public Opciones(Sonido sonido, Music menutheme) {
        this.sonido = sonido;
        this.menutheme = menutheme;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        //Iniciamos las imagenes
        opciones = new Image("./Botones/Opciones.png");
        contorno = new Image("./Botones/contorno.png");
        contorno2 = new Image("./Botones/contorno2.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        //Dibujamos las imagenes
        opciones.draw(0, 0);

        //Dependiendo de si esta activado o no la música se selecciona una opción u otra   
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

        //Instrucciones a seguir en este estado
        g.setColor(Color.black);
        g.drawString("Pulse ESC para volver al menú.", 10, 10);
        g.setColor(Color.white);
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        //Si pulsamos ESC nos manda al estado 0
        if (container.getInput().isKeyDown(Input.KEY_ESCAPE)) {
            game.enterState(0);
        }

        //Detectamos cuando clickamos
        if (container.getInput().isMouseButtonDown(0)) {
            //Si damos a activar la música el booleano de la música se pone a true
            if (container.getInput().getMouseX() < 930 && container.getInput().getMouseX() > 780
                    && container.getInput().getMouseY() < 315 && container.getInput().getMouseY() > 180) {
                sonido.setMusicaOn(true);
                menutheme.loop(1f, 0.5f);
            }
            //Si damos a desactivar la música el booleano de la música se pone a false
            if (container.getInput().getMouseX() < 430 && container.getInput().getMouseX() > 280
                    && container.getInput().getMouseY() < 315 && container.getInput().getMouseY() > 180) {
                sonido.setMusicaOn(false);
                menutheme.stop();
            }
            //Si damos a activar el sonido el booleano del sonido se pone a true
            if (container.getInput().getMouseX() < 1075 && container.getInput().getMouseX() > 953
                    && container.getInput().getMouseY() < 482 && container.getInput().getMouseY() > 400) {
                sonido.setSonidoOn(true);
            }
            //Si damos a desactivar el sonido el booleano del sonido se pone a false
            if (container.getInput().getMouseX() < 252 && container.getInput().getMouseX() > 130
                    && container.getInput().getMouseY() < 485 && container.getInput().getMouseY() > 403) {
                sonido.setSonidoOn(false);
            }
        }
    }

    //Este estado es el estado 9
    @Override
    public int getID() {
        return 9;
    }
}
