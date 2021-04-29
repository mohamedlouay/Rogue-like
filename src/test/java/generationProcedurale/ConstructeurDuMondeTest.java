package generationProcedurale;

import creatures.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ConstructeurDuMondeTest {

    ArrayList<Room> rooms = new ArrayList<Room>();
    Player player = new Player();
    ConstructeurDuMonde world = new ConstructeurDuMonde(player,100,300);


    @Test
    void placeRooms() {

        for (int i = 0 ; i< world.rooms.size();i++)
        {
            for (int j = i+1  ;j < world.rooms.size();j++)
            {
                // assert that all the rooms are disjointed
                assertFalse(world.rooms.get(j).intersects(world.rooms.get(i)));
            }
        }




    }


    @Test
    void initPlayerPosition() {

        //assert that the player is the midlle of room 1
        assertTrue(player.getPositionX() == world.rooms.get(0).getCenter().getCenterX());
        assertTrue(player.getPositionY() == world.rooms.get(0).getCenter().getCenterY());

    }

    @Test
    void initEnemiesPosition() {
        Boolean found ;

        for (Room r : world.rooms) {
            found =false ;
            outerloop:
            for (int i = r.getY1(); i < r.getY2(); i++) {
                for (int j = r.getX1() ; j< r.getX2(); j++) {
                    if ("ZDL".indexOf(world.tiles[i][j].getSymbole() ) != -1){

                        found = true ;
                        System.out.println("i "  + i + " j  "+ j);
                        System.out.println("------");
                        break outerloop ;

                    }

                }
            }

            assertTrue(found);//assert than every room cantain a enemy

        }


    }


}