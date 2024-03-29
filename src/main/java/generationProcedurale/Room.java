package generationProcedurale;


public class Room {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    public Center center;


    public int w;
    public int h;


    public Room(int x, int y, int w, int h) {
        this.x1 = x;
        this.x2 = x + w;
        this.y1 = y;
        this.y2 = y + h;
        this.center = new Center((int) (this.x1 + this.x2) / 2, (int) (this.y1 + this.y2) / 2);

    }
    //Getters

    public int getX1() {
        return x1;
    }

    public int getX2() {
        return x2;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }
    public Center getCenter() {        return center;    }



    public boolean intersects(Room room) {
        return (x1 <= room.x2 && x2 >= room.x1 && y1 <= room.y2 && room.y2 >= room.y1);


    }





}


