package creatures.enemies;

import creatures.EnemyFactory;
import creatures.Player;
import gameSystem.World;
import generationProcedurale.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DragonTest {

    Player player = new Player();
    World world =new World(player , 100 ,100) ;
    Dragon dragon = (Dragon) EnemyFactory.createNewEnemy(Tile.DRAGON,1, player.getPositionX()+2, player.getPositionY());



    @Test
    void move() {
        /*

        boolean have_attack_distance = false ;

        dragon.move(player, world.getEnnemies(), world.getTiles());

                if (dragon.getFireLine().size() != 0 )
        {
            have_attack_distance =true ;
        }

        assert (have_attack_distance =true) ;

         */

    }


}

