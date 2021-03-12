package classes;

public class Tools {
    public static char getSymbole(int i){
        switch(i){
            case 0:
                return ' ';
            case 1:
                return '.';
            default:
                return '/';
        }
    }
}
