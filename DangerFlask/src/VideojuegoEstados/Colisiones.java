package VideojuegoEstados;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author SergioSanzSacristan
 */
public class Colisiones {

    private float x_, y_;
    private int tarjeta1 = 0, tarjeta2 = 0, tarjeta3 = 0, tarjeta4 = 0;

    public Colisiones(float x, float y) {
        this.x_ = x;
        this.y_ = y;
    }

    public int getTarjeta1() {
        return tarjeta1;
    }

    public int getTarjeta2() {
        return tarjeta2;
    }

    public int getTarjeta3() {
        return tarjeta3;
    }

    public int getTarjeta4() {
        return tarjeta4;
    }

    public void setTarjeta1(int tarjeta1) {
        this.tarjeta1 = tarjeta1;
    }

    public void setTarjeta2(int tarjeta2) {
        this.tarjeta2 = tarjeta2;
    }

    public void setTarjeta3(int tarjeta3) {
        this.tarjeta3 = tarjeta3;
    }

    public void setTarjeta4(int tarjeta4) {
        this.tarjeta4 = tarjeta4;
    }

    private Rectangle rectSalida1 = new Rectangle(1150, 495, 55, 30);
    private Rectangle rectSalida2 = new Rectangle(1167, 270, 50, 25);
    private Rectangle rectSalida3 = new Rectangle(335, 592, 50, 50);
    private Rectangle rectSalida4 = new Rectangle(478, 592, 50, 50);
    private Rectangle cambiarMapa1 = new Rectangle(1213, 499, 1, 45);
    private Rectangle cambiarMapa2 = new Rectangle(1213, 275, 1, 45);
    private Rectangle cambiarMapa3 = new Rectangle(336, 638, 45, 1);
    private Rectangle cambiarMapa4 = new Rectangle(480, 638, 45, 1);
    private Rectangle rectAnim = new Rectangle(x_ + 2, y_ + 2, 12, 23);

    public Rectangle getRectAnim() {
        return rectAnim;
    }

    public boolean animDentro1(boolean[][] paredes, float x, float y) {
        if (((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) && rectAnim.intersects(rectSalida1)
                && tarjeta1 == 2) {
            return false;
        } else if ((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean animDentro2(boolean[][] paredes, float x, float y) {
        if (((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) && rectAnim.intersects(rectSalida2)
                && tarjeta2 == 2) {
            return false;
        } else if ((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean animDentro3(boolean[][] paredes, float x, float y) {
        if (((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) && rectAnim.intersects(rectSalida3)
                && tarjeta3 == 2) {
            return false;
        } else if ((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean animDentro4(boolean[][] paredes, float x, float y) {
        if (((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) && rectAnim.intersects(rectSalida4)
                && tarjeta4 == 2) {
            return false;
        } else if ((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) {
            return true;
        } else {
            return false;
        }
    }

    public void actualizar(float x, float y) {
        rectAnim.setX(x + 2);
        rectAnim.setY(y + 2);
    }

    public boolean cambiarMapa1() {
        if (rectAnim.intersects(cambiarMapa1)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cambiarMapa2() {
        if (rectAnim.intersects(cambiarMapa2)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cambiarMapa3() {
        if (rectAnim.intersects(cambiarMapa3)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean cambiarMapa4() {
        if (rectAnim.intersects(cambiarMapa4)) {
            return true;
        } else {
            return false;
        }
    }
}
