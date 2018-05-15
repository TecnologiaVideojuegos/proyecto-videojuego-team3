package VideojuegoEstados;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Personajes {

    private SpriteSheet spriteD, spriteI, spriteAr, spriteAb, spriteBabD, spriteBabI, spriteBabAr, spriteBabAb, spriteBabD2, spriteBabI2;
    private Animation animD, animI, animAr, animAb, animBabD, animBabI, animBabAr, animBabAb, animBabD2, animBabI2;
    private boolean derecha = true, arriba = false, izquierda = false, abajo = false, bab1 = true, bab2 = true, bab3 = true,
            bab4 = true;
    private int i = 6;
    private float x_, y_, j = 96, a = 304, b = 416, c = 368, d, e;
    private Colisiones col;

    public Personajes(Colisiones col) {
        this.col = col;
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

    public void iniciarEnem1() throws SlickException {
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
            animBabD.draw(j, 576);
        }
        if (!bab1) {
            animBabI.draw(j, 576);
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
            j += 10 * (float) delta / 1000;
            col.setJ(j);
            if (j > 288) {
                bab1 = false;
            }
        } else {
            animBabI.start();
            j -= 10 * (float) delta / 1000;
            col.setJ(j);
            if (j < 96) {
                bab1 = true;
            }
        }
        if (bab2) {
            animBabI.start();
            a -= 10 * (float) delta / 1000;
            col.setA(a);
            if (a < 112) {
                bab2 = false;
            }
        } else {
            animBabD.start();
            a += 10 * (float) delta / 1000;
            col.setA(a);
            if (a > 304) {
                bab2 = true;
            }
        }
        if (bab3) {
            animBabD.start();
            b += 10 * (float) delta / 1000;
            col.setB(b);
            if (b > 576) {
                bab3 = false;
            }
        } else {
            animBabI.start();
            b -= 10 * (float) delta / 1000;
            col.setB(b);
            if (b < 416) {
                bab3 = true;
            }
        }
        if (bab4) {
            animBabAb.start();
            c += 10 * (float) delta / 1000;
            col.setC(c);
            if (c > 416) {
                bab4 = false;
            }
        } else {
            animBabAr.start();
            c -= 10 * (float) delta / 1000;
            col.setC(c);
            if (c < 368) {
                bab4 = true;
            }
        }
    }
}
