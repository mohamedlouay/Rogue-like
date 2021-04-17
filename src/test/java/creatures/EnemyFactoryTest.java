package creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnemyFactoryTest {

    Creature entity ;


    @Test
    void createNewEnemy() {

        entity = EnemyFactory.createNewEnemy(EnemyFactory.Entity.ZOMBIE,1,1);
        assertTrue(entity instanceof Enemy);

        entity = EnemyFactory.createNewEnemy(EnemyFactory.Entity.DRAGON,1,1);
        assertTrue(entity instanceof Enemy);

    }
}