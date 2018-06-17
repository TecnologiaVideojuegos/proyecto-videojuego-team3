package VideojuegoEstados;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Vidas {

    //Atributos
    private int vidas;
    private Image v1, v2;

    //Constructor
    public Vidas(int vidas) {
        this.vidas = vidas;
    }

    //Métodos Get y Set necesarios
    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    //Este método dibuja las vidas en el mapa, dependiendo de las vidas que tiene...
    //...pone tantos corazones, y las vidas perdidas con corazones rotos
    public void dibujar(Graphics g) throws SlickException {
        //Inicia las vidas
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
