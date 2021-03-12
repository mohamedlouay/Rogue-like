package classes;

public class Tools {
    public static char getSymbole(int i){
        //choix de symboles :

        switch(i){
            // afficher un espace pour le vide
            case 0:
                return ' ';
                //afficher un point pour les places disponibles :
            case 1:
                return '.';
            case 2:
                return '@';
            default:
                return '/';
        }
    }
}
