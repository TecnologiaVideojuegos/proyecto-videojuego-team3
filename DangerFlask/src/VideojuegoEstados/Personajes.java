package VideojuegoEstados;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public class Personajes {

    //Atributos
    //Sprites del personaje y de los enemigos segun su movimiento
    private SpriteSheet spriteD, spriteI, spriteAr, spriteAb, spriteEnemD,
            spriteEnemI, spriteEnemAr, spriteEnemAb;
    //Animaciones del personaje y de los enemigos segun su movimiento
    private Animation animD, animI, animAr, animAb, animEnemD, animEnemI,
            animEnemAr, animEnemAb;
    //Booleans que detectan la direccion del movimiento del personaje
    private boolean derecha = true, arriba = false, izquierda = false,
            abajo = false;
    //Booleans que detectan la direccion del movimiento de los enemigos, si es...
    //...true, es que la direccion es la inicial y si esta a false es la contraria.
    private boolean enem1 = true, enem2 = true, enem3 = true, enem4 = true,
            enem5 = true, enem6 = true;
    //Variable i
    private int i = 6;
    //Coordenadas
    private float x_, y_, a, b, c, d, e, f;
    private final Colisiones col;
    private Rectangle rectEnem1, rectEnem2, rectEnem3, rectEnem4, rectEnem5, rectEnem6;

    //Constructor
    public Personajes(Colisiones col, int a, int b, int c, int d, int e, int f) {
        this.col = col;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    //Métodos Get y Set necesarios
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

    //Método que inicia los sprites y las animaciones del personaje Julian
    public void iniciarPersJulian() throws SlickException {
        spriteD = new SpriteSheet("./Personajes/spr_julian_derecha.png", 16, 26);
        animD = new Animation(spriteD, 100);
        spriteI = new SpriteSheet("./Personajes/spr_julian_izquierda.png", 16, 26);
        animI = new Animation(spriteI, 100);
        spriteAr = new SpriteSheet("./Personajes/spr_julian_arriba.png", 17, 27);
        animAr = new Animation(spriteAr, 100);
        spriteAb = new SpriteSheet("./Personajes/spr_julian_abajo.png", 17, 26);
        animAb = new Animation(spriteAb, 100);
    }

    //Método que inicia los sprites y las animaciones del personaje Zacarias
    public void iniciarPersZacarias() throws SlickException {
        spriteD = new SpriteSheet("./Personajes/spr_zacarias_derecha.png", 14, 26);
        animD = new Animation(spriteD, 100);
        spriteI = new SpriteSheet("./Personajes/spr_zacarias_izquierda.png", 14, 26);
        animI = new Animation(spriteI, 100);
        spriteAr = new SpriteSheet("./Personajes/spr_zacarias_arriba.png", 17, 26);
        animAr = new Animation(spriteAr, 100);
        spriteAb = new SpriteSheet("./Personajes/spr_zacarias_abajo.png", 17, 26);
        animAb = new Animation(spriteAb, 100);
    }

    //Método que inicia los sprites y las animaciones de las babosas enemigas
    public void iniciarEnemBab() throws SlickException {
        spriteEnemD = new SpriteSheet("./Enemigos/Babosa/spr_babosa_derecha.png", 25, 15);
        animEnemD = new Animation(spriteEnemD, 250);
        spriteEnemI = new SpriteSheet("./Enemigos/Babosa/spr_babosa_izquierda.png", 25, 15);
        animEnemI = new Animation(spriteEnemI, 250);
        spriteEnemAr = new SpriteSheet("./Enemigos/Babosa/spr_babosa_arriba.png", 14, 23);
        animEnemAr = new Animation(spriteEnemAr, 250);
        spriteEnemAb = new SpriteSheet("./Enemigos/Babosa/spr_babosa_abajo.png", 15, 22);
        animEnemAb = new Animation(spriteEnemAb, 250);
    }

    //Método que inicia los sprites y las animaciones de los monos enemigos
    public void iniciarEnemMono() throws SlickException {
        spriteEnemD = new SpriteSheet("./Enemigos/Mono/spr_mono2_derecha.png", 15, 22);
        animEnemD = new Animation(spriteEnemD, 150);
        spriteEnemI = new SpriteSheet("./Enemigos/Mono/spr_mono2_izquierda.png", 15, 22);
        animEnemI = new Animation(spriteEnemI, 150);
        spriteEnemAr = new SpriteSheet("./Enemigos/Mono/spr_mono2_arriba.png", 18, 22);
        animEnemAr = new Animation(spriteEnemAr, 150);
        spriteEnemAb = new SpriteSheet("./Enemigos/Mono/spr_mono2_abajo.png", 18, 22);
        animEnemAb = new Animation(spriteEnemAb, 150);
    }

    //Método que dependiendo la direccion del movimiento del personaje dibuja una animacion u otra
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

    //Método que dependiendo la direccion del movimiento de los enemigos dibuja una animacion u otra
    public void dibujarEnem(int y1, int y2, int y3, int x4, int x5, int x6) {
        if (enem1) {
            animEnemD.draw(a, y1);
        }
        if (!enem1) {
            animEnemI.draw(a, y1);
        }
        if (enem2) {
            animEnemI.draw(b, y2);
        }
        if (!enem2) {
            animEnemD.draw(b, y2);
        }
        if (enem3) {
            animEnemD.draw(c, y3);
        }
        if (!enem3) {
            animEnemI.draw(c, y3);
        }
        if (enem4) {
            animEnemAb.draw(x4, d);
        }
        if (!enem4) {
            animEnemAr.draw(x4, d);
        }
        if (enem5) {
            animEnemAb.draw(x5, e);
        }
        if (!enem5) {
            animEnemAr.draw(x5, e);
        }
        if (enem6) {
            animEnemAr.draw(x6, f);
        }
        if (!enem6) {
            animEnemAb.draw(x6, f);
        }
    }

    //Método que según pulses una dirección con los controles mueve el personaje en una dirección y otra
    public int movimiento(boolean dentro, float x, float y, GameContainer container, int delta) {
        x_ = x;
        y_ = y;

        //Vamos a explicar este caso, si pulsa la flecha derecha y no ha colisionado con ninguna pared
        if (container.getInput().isKeyDown(Input.KEY_RIGHT) && dentro) {
            //pone las variables a false menos la direccion a la que va, en este caso, la derecha
            derecha = true;
            arriba = false;
            izquierda = false;
            abajo = false;
            //iniamos la animacion correspondiente a la direccion a la que va
            animD.start();
            //desplazamos el personaje en este caso hacia la derecha, aumentamos la x
            x_ += 100 * (float) delta / 1000;
            //Finalmente devolvemos la i que es un número que corresponde a una dirección, en este caso...
            //...la derecha, el 6
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
            //Esto significa que el personaje no se mueve entonces paramos las animaciones...
            //...y las dejamos congeladas en un sprite determinado
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

    //En este método movemos los enemigos del mapa1 (Inteligencia Artificial)
    public void movimientoEnem1(int delta) {
        //Por ejemplo aqui el enemigo 1 se mueve hacia la derecha hasta llegar...
        //...a la x=288, entonces se pone a false su variable enem1 y cambia de sentido...
        //...hasta la coordenada x=99. Y vuelve a comenzar el movimiento.
        if (enem1) {
            animEnemD.start();
            a += 10 * (float) delta / 1000;
            if (a > 288) {
                enem1 = false;
            }
        } else {
            animEnemI.start();
            a -= 10 * (float) delta / 1000;
            if (a < 96) {
                enem1 = true;
            }
        }
        if (enem2) {
            animEnemI.start();
            b -= 10 * (float) delta / 1000;
            if (b < 112) {
                enem2 = false;
            }
        } else {
            animEnemD.start();
            b += 10 * (float) delta / 1000;
            if (b > 304) {
                enem2 = true;
            }
        }
        if (enem3) {
            animEnemD.start();
            c += 10 * (float) delta / 1000;
            if (c > 576) {
                enem3 = false;
            }
        } else {
            animEnemI.start();
            c -= 10 * (float) delta / 1000;
            if (c < 416) {
                enem3 = true;
            }
        }
        if (enem4) {
            animEnemAb.start();
            d += 10 * (float) delta / 1000;
            if (d > 416) {
                enem4 = false;
            }
        } else {
            animEnemAr.start();
            d -= 10 * (float) delta / 1000;
            if (d < 368) {
                enem4 = true;
            }
        }
        if (enem5) {
            animEnemAb.start();
            e += 10 * (float) delta / 1000;
            if (e > 592) {
                enem5 = false;
            }
        } else {
            animEnemAr.start();
            e -= 10 * (float) delta / 1000;
            if (e < 544) {
                enem5 = true;
            }
        }
        if (enem6) {
            animEnemAr.start();
            f -= 10 * (float) delta / 1000;
            if (f < 320) {
                enem6 = false;
            }
        } else {
            animEnemAb.start();
            f += 10 * (float) delta / 1000;
            if (f > 400) {
                enem6 = true;
            }
        }
    }

    //En este método movemos los enemigos del mapa2 (Inteligencia Artificial)
    public void movimientoEnem2(int delta) {
        if (enem1) {
            animEnemD.start();
            a += 10 * (float) delta / 1000;
            if (a > 112) {
                enem1 = false;
            }
        } else {
            animEnemI.start();
            a -= 10 * (float) delta / 1000;
            if (a < 32) {
                enem1 = true;
            }
        }
        if (enem2) {
            animEnemI.start();
            b -= 10 * (float) delta / 1000;
            if (b < 272) {
                enem2 = false;
            }
        } else {
            animEnemD.start();
            b += 10 * (float) delta / 1000;
            if (b > 352) {
                enem2 = true;
            }
        }
        if (enem3) {
            animEnemD.start();
            c += 10 * (float) delta / 1000;
            if (c > 752) {
                enem3 = false;
            }
        } else {
            animEnemI.start();
            c -= 10 * (float) delta / 1000;
            if (c < 640) {
                enem3 = true;
            }
        }
        if (enem4) {
            animEnemAb.start();
            d += 10 * (float) delta / 1000;
            if (d > 384) {
                enem4 = false;
            }
        } else {
            animEnemAr.start();
            d -= 10 * (float) delta / 1000;
            if (d < 288) {
                enem4 = true;
            }
        }
        if (enem6) {
            animEnemAr.start();
            f -= 10 * (float) delta / 1000;
            if (f < 448) {
                enem6 = false;
            }
        } else {
            animEnemAb.start();
            f += 10 * (float) delta / 1000;
            if (f > 512) {
                enem6 = true;
            }
        }
    }

    //En este método movemos los enemigos del mapa3 (Inteligencia Artificial)
    public void movimientoEnem3(int delta) {
        if (enem1) {
            animEnemD.start();
            a += 50 * (float) delta / 1000;
            if (a > 368) {
                enem1 = false;
            }
        } else {
            animEnemI.start();
            a -= 50 * (float) delta / 1000;
            if (a < 272) {
                enem1 = true;
            }
        }
        if (enem2) {
            animEnemI.start();
            b -= 50 * (float) delta / 1000;
            if (b < 736) {
                enem2 = false;
            }
        } else {
            animEnemD.start();
            b += 50 * (float) delta / 1000;
            if (b > 848) {
                enem2 = true;
            }
        }
        if (enem3) {
            animEnemD.start();
            c += 50 * (float) delta / 1000;
            if (c > 1104) {
                enem3 = false;
            }
        } else {
            animEnemI.start();
            c -= 50 * (float) delta / 1000;
            if (c < 1040) {
                enem3 = true;
            }
        }
        if (enem4) {
            animEnemAb.start();
            d += 50 * (float) delta / 1000;
            if (d > 272) {
                enem4 = false;
            }
        } else {
            animEnemAr.start();
            d -= 50 * (float) delta / 1000;
            if (d < 112) {
                enem4 = true;
            }
        }
        if (enem5) {
            animEnemAb.start();
            e += 50 * (float) delta / 1000;
            if (e > 208) {
                enem5 = false;
            }
        } else {
            animEnemAr.start();
            e -= 50 * (float) delta / 1000;
            if (e < 112) {
                enem5 = true;
            }
        }
        if (enem6) {
            animEnemAr.start();
            f -= 50 * (float) delta / 1000;
            if (f < 288) {
                enem6 = false;
            }
        } else {
            animEnemAb.start();
            f += 50 * (float) delta / 1000;
            if (f > 368) {
                enem6 = true;
            }
        }
    }

    //En este método movemos los enemigos del mapa4 (Inteligencia Artificial)
    public void movimientoEnem4(int delta) {
        if (enem1) {
            animEnemD.start();
            a += 50 * (float) delta / 1000;
            if (a > 448) {
                enem1 = false;
            }
        } else {
            animEnemI.start();
            a -= 50 * (float) delta / 1000;
            if (a < 368) {
                enem1 = true;
            }
        }
        if (enem2) {
            animEnemI.start();
            b -= 50 * (float) delta / 1000;
            if (b < 816) {
                enem2 = false;
            }
        } else {
            animEnemD.start();
            b += 50 * (float) delta / 1000;
            if (b > 912) {
                enem2 = true;
            }
        }
        if (enem3) {
            animEnemD.start();
            c += 50 * (float) delta / 1000;
            if (c > 528) {
                enem3 = false;
            }
        } else {
            animEnemI.start();
            c -= 50 * (float) delta / 1000;
            if (c < 480) {
                enem3 = true;
            }
        }
        if (enem4) {
            animEnemAb.start();
            d += 50 * (float) delta / 1000;
            if (d > 544) {
                enem4 = false;
            }
        } else {
            animEnemAr.start();
            d -= 50 * (float) delta / 1000;
            if (d < 368) {
                enem4 = true;
            }
        }
        if (enem5) {
            animEnemAb.start();
            e += 50 * (float) delta / 1000;
            if (e > 512) {
                enem5 = false;
            }
        } else {
            animEnemAr.start();
            e -= 50 * (float) delta / 1000;
            if (e < 432) {
                enem5 = true;
            }
        }
        if (enem6) {
            animEnemAr.start();
            f -= 50 * (float) delta / 1000;
            if (f < 528) {
                enem6 = false;
            }
        } else {
            animEnemAb.start();
            f += 50 * (float) delta / 1000;
            if (f > 592) {
                enem6 = true;
            }
        }
    }

    //Creamos los rectangulos que rodean a los enemigos para gestionar las colisiones con el personaje (Babosas)
    public void colisionesBab(int y1, int y2, int y3, int x4, int x5, int x6) {
        rectEnem1 = new Rectangle(a + 2, y1 + 2, 21, 11);
        rectEnem2 = new Rectangle(b + 2, y2 + 2, 21, 11);
        rectEnem3 = new Rectangle(c + 2, y3 + 2, 21, 11);
        rectEnem4 = new Rectangle(x4 + 2, d + 2, 10, 19);
        rectEnem5 = new Rectangle(x5 + 2, e + 2, 10, 19);
        rectEnem6 = new Rectangle(x6 + 2, f + 2, 10, 19);
    }

    //Creamos los rectangulos que rodean a los enemigos para gestionar las colisiones con el personaje (Monos)
    public void colisionesMono(int y1, int y2, int y3, int x4, int x5, int x6) {
        rectEnem1 = new Rectangle(a + 2, y1 + 2, 11, 18);
        rectEnem2 = new Rectangle(b + 2, y2 + 2, 11, 18);
        rectEnem3 = new Rectangle(c + 2, y3 + 2, 11, 18);
        rectEnem4 = new Rectangle(x4 + 2, d + 2, 14, 18);
        rectEnem5 = new Rectangle(x5 + 2, e + 2, 14, 18);
        rectEnem6 = new Rectangle(x6 + 2, f + 2, 14, 18);
    }

    //Este método sirve para actualizar las coordenadas de los rectangulos de colision de los enemigos
    public void actualizarEnem() {
        rectEnem1.setX(a + 2);
        rectEnem2.setX(b + 2);
        rectEnem3.setX(c + 2);
        rectEnem4.setY(d + 2);
        rectEnem5.setY(e + 2);
        rectEnem6.setY(f + 2);
    }

    //Este método devuelve true si el personaje colisiona con algún enemigo
    public boolean muere() {
        if (col.getRectAnim().intersects(rectEnem1) || col.getRectAnim().intersects(rectEnem2)
                || col.getRectAnim().intersects(rectEnem3) || col.getRectAnim().intersects(rectEnem4)
                || col.getRectAnim().intersects(rectEnem5) || col.getRectAnim().intersects(rectEnem6)) {
            return true;
        } else {
            return false;
        }
    }
}
