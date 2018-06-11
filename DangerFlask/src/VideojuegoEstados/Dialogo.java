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
        g.drawString("X: " + container.getInput().getMouseX() + " Y: " + container.getInput().getMouseY(), 10, 10);
        g.drawString("JULIAN:", 180, 140);
        g.drawString("ZACARIAS:", 150, 380);
        //g.drawString("Pulse ENTER para avanzar", 10, 10);
        if (i == 1) {
            g.drawString("Julián, la cámara.", 150, 400);
        }
        if (i == 2) {
            g.drawString("Sí, doctor. Y... grabando.", 180, 160);
        }
        if (i == 3) {
            g.drawString("23 de noviembre de 2078. Prueba número 103. Procedo a aplicarle el suero al sujeto nº 12...", 150, 400);
        }
        if (i == 4) {
            g.drawString("...", 180, 160);
        }
        if (i == 5) {
            g.drawString("Los resultados, los cuales seguramente serán otra mierd...", 150, 400);
        }
        if (i == 6) {
            g.drawString("¡Doctor!", 180, 160);
        }
        if (i == 7) {
            g.drawString("Perdón, perdón. Los resultados deberían manifestarse en tres horas o así, hasta entonces \nesperaremos con las fuerzas que nos queda. Que la ciencia nos ayude. Un saludo. Ya está, \npara de grabar.", 150, 400);
        }
        if (i == 8) {
            g.drawString("Hecho.", 180, 160);
        }
        if (i == 9) {
            g.scale(2, 2);
            g.drawString("PASAN 3 HORAS", 240, 150);
            g.resetTransform();
        }
        if (i == 10) {
            g.drawString("Doctor, ya han pasado las tres horas. Voy a por la cámara.", 180, 160);
        }
        if (i == 11) {
            g.drawString("Ni te molestes, Julián. Va a ser grabar otro fracaso.", 150, 400);
        }
        if (i == 12) {
            g.drawString("¿Qué demonios dices, doctor?  Basta. No aguanto tu actitud, ¿se te ha olvidado el peso que \nacarreamos? ¿Se te ha olvidado Leo?", 180, 160);
        }
        if (i == 13) {
            g.drawString("¡No vuelvas a mencionar a mi hijo! ¡Claro que no se me ha olvidado, pero es que esto no nos \nestá llevando a ningún lado! Todo lo que estuve investigando años antes no me ha estado \nsirviendo para nada.", 150, 400);
        }
        if (i == 14) {
            g.drawString("Entiendo cómo te sientes, cada día que no encontramos la cura para esta maldita peste, es un \ndía más que siento que voy a perder a mi madre. Pero, tenemos que aguantar la presión...\npor favor.", 180, 160);
        }
        if (i == 15) {
            g.drawString("Lo sé, lo sé. Lo siento, Julián. No te preocupes por mí. Veamos los resultados.", 150, 400);
        }
        if (i == 16) {
            g.scale(2, 2);
            g.drawString("VAN A VER LOS RESULTADOS", 200, 150);
            g.resetTransform();
        }        
        if (i == 17) {
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
