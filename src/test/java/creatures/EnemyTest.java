package creatures;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
    Random random = new Random();

    Player player = new Player();
    Enemy enemy =EnemyFactory.createNewEnemy(EnemyFactory.Entity.ZOMBIE,1,5,5);



    @Test
    void moveEnemy() {


        player.setPosition(10,7);//le player à droite de l'ennemie et dans sa zone et x>y
        assertEquals('D',enemy.moveEnemy(player));

        player.setPosition(1,7);//le player à gauche de l'ennemie et dans sa zone et x<y
        assertEquals('Q',enemy.moveEnemy(player));

        player.setPosition(7,10);//le player au dessous de l'ennemie et dans sa zone et x<y
        assertEquals('W',enemy.moveEnemy(player));

        player.setPosition(7,1);//le player au dessus de l'ennemie et dans sa zoneet x>y
        assertEquals('Z',enemy.moveEnemy(player));


        player.setPosition(random.nextInt(), random.nextInt());//le player n'est pas dans la zone de l'ennemie
        assertTrue("ZQDW".indexOf(enemy.moveEnemy(player))!=-1);

    }
}