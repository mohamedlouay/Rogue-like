package items;

import generationProcedurale.Tile;

public class ItemsFactory {




    public static Item createNewItem(Tile t , int level, int x , int y)
    {

        int evolution = level * 10;

        switch (t){

            case MONEY: return new Item(Tile.MONEY,100+evolution,x,y) ;
            case INVISIBILITY_CLOAK: return  new Item(Tile.INVISIBILITY_CLOAK,10 + evolution,x,y);
            case FOOD: return new Item(Tile.FOOD,30+evolution,x,y) ;


        }
        return null ;

    }





}
