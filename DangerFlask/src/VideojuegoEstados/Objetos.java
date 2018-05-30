package VideojuegoEstados;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Objetos {

    private Colisiones col;

    public Objetos(Colisiones col) {
        this.col = col;
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

    public void dibuja1() throws SlickException {
        if (a) {
            botiquin.draw(992, 96);
        }
        if (b) {
            tarjeta1.draw(48, 128);
            tarj1.setX(48);
            tarj1.setY(128);
        }
        if (c) {
            tarjeta2.draw(1072, 176);
            tarj2.setX(1072);
            tarj2.setY(176);
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

    public void colObj(int xb, int yb, int xt, int yt, int xt_, int yt_) {
        bot = new Rectangle(xb, yb, 10, 23);
        tarj1 = new Rectangle(xt, yt, 20, 20);
        tarj2 = new Rectangle(xt_, yt_, 20, 20);
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
