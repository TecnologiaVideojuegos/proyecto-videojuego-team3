/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Videojuego;

import org.newdawn.slick.geom.Rectangle;

/**
 *
 * @author Usuario
 */
public class Colisiones {

    private Rectangle rect1, rect2;

    public void paredes() {
        rect1 = new Rectangle(256 + 17, 160, 160 - 34, 256);
        rect2 = new Rectangle(128 + 17, 320, 384 - 34, 96);
    }
}
