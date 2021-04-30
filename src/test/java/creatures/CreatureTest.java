package creatures;

import generationProcedurale.Tile;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {
    Random random = new Random();
    Enemy enemy =EnemyFactory.createNewEnemy(Tile.ZOMBIE,1,5,5 );
   int attack = enemy.attack();






    @Test
    public void takeDamage() {
        int previousHealth = enemy.getHealth();

        assertEquals(0,enemy.takeDamage(50));// damage égale ou inférieure à la défense de l'ennemie
        enemy.takeDamage(70);
        assertTrue(previousHealth >= enemy.getHealth());// damage supérieure  à la défense de l'ennemie
    }
}