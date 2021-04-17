package creatures;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {
    Random random = new Random();
    Enemy enemy =new Enemy(5,5);
   int attack = enemy.attack();






    @Test
    public void takeDamage() {
        int previousHealth = enemy.getHealth();

        assertEquals(0,enemy.takeDamage(50));// damage égale ou inférieure à la défense de l'ennemie
        enemy.takeDamage(70);
        assertTrue(previousHealth >= enemy.getHealth());// damage supérieure  à la défense de l'ennemie
    }
}