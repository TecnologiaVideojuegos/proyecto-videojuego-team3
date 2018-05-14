package VideojuegoEstados;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Vidas {

    private int vidas;
    private Image v1, v2, v3, v4, v5, v6;

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
            v1.draw(350, 10);
            v1.draw(300, 10);
            v1.draw(250, 10);
            v1.draw(200, 10);
            v1.draw(150, 10);
            v1.draw(100, 10);
        } else if (vidas == 5) {
            v2.draw(350, 10);
            v1.draw(300, 10);
            v1.draw(250, 10);
            v1.draw(200, 10);
            v1.draw(150, 10);
            v1.draw(100, 10);
        } else if (vidas == 4) {
            v2.draw(350, 10);
            v2.draw(300, 10);
            v1.draw(250, 10);
            v1.draw(200, 10);
            v1.draw(150, 10);
            v1.draw(100, 10);
        } else if (vidas == 3) {
            v2.draw(350, 10);
            v2.draw(300, 10);
            v2.draw(250, 10);
            v1.draw(200, 10);
            v1.draw(150, 10);
            v1.draw(100, 10);
        } else if (vidas == 2) {
            v2.draw(350, 10);
            v2.draw(300, 10);
            v2.draw(250, 10);
            v2.draw(200, 10);
            v1.draw(150, 10);
            v1.draw(100, 10);
        } else if (vidas == 1) {
            v2.draw(350, 10);
            v2.draw(300, 10);
            v2.draw(250, 10);
            v2.draw(200, 10);
            v2.draw(150, 10);
            v1.draw(100, 10);
        }
    }
}
