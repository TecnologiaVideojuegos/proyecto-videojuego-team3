/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Videojuego;

import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author SergioSanzSacristan
 */
public class Colisiones {

    private Rectangle rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10, rect11, rect12, rect13, rect14, rect15,
            rect16, rect17, rect18, rect19, rect20, rect21, rect22, rect23, rect24, rect25, rect26, rect27, rect28, rect29, rect30,
            rectAnim;

    /*public void paredes(float x, float y, Animation anim) {
        rectAnim = new Rectangle(x, y, anim.getWidth(), anim.getHeight());
        rect1 = new Rectangle(48 + 17, 288, 110, 21);
        rect2 = new Rectangle(144 + 17, 288, 14, 293);
        rect3 = new Rectangle(32 + 17, 560, 1118, 21);
        rect4 = new Rectangle(32 + 17, 480, 14, 96);
        rect5 = new Rectangle(32 + 17, 480, 46, 21);
        rect6 = new Rectangle(80 + 17, 400, -2, 96);
        rect7 = new Rectangle(64 + 17, 400, 14, 21);
        rect8 = new Rectangle(400 + 17, 96, 14, 485);
        rect9 = new Rectangle(320 + 17, 96, 79, 21);
        rect10 = new Rectangle(240 + 17, 112, 128 - 34, 48 - 27);
        rect11 = new Rectangle(320 + 17, 128, 48 - 34, 128 - 27);
        rect12 = new Rectangle(32 + 17, 192, 336 - 34, 64 - 27);
        rect13 = new Rectangle(32 + 17, 112, 48 - 34, 96 - 27);
        rect14 = new Rectangle(160 + 17, 80, 48 - 34, 144 - 27);
        rect15 = new Rectangle(224 + 17, 240, 48 - 34, 288 - 27);
        rect16 = new Rectangle(224 + 17, 480, 144 - 34, 48 - 27);
        rect17 = new Rectangle(((20 * 32) / 2) + 17, ((19 * 32) / 2), ((3 * 32) / 2) - 34, ((14 * 32) / 2) - 27);
        rect18 = new Rectangle(((50 * 32) / 2) + 17, ((29 * 32) / 2), ((3 * 32) / 2) - 34, ((7 * 32) / 2) - 27);
        rect19 = new Rectangle(((26 * 32) / 2) + 17, ((30 * 32) / 2), ((12 * 32) / 2) - 34, ((3 * 32) / 2) - 27);
        rect20 = new Rectangle(((30 * 32) / 2) + 17, ((17 * 32) / 2), ((3 * 32) / 2) - 34, ((14 * 32) / 2) - 27);
    }*/

    public boolean animDentro(boolean[][] paredes, float x, float y) {
        if ((paredes[(int) ((x * 2) / 16)][(int) ((y * 2) / 16) + 3] == true)
                || (paredes[(int) ((x * 2) / 16) + 2][(int) ((y * 2) / 16) + 3] == true)) {
            return true;
        } else {
            return false;
        }
    }

    /*public boolean animDentro() {
        if (!rectAnim.intersects(rect1) && !rectAnim.intersects(rect2) && !rectAnim.intersects(rect3) && !rectAnim.intersects(rect4)
                && !rectAnim.intersects(rect5) && !rectAnim.intersects(rect6) && !rectAnim.intersects(rect7)
                && !rectAnim.intersects(rect8) && !rectAnim.intersects(rect9) && !rectAnim.intersects(rect10)
                && !rectAnim.intersects(rect11) && !rectAnim.intersects(rect12) && !rectAnim.intersects(rect13)
                && !rectAnim.intersects(rect14) && !rectAnim.intersects(rect15) && !rectAnim.intersects(rect16)
                && !rectAnim.intersects(rect17) && !rectAnim.intersects(rect18) && !rectAnim.intersects(rect19)
                && !rectAnim.intersects(rect20)) {
            return true;
        } else {
            return false;
        }
    }*/

    public void actualizar(float x, float y) {
        rectAnim.setX(x);
        rectAnim.setY(y);
    }
}
