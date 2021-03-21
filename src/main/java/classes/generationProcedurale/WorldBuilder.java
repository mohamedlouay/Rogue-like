package classes.generationProcedurale;
/*
public class WorldBuilder {

    private Tile[][] tiles;
    private int width ;
    private int height ;

    public  WorldBuilder(int width ,int height)
    {
        this.width=width ;
        this.height=height ;
        this.tiles = new Tile[width][height];


    }

    public Test build()
    {
        return new Test(tiles) ;
    }

    private WorldBuilder randomizeTiles() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
            }
        }
        return this;
    }

    private WorldBuilder smooth(int times) {
        Tile[][] tiles2 = new Tile[width][height];
        for (int time = 0; time < times; time++) {

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int floors = 0;
                    int rocks = 0;

                    for (int ox = -1; ox < 2; ox++) {
                        for (int oy = -1; oy < 2; oy++) {
                            if (x + ox < 0 || x + ox >= width || y + oy < 0
                                    || y + oy >= height)
                                continue;

                            if (tiles[x + ox][y + oy] == Tile.FLOOR)
                                floors++;
                            else
                                rocks++;
                        }
                    }
                    tiles2[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
                }
            }
            tiles = tiles2;
            display(tiles,width,height) ;
            System.out.println("-----------------------------------------------------");

        }
        return this;
    }
    public WorldBuilder makeCaves() {
        return randomizeTiles().smooth(8);
    }

    public void display (Tile[][] tiles , int n , int m)
    {
        for (int k = 0; k <n ; k++) {
            for (int l = 0; l < m; l++) {
                System.out.print(tiles[k][l].getCaractere());

            }
            System.out.println(   );

        }


    }

    public static void main(String[] args) {
        WorldBuilder w = new WorldBuilder(30,100);

        w.makeCaves();
    }



}
*/