package VideojuegoEstados;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Vidas {

    private int vidas;
    private Image v1, v2;

    public Vidas(int vidas) {
        this.vidas = vidas;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void dibujar(Graphics g) throws SlickException {
        v1 = new Image("./Interfaz/spr_vida.png");
        v2 = new Image("./Interfaz/spr_vidamenos.png");
        if (vidas == 6) {
            v1.draw(260, 10);
            v1.draw(210, 10);
            v1.draw(160, 10);
            v1.draw(110, 10);
            v1.draw(60, 10);
            v1.draw(10, 10);
        } else if (vidas == 5) {
            v2.draw(260, 10);
            v1.draw(210, 10);
            v1.draw(160, 10);
            v1.draw(110, 10);
            v1.draw(60, 10);
            v1.draw(10, 10);
        } else if (vidas == 4) {
            v2.draw(260, 10);
            v2.draw(210, 10);
            v1.draw(160, 10);
            v1.draw(110, 10);
            v1.draw(60, 10);
            v1.draw(10, 10);
        } else if (vidas == 3) {
            v2.draw(260, 10);
            v2.draw(210, 10);
            v2.draw(160, 10);
            v1.draw(110, 10);
            v1.draw(60, 10);
            v1.draw(10, 10);
        } else if (vidas == 2) {
            v2.draw(260, 10);
            v2.draw(210, 10);
            v2.draw(160, 10);
            v2.draw(110, 10);
            v1.draw(60, 10);
            v1.draw(10, 10);
        } else if (vidas == 1) {
            v2.draw(260, 10);
            v2.draw(210, 10);
            v2.draw(160, 10);
            v2.draw(110, 10);
            v2.draw(60, 10);
            v1.draw(10, 10);
        }
    }
}
