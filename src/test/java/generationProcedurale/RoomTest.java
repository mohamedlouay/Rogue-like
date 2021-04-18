package generationProcedurale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room r1 = new Room(10,10,10,10);


    @Test
    void intersects() {
        // case two room disjoint
        assertFalse(r1.intersects(new Room(30,30,10,10)));

        // case contact in the edge of the two rooms
        assertTrue(r1.intersects(new Room(20,20,10,10)));

        // case room 1 contain room 2
        assertTrue(r1.intersects(new Room(11,11,7,7)));


        // case room 1 partial contain  room 2
        assertTrue(r1.intersects(new Room(15,15,10,10)));
    }
}