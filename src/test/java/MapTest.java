import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class MapTest {


    Map map  =new Map("map1.txt",new Player());

    public MapTest() throws IOException {
    }


    @Test
    void readMapTest() throws IOException {
        char[][] vect =map.readMap("maps/map1.txt") ;
        int nbLine = vect.length;
        int nbColonne = vect[0].length;

        for (int i = 0; i < nbLine; i++) {
            Assertions.assertEquals('#', vect[i][0]);
            Assertions.assertEquals('#', vect[i][nbColonne-1]);
            Assertions.assertEquals('#', vect[0][i]);
            Assertions.assertEquals('#', vect[nbLine-1][i]);
        }
    }

    @Test
    void setPositionTest ()
    {

    }
    @Test
    void movePlayerTest()
    {

    }
    @Test
    void tryMovePlayerTest()
    {

    }
    @Test
    void getTileTest()
    {

    }




}
