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

    //Atributos
    //Inicia los atributos de los sonidos
    private Sound puerta, tarjeta, juliandead, zacariasdead, adrenalina;
    //Si estan a true significa que el sonido y la música estan activados
    private boolean sonidoOn = true, musicaOn = true;

    //Constructor
    public Sonido() {
    }

    //Métodos Get y Set necesarios
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
    
    //Este método inicia los sonidos
    public void iniciarSonidos() throws SlickException {
        puerta = new Sound("./Sonidos/abrir_puerta.ogg");
        tarjeta = new Sound("./Sonidos/coger_tarjeta.ogg");
        juliandead = new Sound("./Sonidos/julian_muerte.ogg");
        zacariasdead = new Sound("./Sonidos/zacarias_muerte.ogg");
        adrenalina = new Sound("./Sonidos/usar_adrenalina.ogg");
    }

    //Este método detecta si en los mapas has clickado en activar/desactivar música y sonido, y cambia...
    //...las variables de musicaOn y sonidoOn si es necesario
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
