package classes.armes;

public class Lance extends Arme {
    int nombre=1;
    public Lance(){
        nombre=3;
        this.setDistanceDAttack(4);
        this.setPuissance(130);
        this.nom="lance"+ " (X"+nombre+")";
    }
    public void sous_lance(){
        this.nombre--;
        this.nom="lance"+ " (X"+nombre+")";

    }
    public void add_lance(int a){
        this.nombre+=a;
        this.nom="lance"+ " (X"+nombre+")";

    }
}
