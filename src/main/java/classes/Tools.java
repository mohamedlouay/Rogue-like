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
            case 3:
                return '?';
            case 4:
                return '.';
            case 5:
                return '|';
            case 6:
                return 'X';
            case 7:
                return '#';
            default:
                return '/';
        }
    }
    public static float distance(int x1, int y1,int x2,int y2){
        return ((x1-x2)^2+(y1-y2)^2)^(1/2);
    }
}
