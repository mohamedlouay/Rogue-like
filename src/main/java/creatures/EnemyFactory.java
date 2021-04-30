package creatures;

import generationProcedurale.Tile;

public class EnemyFactory {




    public static Enemy createNewEnemy(Tile e , int level, int x , int y)
    {

        int evolution = level * 10;

        switch (e){

            case  ZOMBIE    : return new Enemy(Tile.ZOMBIE,100,30+evolution,20+evolution,60,x,y);
            case  SNAKE    : return new Enemy(Tile.SNAKE,100,50+evolution,40+evolution,80,x,y);
            case  WOLF    : return new Enemy(Tile.WOLF,100,70+evolution,60+evolution,100,x,y);
            case  DRAGON    : return new Enemy(Tile.DRAGON,100,100+evolution,80+evolution,200,x,y);

        }
        return null ;
    }
}
