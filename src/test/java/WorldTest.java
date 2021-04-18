import classes.armes.Arme;
import creatures.Enemy;
import creatures.Player;
import generationProcedurale.Tile;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldTest {

    Player player = new Player();
    World world = new World(player , 100,300);

    @Test
    void movePlayer() {

        //case 1 : player can move to the next right tile
        int oldX = player.getPositionX();
        int oldY = player.getPositionY();
        world.setTile(oldX+1, oldY, Tile.SOL);
        world.movePlayer('D',player);
        assertEquals(oldX+1,player.getPositionX());
        assertEquals(oldY,player.getPositionY());



        //case 2 : player can't move to the next right tile (MUR)

        world.setTile(oldX+1, oldY, Tile.MUR);
        world.movePlayer('D',player);
        assertEquals(oldX,player.getPositionX());
        assertEquals(oldY,player.getPositionY());

        //case 3 : player can't move to the next right tile (Enemy)
        //we call battle function

        world.setTile(oldX+1, oldY, Tile.ZOMBIE);
        world.movePlayer('D',player);
        assertEquals(oldX,player.getPositionX());
        assertEquals(oldY,player.getPositionY());



        //case 4 : player want to change current weapon
        Arme oldWeapon = player.getArme();
        world.movePlayer('A',player);

        assertNotEquals(oldWeapon,player.getArme());

    }













    @Test
    void battleAdistance() {
        //demander le prof comment faire un test Junit avec un input dans la fonction
/*
        Enemy enemy1 = new Enemy(player.getPositionX()+2, player.getPositionY());
        System.out.println("health of the enemy : "+ enemy1.getHealth());
        world.enemies.add(enemy1);

        player.changerDArme(3);player.changerDArme(3);//arme = lance

        world.battleAdistance(player);
        System.out.println("after health of the enemy : "+ enemy1.getHealth());


*/

    }

    @Test
    void distance() {

        int x1=10;
        int y1=10;
        int x2=20;
        int y2=20;
        assertEquals(14 , world.distance(10,10,20,20));
        assertEquals(14 , world.distance(10,10,0,0));


    }

    @Test
    void moveEnemies() {
        //same as the player method movePlayer
    }

    @Test
    void battleEnemey() {

        //demander le prof comment faire un test Junit avec un input dans la fonction
    }
}