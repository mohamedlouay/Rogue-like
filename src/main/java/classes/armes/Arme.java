package classes.armes;

public abstract class Arme {
   private  int distanceDAttack =0;
    private int puissance =0;

    public String getNom() {
        return nom;
    }

    String nom="";

    public void setDistanceDAttack(int distanceDAttack) {
        this.distanceDAttack = distanceDAttack;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public int getDistanceDAttack() {
        return distanceDAttack;
    }

    public int getPuissance() {
        return puissance;
    }


}
