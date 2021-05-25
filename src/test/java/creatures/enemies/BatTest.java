package creatures.enemies;

import creatures.EnemyFactory;
import creatures.Player;
import gameSystem.World;
import generationProcedurale.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatTest {

    Player player = new Player();
    World world =new World(player , 100 ,100) ;
    Bat bat = (Bat) EnemyFactory.createNewEnemy(Tile.BAT,1, player.getPositionX()+1, player.getPositionY()+1);



    @Test
    void move() {

        world.getEnnemies().add(bat);

        int nbr_ennemies_avant = world.getEnnemies().size();

        bat.move(player, world.getEnnemies(), world.getTiles()) ;
        int nbr_ennemies_arpes = world.getEnnemies().size();


        assert(nbr_ennemies_avant<= nbr_ennemies_arpes) ;//the bat se duplicate







    }
}