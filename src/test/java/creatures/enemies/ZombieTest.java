package creatures.enemies;

import creatures.EnemyFactory;
import creatures.Player;
import gameSystem.World;
import generationProcedurale.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZombieTest {

    Player player = new Player();
    World world =new World(player , 100 ,100) ;
    Zombie zombie = (Zombie) EnemyFactory.createNewEnemy(Tile.ZOMBIE,1, player.getPositionX()+1, player.getPositionY()+1);


    @Test
    void move() {


        world.getEnnemies().add(zombie);
        boolean have_switched_to_invisble =false ;

        for (int i = 0; i < 20; i++) {

            zombie.move(player, world.getEnnemies(),world.getTiles());
            if (zombie.tile == Tile.ZOMBIE_INVISIBLE)
            {have_switched_to_invisble =true ;}

        }

        assert (have_switched_to_invisble == true) ;//that the zombie have been switche to invisible zombie at least one





    }
}