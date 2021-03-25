package classes.generationProcedurale;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstructeurDuMondeTest {

    ConstructeurDuMonde worldBuilder= new  ConstructeurDuMonde( 50,  70 , 5 ,15, 10);


    @Test
    void createCouloirHorizontal() {
    }

    @Test
    void createCouloirVertical() {
    }

    @Test
    void placeRooms() {

        for (int i = 0; i < worldBuilder.getRooms().size()-1; i++) {
            for (int j = i+1; j < worldBuilder.getRooms().size(); j++) {
                // Vérifier si toutes les salles sont séparées
                assertFalse(worldBuilder.getRooms().get(i).intersects(worldBuilder.getRooms().get(j)));

            }

        }
        // Vérifier si le nombre des salles crée égale au nombre des salles maximales
        assertEquals(worldBuilder.getMaxRooms(), worldBuilder.getRooms().size());
    }

}