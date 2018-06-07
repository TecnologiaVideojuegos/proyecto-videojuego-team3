package VideojuegoEstados;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author SergioSanzSacristan
 */
public class Sonido {

    private Sound puerta, tarjeta, julian, zacarias, adrenalina, fondo;

    public Sonido() {
    }

    public void iniciarSonidos() throws SlickException {
        puerta = new Sound("./Sonidos/abrir_puerta.ogg");
        tarjeta = new Sound("./Sonidos/coger_tarjeta.ogg");
        julian = new Sound("./Sonidos/julian_muerte.ogg");
        zacarias = new Sound("./Sonidos/zacarias_muerte.ogg");
        adrenalina = new Sound("./Sonidos/usar_adrenalina.ogg");
        fondo = new Sound("./Sonidos/testloop.ogg");
    }

    public Sound getPuerta() {
        return puerta;
    }

    public Sound getTarjeta() {
        return tarjeta;
    }

    public Sound getJulian() {
        return julian;
    }

    public Sound getZacarias() {
        return zacarias;
    }

    public Sound getAdrenalina() {
        return adrenalina;
    }
    
    public Sound getFondo() {
        return fondo;
    }
}
