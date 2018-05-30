package VideojuegoEstados;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Objetos {

    private Colisiones col;
    private int xb, yb, x1, y1, x2, y2;

    public Objetos(Colisiones col, int xb, int yb, int x1, int y1, int x2, int y2) {
        this.col = col;
        this.xb = xb;
        this.yb = yb;
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    private Image botiquin, tarjeta1, tarjeta2;
    private Rectangle bot, tarj1, tarj2;
    private boolean a = true, b = true, c = true;

    public void setA(boolean a) {
        this.a = a;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public void setC(boolean c) {
        this.c = c;
    }

    public void creaObjetos() throws SlickException {
        botiquin = new Image("./Objetos/spr_adrenalina.png");
        tarjeta1 = new Image("./Objetos/spr_tarjeta.png");
        tarjeta2 = new Image("./Objetos/spr_tarjeta2.png");
    }

    public void dibuja() throws SlickException {
        if (a) {
            botiquin.draw(xb,yb);
        }
        if (b) {
            tarjeta1.draw(x1,y1);
            tarj1.setX(x1);
            tarj1.setY(y1);
        }
        if (c) {
            tarjeta2.draw(x2,y2);
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

    public void dibuja2() throws SlickException {

    }

    public void colObj() {
        bot = new Rectangle(xb, yb, 10, 23);
        tarj1 = new Rectangle(x1, y1, 20, 20);
        tarj2 = new Rectangle(x2, y2, 20, 20);
//        bot = new Rectangle(992, 96, 10, 23);
//        tarj1 = new Rectangle(48, 128, 20, 20);
//        tarj2 = new Rectangle(1072, 176, 20, 20);
    }

    public void colObj2() {
        bot.setX(0);
        bot.setY(0);
        tarj1.setX(0);
        tarj1.setY(0);
        tarj2.setX(0);
        tarj2.setY(0);
    }

    public boolean botCol() {
        if (col.getRectAnim().intersects(bot)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean tar1Col() {
        if (col.getRectAnim().intersects(tarj1)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean tar2Col() {
        if (col.getRectAnim().intersects(tarj2)) {
            return true;
        } else {
            return false;
        }
    }
}
