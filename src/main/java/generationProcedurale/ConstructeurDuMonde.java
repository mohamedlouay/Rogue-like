package generationProcedurale;

import creatures.CreatureFactory;
import creatures.Enemy;
import creatures.Player;

import java.util.ArrayList;
import java.util.Random;

public class ConstructeurDuMonde {

    Tile[][] tiles;
    int lignes;
    int colonnes;
    private int maxRooms;
    private int maxRoomSize;
    private int minRoomSize;
    Random random = new Random();
    ArrayList<Room> rooms = new ArrayList<Room>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();


    public ConstructeurDuMonde(Player player,int lignes, int colonnes, int maxRooms, int minRoomSize, int maxRoomSize) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.maxRooms = maxRooms;
        this.maxRoomSize = maxRoomSize;
        this.minRoomSize = minRoomSize;
        tiles = create(lignes, colonnes);
        placeRooms();
        initPlayerPosition(player);
        initEnemiesPosition();

    }

    //setters
    public void setTile (int x , int y , Tile t )
    {
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
    public ArrayList<Enemy> getenemies() {return enemies;}

    private Tile[][] create(int l, int c) {
        Tile[][] vect = new Tile[l][c];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {

                if ((i == 0) || (j == 0) || (i == l - 1) || (j == c - 1))//creer le cadre
                {
                    vect[i][j] = Tile.EDGE;
                } else {
                    vect[i][j] = Tile.MUR;
                }


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


    private void placeRooms() {

        int nbTry = 0 ;
        int i = 0;
        while (i < maxRooms && nbTry <1000) {
            nbTry++;
            int w = minRoomSize + random.nextInt(maxRoomSize - minRoomSize + 1);
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
        if (nbTry >1000 ){
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
    public void initPlayerPosition(Player player)
    {
        player.setPositionX(rooms.get(0).getCenter().getCenterX());
        player.setPositionY(rooms.get(0).getCenter().getCenterY());
        tiles[player.getPositionY()][player.getPositionX()] = Tile.PLAYER ;

    }

    //Create a room.size number of enemies and fill the array of enemies
    public void initEnemiesPosition()
    {
        int x ;
        int y ;
        for (Room r :rooms)
        {
            x = r.getX1() + random.nextInt(r.getX2() - r.getX1() );
            y = r.getY1() + random.nextInt(r.getY2() - r.getY1() );

            setTile(x,y,Tile.ZOMBIE);
            //enemies.add(new Enemy(x,y));
            enemies.add((Enemy) CreatureFactory.createNewCreature(CreatureFactory.Entity.ZOMBIE,x,y));


        }

    }




}
