package creatures;

public class CreatureFactory {

    public enum Entity {
        PLAYER ,ZOMBIE
    }


    public static Creature createNewCreature( Entity e , int x ,int y)
    {
        switch (e){
            case PLAYER : return new Player();
            case  ZOMBIE    : return new Enemy(x,y);
        }
        return null ;
    }
}
