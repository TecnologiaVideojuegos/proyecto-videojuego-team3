package VideojuegoEstados;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author SergioSanzSacristan
 */
public class Sonido {

    private Sound puerta, tarjeta, juliandead, zacariasdead, adrenalina, menu, juliantheme, zacariastheme;

    public Sonido() {
    }

    public void iniciarSonidos() throws SlickException {
        puerta = new Sound("./Sonidos/abrir_puerta.ogg");
        tarjeta = new Sound("./Sonidos/coger_tarjeta.ogg");
        juliandead = new Sound("./Sonidos/julian_muerte.ogg");
        zacariasdead = new Sound("./Sonidos/zacarias_muerte.ogg");
        adrenalina = new Sound("./Sonidos/usar_adrenalina.ogg");
        menu = new Sound("./Musica/Menu.ogg");
        juliantheme = new Sound("./Musica/JulianTheme.ogg");
        zacariastheme = new Sound("./Musica/ZacariasTheme.ogg");
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

    public Sound getMenu() {
        return menu;
    }

    public Sound getJuliantheme() {
        return juliantheme;
    }

    public Sound getZacariastheme() {
        return zacariastheme;
    }

}
