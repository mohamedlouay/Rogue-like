import classes.Camera;
import classes.Monde;
import classes.Player;
import classes.Salle;

public class Main {
    //
    public static void main(String[] args) {

        Camera camera= new Camera(0,0,200,40);
        Monde monde=new Monde(500,500);
        Player player = new Player(11,6,monde);

        monde.setCamera(camera);
        // ajouter des salles :*********************************************
        monde.ajouterUneSalle(new Salle(10,5,20,20));
        monde.ajouterUneSalle(new Salle(40,20,40,10));
        monde.ajouterUneSalle(new Salle(90,5,70,15));
        monde.ajouterUneSalle(new Salle(180,5,70,15));


        //ajouter des passages :
        monde.ajouterUneSalle(new Salle(30,10,60,2));
        monde.ajouterUneSalle(new Salle(70,24,60,2));
        monde.ajouterUneSalle(new Salle(124,20,6,5));

        //*******************************************************************
        monde.addPlayer(player);
        player.deplacerADroite();

        camera.setX(0);


        monde.afficher();
        monde.actulaiser();
    }




    }







