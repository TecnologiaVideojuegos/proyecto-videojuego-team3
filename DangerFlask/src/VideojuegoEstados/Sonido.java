package VideojuegoEstados;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author SergioSanzSacristan
 */
public class Sonido {

    private Sound puerta, tarjeta, juliandead, zacariasdead, adrenalina;
    private boolean sonidoOn = true, musicaOn = true;

    public Sonido() {
    }

    public void iniciarSonidos() throws SlickException {
        puerta = new Sound("./Sonidos/abrir_puerta.ogg");
        tarjeta = new Sound("./Sonidos/coger_tarjeta.ogg");
        juliandead = new Sound("./Sonidos/julian_muerte.ogg");
        zacariasdead = new Sound("./Sonidos/zacarias_muerte.ogg");
        adrenalina = new Sound("./Sonidos/usar_adrenalina.ogg");
    }

    public Sound getPuerta() {
        return puerta;
    }

    public Sound getTarjeta() {
        return tarjeta;
    }

    public Sound getJulianDead() {
        return juliandead;
    }

    public Sound getZacariasDead() {
        return zacariasdead;
    }

    public Sound getAdrenalina() {
        return adrenalina;
    }

    public boolean isSonidoOn() {
        return sonidoOn;
    }

    public void setSonidoOn(boolean sonidoOn) {
        this.sonidoOn = sonidoOn;
    }

    public boolean isMusicaOn() {
        return musicaOn;
    }

    public void setMusicaOn(boolean musicaOn) {
        this.musicaOn = musicaOn;
    }

    public void click(GameContainer container, Music musica) {
        if (container.getInput().getMouseX() < 657 && container.getInput().getMouseX() > 625
                && container.getInput().getMouseY() < 32 && container.getInput().getMouseY() > 5) {
            if (musicaOn) {
                musica.stop();
                musicaOn = false;
            } else {
                musica.loop(1, 0.5f);
                musicaOn = true;
            }
        }
        if (container.getInput().getMouseX() < 892 && container.getInput().getMouseX() > 860
                && container.getInput().getMouseY() < 32 && container.getInput().getMouseY() > 5) {
            if (sonidoOn) {
                sonidoOn = false;
            } else {
                sonidoOn = true;
            }
        }
    }
}
