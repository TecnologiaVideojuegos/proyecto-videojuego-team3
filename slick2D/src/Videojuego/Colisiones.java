/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Videojuego;

import java.util.ArrayList;
import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Usuario
 */
public class Colisiones {

    private Rectangle rect1, rect2, rectAnim;

    public void paredes(float x, float y, Animation anim) {
        rectAnim = new Rectangle(x, y, anim.getWidth(), anim.getHeight());
        rect1 = new Rectangle(256 + 17, 160, 160 - 34, 256);
        rect2 = new Rectangle(128 + 17, 320, 384 - 34, 96);
    }

    public boolean caminos(boolean dentro) {
        if (!rectAnim.intersects(rect1) && !rectAnim.intersects(rect2)) {
            dentro = false;
        }
        return dentro;
    }

    public boolean animDentro() {
        if (!rectAnim.intersects(rect1) && !rectAnim.intersects(rect2)) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Float> dentro(float x, float y, int i) {
        ArrayList<Float> coordenadas = new ArrayList();
        coordenadas.add(0, x);
        coordenadas.add(0, y);
        if (!rectAnim.intersects(rect1) && !rectAnim.intersects(rect2)) {
            if (i == 6) {
                x = x - 1f;
                coordenadas.add(0, x);
            }
            if (i == 4) {
                x = x + 1;
                coordenadas.add(0, x);
            }
            if (i == 2) {
                y = y - 1;
                coordenadas.add(1, y);
            }
            if (i == 8) {
                y = y + 1;
                coordenadas.add(1, y);
            }
        }
        return coordenadas;
    }

    public void actualizar(float x, float y) {
        rectAnim.setX(x);
        rectAnim.setY(y);
    }
}
