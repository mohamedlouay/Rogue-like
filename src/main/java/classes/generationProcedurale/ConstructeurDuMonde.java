package classes.generationProcedurale;
import java.util.ArrayList;
import java.util.Random;

public class ConstructeurDuMonde{

    char[][] map;
    int lignes;
    int colonnes;
    private int maxRooms = 5;
    private int maxRoomSize = 15;
    private int minRoomSize = 10;
    ArrayList<Room> rooms = new ArrayList<Room>();
    Random random = new Random();

    public ConstructeurDuMonde(int lignes, int colonnes , int maxRooms ,int  maxRoomSize , int minRoomSize) {
        this.lignes = lignes;
        this.colonnes = colonnes;
        this.maxRooms=maxRooms;
        this.maxRoomSize=maxRoomSize;
        this.minRoomSize=minRoomSize;

        map = initialiser(lignes, colonnes);
        placeRooms();


    }

    public int getLignes() {
        return lignes;
    }

    public int getColonnes() {
        return colonnes;
    }

    public int getMaxRooms() {
        return maxRooms;
    }

    public int getMaxRoomSize() {
        return maxRoomSize;
    }

    public int getMinRoomSize() {
        return minRoomSize;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public char[][] getMap() {
        return map;
    }

    private char[][] initialiser(int l, int c) {
        char[][] vect = new char[l][c];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < c; j++) {

                if ((i == 0) || (j == 0) || (i == l - 1) || (j == c - 1))//creer le cadre
                {
                    vect[i][j] = '#';
                } else {
                    vect[i][j] = ' ';
                }


            }

        }
        return vect;
    }


    public void createRoom(Room r) {
        for (int i = r.getY1(); i < r.getY2(); i++) {
            for (int j = r.getX1(); j < r.getX2(); j++) {
                map[i][j] = '.';

            }

        }
    }


    public void placeRooms() {


        int i = 0;
        while (i < maxRooms) {
            int w = minRoomSize + random.nextInt(maxRoomSize - minRoomSize + 1);
            int h = minRoomSize + random.nextInt(maxRoomSize - minRoomSize + 1);
            int x = random.nextInt(colonnes - w - 1) + 1;
            int y = random.nextInt(lignes - h - 1 - 10) + 1;

            // create room with randomized values
            Room newRoom = new Room(x, y, w, h);

            boolean failed = false;

            for (Room r : rooms) {
                if (r.intersects(newRoom)) {
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
            map[y][i] = '.';
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
            map[i][x] = '.';
        }


    }

    public void display()
    {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j]);

            }
            System.out.println();

        }
    }






}
