package classes;

import java.util.Random;

public class Box {
    int x;
    int y;
    int valeur;
    Box(int x,int y){
        this.x=x;
        this.y=y;
        Random r = new Random();
        this.valeur= r.nextInt((100 - 10) + 1) + 10;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValeur() {
        return valeur;
    }
}
