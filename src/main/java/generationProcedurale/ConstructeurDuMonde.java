package generationProcedurale;


import creatures.Enemy;
import creatures.EnemyFactory;
import creatures.Player;

import java.util.ArrayList;
import java.util.Random;

public class ConstructeurDuMonde {

    Tile[][] tiles;
    int lignes;
    int colonnes;
    private int maxRooms = 5;
    private int maxRoomSize = 10;
    private int minRoomSize = 5;
    Random random = new Random();
    ArrayList<Room> rooms = new ArrayList<Room>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();


    public ConstructeurDuMonde(Player player, int lignes, int colonnes) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.maxRooms = maxRooms;
        this.maxRoomSize = maxRoomSize;
        this.minRoomSize = minRoomSize;
        tiles = create(lignes, colonnes);
        placeRooms();
        initPlayerPosition(player);
        initEnemiesPosition(player);

    }

    //setters
    public void setTile(int x, int y, Tile t) {
        tiles[y][x] = t;
    }


    //getters
    public int getMaxRooms() {
        return maxRooms;
    }

    public int getMaxRoomSize() {
        return maxRoomSize;
    }

    public int getMinRoomSize() {
        return minRoomSize;
    }

    public Tile[][] getTiles() {
        return tiles;
    }


    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public ArrayList<Enemy> getenemies() {
        return enemies;
    }

    private Tile[][] create(int l, int c) {
        Tile[][] vect = new Tile[l][c];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {


                vect[i][j] = Tile.MUR;


            }

        }
        return vect;
    }


    public void createRoom(Room r) {
        for (int i = r.getY1(); i < r.getY2(); i++) {
            for (int j = r.getX1(); j < r.getX2(); j++) {
                tiles[i][j] = Tile.SOL;

            }

        }
    }


    public void placeRooms() {

        int nbTry = 0;
        int i = 0;
        while (i < maxRooms && nbTry < 1000) {
            nbTry++;
            int w = minRoomSize + random.nextInt(maxRoomSize - minRoomSize + 1) + 10;
            int h = minRoomSize + random.nextInt(maxRoomSize - minRoomSize + 1);
            int x = random.nextInt(colonnes - w - 1) + 1;
            int y = random.nextInt(lignes - h - 1 - 10) + 1;

            // create room with randomized values
            Room newRoom = new Room(x, y, w, h);

            boolean failed = false;

            for (Room r : rooms) {
                if (newRoom.intersects(r)) {
                    failed = true;
                    break;
                }

            }

            if (!failed) {
                createRoom(newRoom);
                if (!rooms.isEmpty()) {
                    createCouloirHorizontal(newRoom.center, rooms.get(rooms.size() - 1).center);//
                    createCouloirVertical(newRoom.center, rooms.get(rooms.size() - 1).center);//
                }
                rooms.add(newRoom);
                i++;
            }


        }
        if (nbTry > 1000) {
            System.out.println("nombre de maxRoom tres grand !!!");
            System.out.println("nombre de try : " + nbTry);
            System.out.println("nombre de rooms generer :" + rooms.size());
        }


    }


    public void createCouloirHorizontal(Center c1, Center c2) {
        int minX;
        int y;
        if (c1.getCenterX() < c2.getCenterX()) {
            minX = c1.getCenterX();
            y = c1.getCenterY();
        } else {
            minX = c2.getCenterX();
            y = c2.getCenterY();

        }

        int maxX = Math.max(c1.getCenterX(), c2.getCenterX());

        for (int i = minX; i <= maxX; i++) {
            tiles[y][i] = Tile.SOL;
        }


    }

    public void createCouloirVertical(Center c1, Center c2) {
        int minY;
        int x;
        if (c1.getCenterY() < c2.getCenterY()) {
            minY = c1.getCenterY();
            x = c1.getCenterX() + c2.getCenterX();
        } else {
            minY = c2.getCenterY();
            x = c2.getCenterX() + c1.getCenterX();

        }
        x = Math.max(c1.getCenterX(), c2.getCenterX());

        int maxY = Math.max(c1.getCenterY(), c2.getCenterY());

        for (int i = minY; i <= maxY; i++) {
            tiles[i][x] = Tile.SOL;
        }


    }


    //initialize player position at center of room 1
    public void initPlayerPosition(Player player) {
        player.setPositionX(rooms.get(0).getCenter().getCenterX());
        player.setPositionY(rooms.get(0).getCenter().getCenterY());
        tiles[player.getPositionY()][player.getPositionX()] = Tile.PLAYER;

    }

    //Create a room.size number of enemies and fill the array of enemies
    public void initEnemiesPosition(Player player) {
        int x;
        int y;
        int proba;
        int level = player.getLevel();
        for (Room r : rooms) {
            x = r.getX1() + random.nextInt(r.getX2() - r.getX1());
            y = r.getY1() + random.nextInt(r.getY2() - r.getY1());

            proba = random.nextInt(10) + 1;

            switch (proba) {
                case 1:
                case 2:
                case 3:
                case 4: //probabilty of 40% that enemy is a zombie
                    setTile(x, y, Tile.ZOMBIE);
                    enemies.add(EnemyFactory.createNewEnemy(EnemyFactory.Entity.ZOMBIE, level, x, y));
                    break;
                case 5:
                case 6:
                case 7://probabilty of 30% that enemy is a snake
                    setTile(x, y, Tile.SNAKE);
                    enemies.add(EnemyFactory.createNewEnemy(EnemyFactory.Entity.SNAKE, level, x, y));
                    break;

                case 8:
                case 9://probabilty of 20% that enemy is a wolf
                    setTile(x, y, Tile.WOLF);
                    enemies.add(EnemyFactory.createNewEnemy(EnemyFactory.Entity.WOLF, level, x, y));
                    break;

                case 10://probabilty of 10 % that enemy is a dragon
                    setTile(x, y, Tile.DRAGON);
                    enemies.add(EnemyFactory.createNewEnemy(EnemyFactory.Entity.DRAGON, level, x, y));
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: " + proba);
            }


        }

    }


}
