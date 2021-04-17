package creatures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player = new Player();

    @Test
    void addExperience() {
        int experience = player.getExperience();
        int level = player.getLevel();


        player.addExperience(50);// experience < 100

        assertEquals(level , player.getLevel());
        assertEquals(experience + 50  , player.getExperience());


        player.addExperience(70);// experience total = 120

        assertEquals(level +1 , player.getLevel());
        assertEquals(20 , player.getExperience());

    }

    @Test
    void takeDamage() {

        int previousHealth = player.getHealth();

        assertEquals(0,player.takeDamage(50));// damage égale ou inférieure à la défense de joueur
        player.takeDamage(70);
        assertTrue(previousHealth >= player.getHealth());// damage supérieure  à la défense de joueur

    }
}