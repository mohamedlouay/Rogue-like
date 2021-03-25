package classes;

import classes.Tile;
import classes.generationProcedurale.ConstructeurDuMonde;

public class World {
    private Tile[][] tiles;
    private int colonnes;
    private int lignes;
    private int maxRooms = 5;
    private int maxRoomSize = 15;
    private int minRoomSize = 10;
    ConstructeurDuMonde worldBuilder;

    public World(int lignes, int colonnes) {

        this.colonnes = colonnes;
        this.lignes = lignes;
        worldBuilder = new ConstructeurDuMonde(lignes, colonnes, this.minRoomSize, this.maxRoomSize, this.maxRooms);

        this.tiles = worldBuilder.getMap();
    }

    public World(int lignes, int colonnes, int minRoomSize, int maxRoomSize, int maxRooms) {

        this.colonnes = colonnes;
        this.lignes = lignes;
        worldBuilder = new ConstructeurDuMonde(lignes, colonnes, minRoomSize, maxRoomSize, maxRooms);

        this.tiles = worldBuilder.getMap();
    }

    public void display() {
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.colonnes; j++) {
                System.out.print(this.tiles[i][j].getValue());
            }
            System.out.println();

        }
    }



}




