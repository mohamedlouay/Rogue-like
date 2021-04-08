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
        int damage = random.nextInt(100);
        assertTrue(enemy.takeDamage(damage)>=0);// n'est pas un nombre negatif

    }
}