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
 * @author SergioSanzSacristan
 */
public class Colisiones {

    private Rectangle rect1, rect2, rect3, rectAnim;

    public void paredes(float x, float y, Animation anim) {
        rectAnim = new Rectangle(x, y, anim.getWidth(), anim.getHeight());
        rect1 = new Rectangle(48 + 17, 288, 110, 21);
        rect2 = new Rectangle(144 + 17, 288, 14, 293);
        rect3 = new Rectangle(32 + 17, 560, 1118, 21);
    }

    public boolean caminos(boolean dentro) {
        if (!rectAnim.intersects(rect1) && !rectAnim.intersects(rect2) && !rectAnim.intersects(rect3)) {
            dentro = false;
        }
        return dentro;
    }

    public boolean animDentro() {
        if (!rectAnim.intersects(rect1) && !rectAnim.intersects(rect2) && !rectAnim.intersects(rect3)) {
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
