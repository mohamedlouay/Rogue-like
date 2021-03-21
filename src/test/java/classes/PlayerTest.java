package classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {


    Camera camera= new Camera(0,0,200,40);
    Monde monde=new Monde(500,500);
    Player player = new Player(11,6,monde);

    @Test
    void deplacerADroite() {
    }

    @Test
    void deplacerAGauche() {
    }

    @Test
    void deplacerEnHaut() {
    }

    @Test
    void deplacerEnBas() {
    }

    @Test
    void actualiser() {
    }
}