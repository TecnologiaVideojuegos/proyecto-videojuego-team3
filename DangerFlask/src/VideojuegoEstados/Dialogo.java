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
        g.drawString("Pulse ESC para saltar el diálogo", 10, 40);
        if(container.getInput().isKeyPressed(Input.KEY_ESCAPE)){
            game.enterState(2);
        }
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
            g.drawString("Vale, nada mal por aquí... veamos los anticuerpos...", 150, 400);
        }
        if (i == 18) {
            g.drawString("¡Doctor!", 180, 160);
        }
        if (i == 19) {
            g.drawString("No puede ser.", 150, 400);
        }
        if (i == 20) {
            g.drawString("¡Sí puede ser, doctor! ¡Sí puede! ¡Lo logramos!", 180, 160);
        }
        if (i == 21) {
            g.drawString("Es-espera, Julián. Esto no puede ser... no me lo creo...", 150, 400);
        }
        if (i == 22) {
            g.drawString("¡Mira el maldito virus! ¡Está siendo aniquilado! ", 180, 160);
        }
        if (i == 23) {
            g.drawString("No es un sueño... ¡Hemos salvado al mundo Julián! ¡A tu madre! A... ¡A Leo!", 150, 400);
        }
        if (i == 24) {
            g.drawString("¡Pero no llores que lloro yo también!", 180, 160);
        }
        if (i == 25) {
            g.drawString("Vamos a tirar todo esto ya. ¡Adiós a todas las otras pruebas! No quiero verlas ni en pintura.\nVoy", 150, 400);
        }
        if (i == 26) {
            g.scale(2, 2);
            g.drawString("SUENA ALGO", 250, 150);
            g.resetTransform();
        }
        if (i == 27) {
            g.drawString("¡Doctor! El sujeto número 11 y 8 están descontrolados. Parece ser que los sueros que les dimos \nlos están... ¡¿Mutando?! ¡Van a romper la jaula!", 180, 160);
        }
        if (i == 28) {
            g.drawString("¡No! ¡Que no escapen! ¡Van a romper todo! ¡No dejes que te arañen! ¡Un mínimo contacto con tu \nsangre y te contagiarán el virus en su peor fase!", 150, 400);
        }
        if (i == 29) {
            g.drawString("¡No! ¡La ha roto! ¡La cura! ¡No puede ser! ", 180, 160);
        }
        if (i == 30) {
            g.drawString("¡Tranquilo! ¡Tranquilo! Siempre guardo otro suero idéntico en la despensa del laboratorio. Pero,\ntengo que ir primero a activar el sistema de emergencia para que no salgan de aquí. Ve yendo \nhacia la despensa, te alcanzaré. ¡Recuerda que ahora necesitarás las tarjetas para abrir las \npuertas!", 150, 400);
        }
        if (i == 31) {
            g.drawString("¿Y eso estaba...? ¡Da igual, voy para allá! Pero... están atacando a todos los demás sujetos. \nDentro de poco tendremos un ejército de monstruos tras nosotros. ¡Ten cuidado, Zacarías!", 180, 160);
        }
        if (i == 32) {
            g.drawString("Eso me temo.  Descuida.", 150, 400);
        }        
        if (i == 33) {
            game.enterState(2);
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
        return 1;
    }
}
