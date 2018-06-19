package VideojuegoEstados;

import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author SergioSanzSacristan
 */
public class Colisiones {

    //Atributos
    private float x_, y_;
    private int tarjeta1 = 0, tarjeta2 = 0, tarjeta3 = 0, tarjeta4 = 0;

    //Constructor
    public Colisiones(float x, float y) {
        this.x_ = x;
        this.y_ = y;
    }

    //Métodos Get y Set necesarios
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

    //Iniciamos rectángulos que nos servirán para gestionar los cambios de estado...
    //...y las puertas de cada mapa, tambien el rectangulo que rodea al personaje...
    //...y asi poder gestionar las colisiones del mismo.
    private final Rectangle rectSalida1 = new Rectangle(1150, 495, 55, 30);
    private final Rectangle rectSalida2 = new Rectangle(1167, 270, 50, 25);
    private final Rectangle rectSalida3 = new Rectangle(335, 592, 50, 50);
    private final Rectangle rectSalida4 = new Rectangle(478, 592, 50, 50);
    private final Rectangle cambiarMapa1 = new Rectangle(1213, 499, 1, 45);
    private final Rectangle cambiarMapa2 = new Rectangle(1213, 275, 1, 45);
    private final Rectangle cambiarMapa3 = new Rectangle(336, 638, 45, 1);
    private final Rectangle cambiarMapa4 = new Rectangle(480, 638, 45, 1);
    private final Rectangle rectAnim = new Rectangle(x_ + 2, y_ + 2, 12, 23);

    //Método get del rectangulo del personaje
    public Rectangle getRectAnim() {
        return rectAnim;
    }

    //Gestionamos las colisiones con las paredes del mapa1 y cuando tiene las...
    //...dos tarjetas necesarias para poder atravesar la puerta. Devuelve true...
    //...cuando el personaje colisiona con una pared.
    public boolean animDentro1(boolean[][] paredes, float x, float y) {
        if (((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true))
                && rectAnim.intersects(rectSalida1)
                && tarjeta1 == 2) {
            return false;
        } else if ((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) {
            return true;
        } else {
            return false;
        }
    }

    //Gestionamos las colisiones con las paredes del mapa2 y cuando tiene las...
    //...dos tarjetas necesarias para poder atravesar la puerta. Devuelve true...
    //...cuando el personaje colisiona con una pared.
    public boolean animDentro2(boolean[][] paredes, float x, float y) {
        if (((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true))
                && rectAnim.intersects(rectSalida2)
                && tarjeta2 == 2) {
            return false;
        } else if ((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) {
            return true;
        } else {
            return false;
        }
    }

    //Gestionamos las colisiones con las paredes del mapa3 y cuando tiene las...
    //...dos tarjetas necesarias para poder atravesar la puerta. Devuelve true...
    //...cuando el personaje colisiona con una pared.
    public boolean animDentro3(boolean[][] paredes, float x, float y) {
        if (((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true))
                && rectAnim.intersects(rectSalida3)
                && tarjeta3 == 2) {
            return false;
        } else if ((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) {
            return true;
        } else {
            return false;
        }
    }

    //Gestionamos las colisiones con las paredes del mapa4 y cuando tiene las...
    //...dos tarjetas necesarias para poder atravesar la puerta. Devuelve true...
    //...cuando el personaje colisiona con una pared.
    public boolean animDentro4(boolean[][] paredes, float x, float y) {
        if (((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true))
                && rectAnim.intersects(rectSalida4)
                && tarjeta4 == 2) {
            return false;
        } else if ((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) {
            return true;
        } else {
            return false;
        }
    }

    //Actualiza la posicion del rectangulo del personaje en funcion de las...
    //... coordenadas del propio personaje, para mantener la gestion de colisiones
    public void actualizar(float x, float y) {
        rectAnim.setX(x + 2);
        rectAnim.setY(y + 2);
    }

    //Este método se encarga de detectar si el personaje atraviesa la puerta del mapa1
    public boolean cambiarMapa1() {
        if (rectAnim.intersects(cambiarMapa1)) {
            return true;
        } else {
            return false;
        }
    }

    //Este método se encarga de detectar si el personaje atraviesa la puerta del mapa2
    public boolean cambiarMapa2() {
        if (rectAnim.intersects(cambiarMapa2)) {
            return true;
        } else {
            return false;
        }
    }

    //Este método se encarga de detectar si el personaje atraviesa la puerta del mapa3
    public boolean cambiarMapa3() {
        if (rectAnim.intersects(cambiarMapa3)) {
            return true;
        } else {
            return false;
        }
    }

    //Este método se encarga de detectar si el personaje atraviesa la puerta del mapa4
    public boolean cambiarMapa4() {
        if (rectAnim.intersects(cambiarMapa4)) {
            return true;
        } else {
            return false;
        }
    }
}
