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
            case  SNAKE    : return new Enemy(Tile.SNAKE,120,70,60,80,x,y);
            case  WOLF    : return new Enemy(Tile.WOLF,150,90,100,100,x,y);
            case  DRAGON    : return new Enemy(Tile.DRAGON,200,150,300,200,x,y);

        }
        return null ;
    }
}
