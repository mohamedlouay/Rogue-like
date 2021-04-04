package classes.scenes;

import classes.Box;
import classes.Camera;
import classes.Monde;
import classes.Player;

public class PlayScene extends Scene{
    Monde monde;
    @Override
    public void initialiser() {

        Camera camera= new Camera(0,0,40,40);
        monde=new Monde(200,35);
        Player player = new Player(monde);

        monde.setCamera(camera);
        //*******************************************************************
        // ajouter une Box :
        monde.ajouterUneBox(new Box(15,10));
        //********************************************************************
        //update

        monde.addPlayer(player);
        player.deplacerADroite();

        camera.setX(0);

    }

    @Override
    public void afficher() {
        monde.afficher();
    }

    @Override
    public void actualiser() {
        monde.actulaiser();
    }
}
