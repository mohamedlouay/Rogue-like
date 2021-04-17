package creatures;

public class EnemyFactory {

    public enum Entity {
        ZOMBIE,DRAGON ;
    }


    public static Enemy createNewEnemy( Entity e , int x ,int y)
    {
        switch (e){

            case  ZOMBIE    : return new Enemy(x,y);
        }
        return null ;
    }
}
