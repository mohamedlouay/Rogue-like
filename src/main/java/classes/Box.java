package classes;

import java.util.Random;

public class Box {
    private  boolean estOuvert=false;
    private int x;
    private int y;
    private  int valeur;

    public Box(int x, int y){
        this.x=x;
        this.y=y;
        Random r = new Random();
        this.valeur= r.nextInt((100 - 10) + 1) + 10;
    }
    public boolean estOuvert() {
        return estOuvert;
    }
    public void open(){
        estOuvert=true;
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
