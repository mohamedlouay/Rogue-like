package items;

import generationProcedurale.Tile;

public class Item {

    Tile tile ;
    int value ;

    int x;
    int y ;

    public Item(Tile tile, int value, int x , int y) {
        this.tile = tile;
        this.value = value;
        this.x=x;
        this.y=y;
    }


    public Tile getTile() {
        return tile;
    }

    public int getValue() {
        return value;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }



    @Override
    public String toString() {
        return "Item{" +"type=" + tile +", value=" + value +
                '}';
    }
}
