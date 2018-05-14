package VideojuegoEstados;

import org.newdawn.slick.tiled.TiledMap;

public class LimitesMapa {

    private boolean[][] obstaculo;

    public LimitesMapa() {
    }

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
