import generationProcedurale.Tile;
import items.Item;

import java.util.ArrayList;

public class Test {


    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<Item>();
        ArrayList<Item> items2 = new ArrayList<Item>();

        items.add(new Item(Tile.FOOD,500 , 1 ,1));
        items.add(new Item(Tile.FOOD,500 , 1 ,1));
        items.add(new Item(Tile.FOOD,500 , 1 ,1));

        items2.add(new Item(Tile.FOOD,1000 , 1 ,1));
        items2.add(new Item(Tile.FOOD,1000 , 1 ,1));

        items.addAll(items2) ;

        for (Item i : items)
        {
            System.out.println("vous avez recuperé "+ i.toString());
        }




    }
}
