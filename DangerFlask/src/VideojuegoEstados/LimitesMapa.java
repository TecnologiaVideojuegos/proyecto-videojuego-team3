package VideojuegoEstados;

import org.newdawn.slick.tiled.TiledMap;

public class LimitesMapa {

    //Atributos
    private boolean[][] obstaculo;

    //Constructor
    public LimitesMapa() {
    }

    //Este método a partir de las capas del TiledMap del mapa1 crea una matriz en la cual se recorre el TiledMap y si...
    //...hay algún objeto de esas capas de la pared en la posición correspondiente en la matriz pone un true...
    //...o un false. Asi detectamos las paredes del mapa para gestionar las colisiones. Por lo tanto, este...
    //...método devuelve la matriz.
    public boolean[][] crearLimite1(TiledMap mapa) {
        int totalTilesWidth = mapa.getWidth() * 2;
        int totalTilesHeight = mapa.getHeight() * 2;
        obstaculo = new boolean[totalTilesWidth][totalTilesHeight];
        for (int i = 0; i < totalTilesWidth; i++) {
            for (int j = 0; j < totalTilesHeight; j++) {
                obstaculo[i][j] = ((mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 4")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 3")) != 0) || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 2")) != 0));
            }
        }
        return obstaculo;
    }

    //Este método a partir de las capas del TiledMap del mapa2 crea una matriz en la cual se recorre el TiledMap y si...
    //...hay algún objeto de esas capas de la pared en la posición correspondiente en la matriz pone un true...
    //...o un false. Asi detectamos las paredes del mapa para gestionar las colisiones. Por lo tanto, este...
    //...método devuelve la matriz.
    public boolean[][] crearLimite2(TiledMap mapa) {
        int totalTilesWidth = mapa.getWidth() * 2;
        int totalTilesHeight = mapa.getHeight() * 2;
        obstaculo = new boolean[totalTilesWidth][totalTilesHeight];
        for (int i = 0; i < totalTilesWidth; i++) {
            for (int j = 0; j < totalTilesHeight; j++) {
                obstaculo[i][j] = ((mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 4")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 3")) != 0) || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 2")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("extra")) != 0) || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("extra1")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de Patrones 1")) != 0));
            }
        }
        return obstaculo;
    }

    //Este método a partir de las capas del TiledMap del mapa3 crea una matriz en la cual se recorre el TiledMap y si...
    //...hay algún objeto de esas capas de la pared en la posición correspondiente en la matriz pone un true...
    //...o un false. Asi detectamos las paredes del mapa para gestionar las colisiones. Por lo tanto, este...
    //...método devuelve la matriz.
    public boolean[][] crearLimite3(TiledMap mapa) {
        int totalTilesWidth = mapa.getWidth() * 2;
        int totalTilesHeight = mapa.getHeight() * 2;
        obstaculo = new boolean[totalTilesWidth][totalTilesHeight];
        for (int i = 0; i < totalTilesWidth; i++) {
            for (int j = 0; j < totalTilesHeight; j++) {
                obstaculo[i][j] = ((mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 4")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 3")) != 0) || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 2")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("base_pared")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 5")) != 0));
            }
        }
        return obstaculo;
    }

    //Este método a partir de las capas del TiledMap del mapa4 crea una matriz en la cual se recorre el TiledMap y si...
    //...hay algún objeto de esas capas de la pared en la posición correspondiente en la matriz pone un true...
    //...o un false. Asi detectamos las paredes del mapa para gestionar las colisiones. Por lo tanto, este...
    //...método devuelve la matriz.
    public boolean[][] crearLimite4(TiledMap mapa) {
        int totalTilesWidth = mapa.getWidth() * 2;
        int totalTilesHeight = mapa.getHeight() * 2;
        obstaculo = new boolean[totalTilesWidth][totalTilesHeight];
        for (int i = 0; i < totalTilesWidth; i++) {
            for (int j = 0; j < totalTilesHeight; j++) {
                obstaculo[i][j] = ((mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 4")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 3")) != 0) || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 2")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de Patrones 1")) != 0)
                        || (mapa.getTileId(i / 2, j / 2, mapa.getLayerIndex("Capa de patrones 5")) != 0));
            }
        }
        return obstaculo;
    }
}
