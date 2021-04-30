package creatures;

import generationProcedurale.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyFactoryTest {

    Creature entity ;


    @Test
    void createNewEnemy() {

        entity = EnemyFactory.createNewEnemy(Tile.ZOMBIE,1,1,1);
        assertTrue(entity instanceof Enemy);

        entity = EnemyFactory.createNewEnemy(Tile.DRAGON,1,1,1);
        assertTrue(entity instanceof Enemy);

    }
}