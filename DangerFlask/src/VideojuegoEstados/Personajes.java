package VideojuegoEstados;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Personajes {

    private SpriteSheet spriteD, spriteI, spriteAr, spriteAb, spriteBabD, spriteBabI, spriteBabAr, spriteBabAb;
    private Animation animD, animI, animAr, animAb, animBabD, animBabI, animBabAr, animBabAb;
    private boolean derecha = true, arriba = false, izquierda = false, abajo = false, bab1 = true, bab2 = true, bab3 = true,
            bab4 = true, bab5 = true, bab6 = true;
    private int i = 6;
    private float x_, y_, a, b, c, d, e, f;
    private Colisiones col;
    private Rectangle rectBab1, rectBab2, rectBab3, rectBab4, rectBab5, rectBab6;

    public Personajes(Colisiones col, int a, int b, int c, int d, int e, int f) {
        this.col = col;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    public float getX() {
        return x_;
    }

    public void setX(float x_) {
        this.x_ = x_;
    }

    public float getY() {
        return y_;
    }

    public void setY(float y_) {
        this.y_ = y_;
    }

    public void iniciarPersJulian() throws SlickException {
        spriteD = new SpriteSheet("./juego/spr_julian_derecha.png", 16, 26);
        animD = new Animation(spriteD, 100);
        spriteI = new SpriteSheet("./juego/spr_julian_izquierda.png", 16, 26);
        animI = new Animation(spriteI, 100);
        spriteAr = new SpriteSheet("./juego/spr_julian_arriba.png", 17, 27);
        animAr = new Animation(spriteAr, 100);
        spriteAb = new SpriteSheet("./juego/spr_julian_abajo.png", 17, 26);
        animAb = new Animation(spriteAb, 100);
    }
    
    public void iniciarPersZacarias() throws SlickException {
        spriteD = new SpriteSheet("./juego/spr_zacarias_derecha.png", 14, 26);
        animD = new Animation(spriteD, 100);
        spriteI = new SpriteSheet("./juego/spr_zacarias_izquierda.png", 14, 26);
        animI = new Animation(spriteI, 100);
        spriteAr = new SpriteSheet("./juego/spr_zacarias_arriba.png", 17, 26);
        animAr = new Animation(spriteAr, 100);
        spriteAb = new SpriteSheet("./juego/spr_zacarias_abajo.png", 17, 27);
        animAb = new Animation(spriteAb, 100);
    }

    public void iniciarEnem() throws SlickException {
        spriteBabD = new SpriteSheet("./Enemigos/Babosa/spr_babosa_derecha.png", 25, 15);
        animBabD = new Animation(spriteBabD, 250);
        spriteBabI = new SpriteSheet("./Enemigos/Babosa/spr_babosa_izquierda.png", 25, 15);
        animBabI = new Animation(spriteBabI, 250);
        spriteBabAr = new SpriteSheet("./Enemigos/Babosa/spr_babosa_arriba.png", 14, 23);
        animBabAr = new Animation(spriteBabAr, 250);
        spriteBabAb = new SpriteSheet("./Enemigos/Babosa/spr_babosa_abajo.png", 15, 22);
        animBabAb = new Animation(spriteBabAb, 250);
    }

    public void dibujarPers(float x, float y) {
        if (derecha) {
            animD.draw(x, y);
        }
        if (izquierda) {
            animI.draw(x, y);
        }
        if (arriba) {
            animAr.draw(x, y);
        }
        if (abajo) {
            animAb.draw(x, y);
        }
    }

    public void dibujarEnem(int y1, int y2, int y3, int x4, int x5, int x6) {
        if (bab1) {
            animBabD.draw(a, y1);
        }
        if (!bab1) {
            animBabI.draw(a, y1);
        }
        if (bab2) {
            animBabI.draw(b, y2);
        }
        if (!bab2) {
            animBabD.draw(b, y2);
        }
        if (bab3) {
            animBabD.draw(c, y3);
        }
        if (!bab3) {
            animBabI.draw(c, y3);
        }
        if (bab4) {
            animBabAb.draw(x4, d);
        }
        if (!bab4) {
            animBabAr.draw(x4, d);
        }
        if (bab5) {
            animBabAb.draw(x5, e);
        }
        if (!bab5) {
            animBabAr.draw(x5, e);
        }
        if (bab6) {
            animBabAr.draw(x6, f);
        }
        if (!bab6) {
            animBabAb.draw(x6, f);
        }
//        if (bab1) {
//            animBabD.draw(a, 576);
//        }
//        if (!bab1) {
//            animBabI.draw(a, 576);
//        }
//        if (bab2) {
//            animBabI.draw(b, 224);
//        }
//        if (!bab2) {
//            animBabD.draw(b, 224);
//        }
//        if (bab3) {
//            animBabD.draw(c, 496);
//        }
//        if (!bab3) {
//            animBabI.draw(c, 496);
//        }
//        if (bab4) {
//            animBabAb.draw(656, d);
//        }
//        if (!bab4) {
//            animBabAr.draw(656, d);
//        }
//        if (bab5) {
//            animBabAb.draw(816, e);
//        }
//        if (!bab5) {
//            animBabAr.draw(816, e);
//        }
//        if (bab6) {
//            animBabAr.draw(816, f);
//        }
//        if (!bab6) {
//            animBabAb.draw(816, f);
//        }
    }

    public void dibujarEnem2() {

    }

    public int movimiento(boolean dentro, float x, float y, GameContainer container, int delta) {
        x_ = x;
        y_ = y;

        if (container.getInput().isKeyDown(Input.KEY_RIGHT) && dentro) {
            derecha = true;
            arriba = false;
            izquierda = false;
            abajo = false;
            animD.start();
            x_ += 100 * (float) delta / 1000;
            i = 6;
            return i;
        } else if (container.getInput().isKeyDown(Input.KEY_LEFT) && dentro) {
            derecha = false;
            arriba = false;
            izquierda = true;
            abajo = false;
            animI.start();
            x_ -= 100 * (float) delta / 1000;
            i = 4;
            return i;
        } else if (container.getInput().isKeyDown(Input.KEY_UP) && dentro) {
            derecha = false;
            arriba = true;
            izquierda = false;
            abajo = false;
            animAr.start();
            y_ -= 100 * (float) delta / 1000;
            i = 8;
            return i;
        } else if (container.getInput().isKeyDown(Input.KEY_DOWN) && dentro) {
            derecha = false;
            arriba = false;
            izquierda = false;
            abajo = true;
            animAb.start();
            y_ += 100 * (float) delta / 1000;
            i = 2;
            return i;
        } else {
            animD.stop();
            animI.stop();
            animAr.stop();
            animAb.stop();
            animD.setCurrentFrame(1);
            animI.setCurrentFrame(1);
            animAr.setCurrentFrame(1);
            animAb.setCurrentFrame(1);
            return i;
        }
    }

    public void movimientoEnem1(int delta) {
        if (bab1) {
            animBabD.start();
            a += 10 * (float) delta / 1000;
            if (a > 288) {
                bab1 = false;
            }
        } else {
            animBabI.start();
            a -= 10 * (float) delta / 1000;
            if (a < 96) {
                bab1 = true;
            }
        }
        if (bab2) {
            animBabI.start();
            b -= 10 * (float) delta / 1000;
            if (b < 112) {
                bab2 = false;
            }
        } else {
            animBabD.start();
            b += 10 * (float) delta / 1000;
            if (b > 304) {
                bab2 = true;
            }
        }
        if (bab3) {
            animBabD.start();
            c += 10 * (float) delta / 1000;
            if (c > 576) {
                bab3 = false;
            }
        } else {
            animBabI.start();
            c -= 10 * (float) delta / 1000;
            if (c < 416) {
                bab3 = true;
            }
        }
        if (bab4) {
            animBabAb.start();
            d += 10 * (float) delta / 1000;
            if (d > 416) {
                bab4 = false;
            }
        } else {
            animBabAr.start();
            d -= 10 * (float) delta / 1000;
            if (d < 368) {
                bab4 = true;
            }
        }
        if (bab5) {
            animBabAb.start();
            e += 10 * (float) delta / 1000;
            if (e > 592) {
                bab5 = false;
            }
        } else {
            animBabAr.start();
            e -= 10 * (float) delta / 1000;
            if (e < 544) {
                bab5 = true;
            }
        }
        if (bab6) {
            animBabAr.start();
            f -= 10 * (float) delta / 1000;
            if (f < 320) {
                bab6 = false;
            }
        } else {
            animBabAb.start();
            f += 10 * (float) delta / 1000;
            if (f > 400) {
                bab6 = true;
            }
        }
    }        

    public void movimientoEnem2(int delta) {
        if (bab1) {
            animBabD.start();
            a += 10 * (float) delta / 1000;
            if (a > 112) {
                bab1 = false;
            }
        } else {
            animBabI.start();
            a -= 10 * (float) delta / 1000;
            if (a < 32) {
                bab1 = true;
            }
        }
        if (bab2) {
            animBabI.start();
            b -= 10 * (float) delta / 1000;
            if (b < 272) {
                bab2 = false;
            }
        } else {
            animBabD.start();
            b += 10 * (float) delta / 1000;
            if (b > 352) {
                bab2 = true;
            }
        }
        if (bab3) {
            animBabD.start();
            c += 10 * (float) delta / 1000;
            if (c > 752) {
                bab3 = false;
            }
        } else {
            animBabI.start();
            c -= 10 * (float) delta / 1000;
            if (c < 640) {
                bab3 = true;
            }
        }
        if (bab4) {
            animBabAb.start();
            d += 10 * (float) delta / 1000;
            if (d > 384) {
                bab4 = false;
            }
        } else {
            animBabAr.start();
            d -= 10 * (float) delta / 1000;
            if (d < 288) {
                bab4 = true;
            }
        }
        if (bab6) {
            animBabAr.start();
            f -= 10 * (float) delta / 1000;
            if (f < 448) {
                bab6 = false;
            }
        } else {
            animBabAb.start();
            f += 10 * (float) delta / 1000;
            if (f > 512) {
                bab6 = true;
            }
        }
    }

    public void movimientoEnem3(int delta){
        if (bab1) {
            animBabD.start();
            a += 10 * (float) delta / 1000;
            if (a > 368) {
                bab1 = false;
            }
        } else {
            animBabI.start();
            a -= 10 * (float) delta / 1000;
            if (a < 272) {
                bab1 = true;
            }
        }
        if (bab2) {
            animBabI.start();
            b -= 10 * (float) delta / 1000;
            if (b < 736) {
                bab2 = false;
            }
        } else {
            animBabD.start();
            b += 10 * (float) delta / 1000;
            if (b > 848) {
                bab2 = true;
            }
        }
        if (bab3) {
            animBabD.start();
            c += 10 * (float) delta / 1000;
            if (c > 1104) {
                bab3 = false;
            }
        } else {
            animBabI.start();
            c -= 10 * (float) delta / 1000;
            if (c < 1040) {
                bab3 = true;
            }
        }
        if (bab4) {
            animBabAb.start();
            d += 10 * (float) delta / 1000;
            if (d > 272) {
                bab4 = false;
            }
        } else {
            animBabAr.start();
            d -= 10 * (float) delta / 1000;
            if (d < 112) {
                bab4 = true;
            }
        }
        if (bab5) {
            animBabAb.start();
            e += 10 * (float) delta / 1000;
            if (e > 208) {
                bab5 = false;
            }
        } else {
            animBabAr.start();
            e -= 10 * (float) delta / 1000;
            if (e < 112) {
                bab5 = true;
            }
        }
        if (bab6) {
            animBabAr.start();
            f -= 10 * (float) delta / 1000;
            if (f < 288) {
                bab6 = false;
            }
        } else {
            animBabAb.start();
            f += 10 * (float) delta / 1000;
            if (f > 368) {
                bab6 = true;
            }
        }
    }
    
    public void colisiones(int y1, int y2, int y3, int x4, int x5, int x6) {
        rectBab1 = new Rectangle(a, y1, 25, 15);
        rectBab2 = new Rectangle(b, y2, 25, 15);
        rectBab3 = new Rectangle(c, y3, 25, 15);
        rectBab4 = new Rectangle(x4, d, 14, 23);
        rectBab5 = new Rectangle(x5, e, 14, 23);
        rectBab6 = new Rectangle(x6, f, 14, 23);
//        rectBab1 = new Rectangle(f, 576, 25, 15);
//        rectBab2 = new Rectangle(a, 224, 25, 15);
//        rectBab3 = new Rectangle(b, 496, 25, 15);
//        rectBab4 = new Rectangle(656, c, 14, 23);
//        rectBab5 = new Rectangle(816, d, 14, 23);
//        rectBab6 = new Rectangle(816, e, 14, 23);
    }


    public void actualizarBab() {
        rectBab1.setX(a);
        rectBab2.setX(b);
        rectBab3.setX(c);
        rectBab4.setY(d);
        rectBab5.setY(e);
        rectBab6.setY(f);
    }

    public boolean muere() {
        if (col.getRectAnim().intersects(rectBab1) || col.getRectAnim().intersects(rectBab2) || col.getRectAnim().intersects(rectBab3)
                || col.getRectAnim().intersects(rectBab4) || col.getRectAnim().intersects(rectBab5) || col.getRectAnim().intersects(rectBab6)) {
            return true;
        } else {
            return false;
        }
    }
}
