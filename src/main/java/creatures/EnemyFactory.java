package creatures;

import generationProcedurale.Tile;

public class EnemyFactory {

    public enum Entity {
        ZOMBIE,DRAGON ,SNAKE , WOLF;
    }


    public static Enemy createNewEnemy( Entity e , int x ,int y)
    {
        switch (e){

            case  ZOMBIE    : return new Enemy(Tile.ZOMBIE,100,50,20,60,x,y);
            case  SNAKE    : return new Enemy(Tile.SNAKE,100,70,35,80,x,y);
            case  WOLF    : return new Enemy(Tile.WOLF,100,90,60,100,x,y);
            case  DRAGON    : return new Enemy(Tile.DRAGON,100,150,100,200,x,y);

        }
        return null ;
    }
}
