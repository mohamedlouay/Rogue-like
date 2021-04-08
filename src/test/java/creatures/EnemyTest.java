package creatures;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    Random random = new Random();

    Player player = new Player();
    Enemy enemy = new Enemy(5,5);


    @Test
    void moveEnemy() {

        player.setPosition(10,7);//le player à droite de l'enemie et dans sa zone et x>y
        assertEquals('D',enemy.moveEnemy(player.getPositionX(),player.getPositionY()));

        player.setPosition(1,7);//le player à gauche de l'enemie et dans sa zone et x<y
        assertEquals('Q',enemy.moveEnemy(player.getPositionX(),player.getPositionY()));

        player.setPosition(7,10);//le player au dessous de l'enemie et dans sa zone et x<y
        assertEquals('W',enemy.moveEnemy(player.getPositionX(),player.getPositionY()));

        player.setPosition(7,1);//le player au dessus de l'enemie et dans sa zoneet x>y
        assertEquals('Z',enemy.moveEnemy(player.getPositionX(),player.getPositionY()));


        player.setPosition(random.nextInt(), random.nextInt());//le player n'est pas dans la zone de l'enemie
        assertTrue("ZQDW".indexOf(enemy.moveEnemy(player.getPositionX(),player.getPositionY()))!=-1);

    }
}