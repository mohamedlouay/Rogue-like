import classes.Camera;
import classes.Monde;
import classes.Salle;

public class Main {
    //
    public static void main(String[] args) {
        Monde monde;
        Camera camera;
        camera= new Camera(0,0,200,40);
        monde=new Monde(500,500);
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
        camera.setX(0);

        monde.afficher();
    }
}



