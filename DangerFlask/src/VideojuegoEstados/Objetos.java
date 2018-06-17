package VideojuegoEstados;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author SergioSanzSactistan
 */
public class Objetos {

    //Atributos
    private final Colisiones col;
    private final int xb, yb, x1, y1, x2, y2;
    private Image botiquin, tarjeta1, tarjeta2;
    private Rectangle bot, tarj1, tarj2;
    private boolean a = true, b = true, c = true;

    //Constructor
    public Objetos(Colisiones col, int xb, int yb, int x1, int y1, int x2, int y2) {
        this.col = col;
        this.xb = xb;
        this.yb = yb;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    //Métodos Set necesarios
    public void setA(boolean a) {
        this.a = a;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    //Este método inicia los objetos que nos encontraremos en el mapa
    public void creaObjetos() throws SlickException {
        botiquin = new Image("./Objetos/spr_adrenalina.png");
        tarjeta1 = new Image("./Objetos/spr_tarjeta.png");
        tarjeta2 = new Image("./Objetos/spr_tarjeta2.png");
    }

    //Este método dibuja las imagenes en el mapa
    public void dibuja() throws SlickException {
        //Si los booleanos a, b y c están a true si alguno esta a false, ese objeto no se dibuja
        if (a) {
            botiquin.draw(xb, yb);
        }
        if (b) {
            tarjeta1.draw(x1, y1);
            tarj1.setX(x1);
            tarj1.setY(y1);
        }
        if (c) {
            tarjeta2.draw(x2, y2);
            tarj2.setX(x2);
            tarj2.setY(y2);
        }
        if (!a) {
            bot.setX(0);
            bot.setY(0);
        }
        if (!b) {
            tarj1.setX(0);
            tarj1.setY(0);
        }
        if (!c) {
            tarj2.setX(0);
            tarj2.setY(0);
        }
    }

    //Este método sirve para poner la posicion a los rectangulos que gestionaran las colisiones con el personaje
    public void colObj() {
        bot = new Rectangle(xb, yb, 10, 23);
        tarj1 = new Rectangle(x1, y1, 20, 20);
        tarj2 = new Rectangle(x2, y2, 20, 20);
    }

    //Este método devuelve true si el personaje colisiona con el botiquin
    public boolean botCol() {
        if (col.getRectAnim().intersects(bot)) {
            return true;
        } else {
            return false;
        }
    }

    //Este método devuelve true si el personaje colisiona con la tarjeta 1
    public boolean tar1Col() {
        if (col.getRectAnim().intersects(tarj1)) {
            return true;
        } else {
            return false;
        }
    }

    //Este método devuelve true si el personaje colisiona con la tarjeta 2
    public boolean tar2Col() {
        if (col.getRectAnim().intersects(tarj2)) {
            return true;
        } else {
            return false;
        }
    }
}
