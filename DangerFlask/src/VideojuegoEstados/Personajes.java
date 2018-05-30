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

    public void iniciarPers() throws SlickException {
        spriteD = new SpriteSheet("./juego/animD.png", 16, 25);
        animD = new Animation(spriteD, 100);
        spriteI = new SpriteSheet("./juego/animI.png", 16, 25);
        animI = new Animation(spriteI, 100);
        spriteAr = new SpriteSheet("./juego/animAr.png", 17, 27);
        animAr = new Animation(spriteAr, 100);
        spriteAb = new SpriteSheet("./juego/animAb.png", 17, 27);
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

    public void dibujarEnem1() {
        if (bab1) {
            animBabD.draw(f, 576);
        }
        if (!bab1) {
            animBabI.draw(f, 576);
        }
        if (bab2) {
            animBabI.draw(a, 224);
        }
        if (!bab2) {
            animBabD.draw(a, 224);
        }
        if (bab3) {
            animBabD.draw(b, 496);
        }
        if (!bab3) {
            animBabI.draw(b, 496);
        }
        if (bab4) {
            animBabAb.draw(656, c);
        }
        if (!bab4) {
            animBabAr.draw(656, c);
        }
        if (bab5) {
            animBabAb.draw(816, d);
        }
        if (!bab5) {
            animBabAr.draw(816, d);
        }
        if (bab6) {
            animBabAr.draw(816, e);
        }
        if (!bab6) {
            animBabAb.draw(816, e);
        }
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
            f += 10 * (float) delta / 1000;
            if (f > 288) {
                bab1 = false;
            }
        } else {
            animBabI.start();
            f -= 10 * (float) delta / 1000;
            if (f < 96) {
                bab1 = true;
            }
        }
        if (bab2) {
            animBabI.start();
            a -= 10 * (float) delta / 1000;
            if (a < 112) {
                bab2 = false;
            }
        } else {
            animBabD.start();
            a += 10 * (float) delta / 1000;
            if (a > 304) {
                bab2 = true;
            }
        }
        if (bab3) {
            animBabD.start();
            b += 10 * (float) delta / 1000;
            if (b > 576) {
                bab3 = false;
            }
        } else {
            animBabI.start();
            b -= 10 * (float) delta / 1000;
            if (b < 416) {
                bab3 = true;
            }
        }
        if (bab4) {
            animBabAb.start();
            c += 10 * (float) delta / 1000;
            if (c > 416) {
                bab4 = false;
            }
        } else {
            animBabAr.start();
            c -= 10 * (float) delta / 1000;
            if (c < 368) {
                bab4 = true;
            }
        }
        if (bab5) {
            animBabAb.start();
            d += 10 * (float) delta / 1000;
            if (d > 592) {
                bab5 = false;
            }
        } else {
            animBabAr.start();
            d -= 10 * (float) delta / 1000;
            if (d < 544) {
                bab5 = true;
            }
        }
        if (bab6) {
            animBabAr.start();
            e -= 10 * (float) delta / 1000;
            if (e < 320) {
                bab6 = false;
            }
        } else {
            animBabAb.start();
            e += 10 * (float) delta / 1000;
            if (e > 400) {
                bab6 = true;
            }
        }
    }

    public void colisiones(int y1, int y2, int y3, int x4, int x5, int x6) {
        rectBab1 = new Rectangle(f, y1, 25, 15);
        rectBab2 = new Rectangle(a, y2, 25, 15);
        rectBab3 = new Rectangle(b, y3, 25, 15);
        rectBab4 = new Rectangle(x4, c, 14, 23);
        rectBab5 = new Rectangle(x5, d, 14, 23);
        rectBab6 = new Rectangle(x6, e, 14, 23);
//        rectBab1 = new Rectangle(f, 576, 25, 15);
//        rectBab2 = new Rectangle(a, 224, 25, 15);
//        rectBab3 = new Rectangle(b, 496, 25, 15);
//        rectBab4 = new Rectangle(656, c, 14, 23);
//        rectBab5 = new Rectangle(816, d, 14, 23);
//        rectBab6 = new Rectangle(816, e, 14, 23);
    }

    public void colisiones2() {
        rectBab1.setX(a);
        rectBab1.setY(0);
        rectBab2.setX(b);
        rectBab2.setY(0);
        rectBab3.setX(c);
        rectBab3.setY(0);
        rectBab4.setX(0);
        rectBab4.setY(d);
        rectBab5.setX(0);
        rectBab5.setY(e);
        rectBab6.setX(0);
        rectBab6.setY(0);
    }

    public void actualizarBab1() {
        rectBab1.setX(f);
        rectBab2.setX(a);
        rectBab3.setX(b);
        rectBab4.setY(c);
        rectBab5.setY(d);
        rectBab6.setY(e);
    }

    public boolean muere1() {
        if (col.getRectAnim().intersects(rectBab1) || col.getRectAnim().intersects(rectBab2) || col.getRectAnim().intersects(rectBab3)
                || col.getRectAnim().intersects(rectBab4) || col.getRectAnim().intersects(rectBab5) || col.getRectAnim().intersects(rectBab6)) {
            return true;
        } else {
            return false;
        }
    }
}
