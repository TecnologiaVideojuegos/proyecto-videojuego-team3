package VideojuegoEstados;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;
import org.newdawn.slick.tiled.TiledMap;

/**
 *
 * @author SergioSanzSacristan
 */
public class Mapa4 extends BasicGameState {

    //Atributos
    private TiledMap mapa;
    //Posicion en la que se encuentra nuestro personaje al inicio
    private float x = 34f, y = 275f;
    private boolean dentro = true, b = false;
    private int i;
    //Iniciamos la clase Colisiones con las coordenadas del personaje
    private final Colisiones col = new Colisiones(x, y);
    private boolean[][] obstaculo;
    //Iniciamos la clase Personajes con las coordenadas variables de los enemigos
    private final Personajes personaje = new Personajes(col, 368, 912, 480, 368, 432, 592);
    //Iniciamos la clase LimitesMapa
    private final LimitesMapa limiteMapa = new LimitesMapa();
    private final Vidas vidas;
    //Iniciamos la clase Objetos con las coordenadas de los objetos
    private final Objetos obj = new Objetos(col, 624, 176, 240, 384, 1024, 176);
    private final Sonido sonido;
    private final FadeInTransition entra = new FadeInTransition();
    private final FadeOutTransition sale = new FadeOutTransition();
    private Music zacariastheme;
    private Image sonidoOn, sonidoOff;

    //Constructor
    public Mapa4(Vidas vidas, Sonido sonido) {
        this.vidas = vidas;
        this.sonido = sonido;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        //Cargamos el mapa
        mapa = new TiledMap("./Mapas/mapa_final2.2.tmx");

        //Iniciamos los personajes y los enemigos con la clase Personajes
        personaje.iniciarPersZacarias();
        personaje.iniciarEnemMono();

        //Creamos los limites del mapa (paredes) con la clase LimitesMapa y le introducimos el mapa
        obstaculo = limiteMapa.crearLimite4(mapa);

        //Creamos las colisiones de los enemigos con la clase Personajes y le introducimos las coordenadas de los enemigos
        personaje.colisionesMono(272, 288, 576, 416, 1072, 656);

        //Inicia los objetos y crea las colisiones con ellos
        obj.creaObjetos();
        obj.colObj();

        //Inicia los sonidos y la música a utilizar
        sonido.iniciarSonidos();
        zacariastheme = new Music("./Musica/ZacariasTheme.ogg");

        //Inicia las imagenes para el sonido
        sonidoOn = new Image("./Interfaz/musicaON.png");
        sonidoOff = new Image("./Interfaz/musicaOFF.png");
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
//Dibujamos el mapa
        g.scale(0.5f, 0.5f);
        mapa.render(0, 0);
        g.resetTransform();

        //Dibujamos los personajes y los enemigos
        personaje.dibujarPers(x, y);
        personaje.dibujarEnem(272, 288, 576, 416, 1072, 656);

        //Dibujamos las vidas
        vidas.dibujar(g);

        //Dibujamos los objetos
        obj.dibuja();

        //Escribimos el texto de la parte superior
        g.drawString("Tarjetas recogidas: " + col.getTarjeta4() + "/2", 310, 10);
        g.drawString("Música: ", 550, 10);
        g.drawString("Efectos de sonido: ", 690, 10);
        g.drawString("Haga click para activar/desactivar \nmúsica y/o efectos de sonido", 910, 0);

        //Ponemos la imagen correspondiente a si tenemos la música y el sonido activado o no
        if (sonido.isMusicaOn()) {
            sonidoOn.draw(625, 5);
        } else {
            sonidoOff.draw(625, 5);
        }
        if (sonido.isSonidoOn()) {
            sonidoOn.draw(860, 5);
        } else {
            sonidoOff.draw(860, 5);
        }
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        //Si el boolean b es falso, que sirve para detectar cuando nos encontramos en este estado...
        //... y la música está activada, iniciamos la música del Mapa4
        if (!b && sonido.isMusicaOn()) {
            zacariastheme.loop(1, 0.5f);
            b = true;
        }

        //Si el personaje colisiona con los limites del mapa, dependiendo de en que...
        //...dirección sea la colisión, retrocede al personaje un pixel para no quedarse bloqueado
        if (col.animDentro4(obstaculo, x, y)) {
            dentro = false;
            if (i == 6) {
                x = x - 1;
            }
            if (i == 4) {
                x = x + 1;
            }
            if (i == 2) {
                y = y - 1;
            }
            if (i == 8) {
                y = y + 1;
            }
        }

        //Hace posible el movimiento del personaje y devuelve la dirección en la que se esta moviendo
        i = personaje.movimiento(dentro, x, y, container, delta);

        //Boolean para controlar el movimiento del personaje
        dentro = true;

        //Movimiento de los enemigos
        personaje.movimientoEnem4(delta);

        //Actualiza las coordenadas del personaje para las colisiones
        x = personaje.getX();
        y = personaje.getY();
        col.actualizar(x, y);

        //Actualiza las coordenadas de los enemigos para las colisiones
        personaje.actualizarEnem();

        //Si el personaje coge el botiquin y no tiene todas las vidas aumenta una vida...
        //... y elimina el botiquin del mapa
        if (obj.botCol() && vidas.getVidas() < 6) {
            vidas.setVidas(vidas.getVidas() + 1);
            obj.setA(false);
            if (sonido.isSonidoOn()) {
                sonido.getAdrenalina().play();
            }
        }

        //Si el personaje coge la tarjeta 1 aumenta el número de tarjetas y la elimina del mapa
        if (obj.tar1Col()) {
            col.setTarjeta4(col.getTarjeta4() + 1);
            obj.setB(false);
            if (sonido.isSonidoOn()) {
                sonido.getTarjeta().play();
            }
        }

        //Si el personaje coge la tarjeta 2 aumenta el número de tarjetas y la elimina del mapa        
        if (obj.tar2Col()) {
            col.setTarjeta4(col.getTarjeta4() + 1);
            obj.setC(false);
            if (sonido.isSonidoOn()) {
                sonido.getTarjeta().play();
            }
        }

        //Detecta si el jugador clickea en el mapa para activar o desactivar la música
        if (container.getInput().isMousePressed(0)) {
            sonido.click(container, zacariastheme);
        }

        //Cuando el personaje muere...
        if (personaje.muere()) {
            //Si el sonido esta activado suena el sonido
            if (sonido.isSonidoOn()) {
                sonido.getZacariasDead().play();
            }
            //Devuelve las coordenadas del personaje a las iniciales
            x = 34;
            y = 275;
            //Reinicia el estado de los objetos del mapa
            obj.setB(true);
            obj.setC(true);
            //Reinicia las tarjetas recogidas
            col.setTarjeta4(0);
            //Resta una vida al personaje
            vidas.setVidas(vidas.getVidas() - 1);
            //Si el número de vidas es 0 entonces para la música y le manda al estado 7, GAME OVER
            if (vidas.getVidas() == 0) {
                game.enterState(7, entra, sale);
            }
        }

        //Si el personaje atraviesa el Mapa4 pasa al estado 6 con el diálogo final
        if (col.cambiarMapa4()) {
            zacariastheme.stop();
            if (sonido.isSonidoOn()) {
                sonido.getPuerta().play();
            }
            game.enterState(6);
        }
    }

    //Este estado es el estado 5
    @Override
    public int getID() {
        return 5;
    }
}
