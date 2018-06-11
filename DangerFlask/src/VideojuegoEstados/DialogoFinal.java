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
public class DialogoFinal extends BasicGameState {

    private Image julian, zacarias;
    private int i = 0;

    public DialogoFinal() {
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
        g.drawString("Pulse ESC para saltar el diálogo", 10, 40);
        if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
            game.enterState(0);
        }
        if (i == 1) {
            g.drawString("¡Llegué! He tenido bastante suerte. Veamos dónde está el suero...", 180, 160);
        }
        if (i == 2) {
            g.drawString("Aquí no... 60... 84... 99... 100... 101... 102... Aquí. Ésta es. Menos mal que Zacarías toma \nestas precauciones.", 180, 160);
        }
        if (i == 3) {
            g.drawString("...", 180, 160);
        }
        if (i == 4) {
            g.drawString("Zacarías... no está aquí. No me digas que...", 180, 160);
        }
        if (i == 5) {
            g.drawString("Luego no te atrevas a darme charlas sobre mi actitud pesimista.", 150, 400);
        }
        if (i == 6) {
            g.drawString("¡Doctor! ¡Menos mal! Ya tengo la cura.", 180, 160);
        }
        if (i == 7) {
            g.drawString("A ver... Sí, es esa. Vámonos de aquí, Julian. Estoy hasta las narices de este sitio. Ya \navisaremos de la situación del laboratorio. ", 150, 400);
        }
        if (i == 8) {
            g.drawString("Bien, ¡no puedo esperar más! ", 180, 160);
        }        
        if (i == 9) {
            game.enterState(0);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        if (container.getInput().isKeyPressed(Input.KEY_ENTER)) {
            i++;
        }
    }

    @Override
    public int getID() {
        return 6;
    }
}