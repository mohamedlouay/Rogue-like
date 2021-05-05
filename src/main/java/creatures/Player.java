package creatures;

import classes.armes.Arme;
import classes.armes.Epee;
import classes.armes.Lance;
import classes.armes.dague;

import java.util.ArrayList;

public class Player extends Creature {
    private boolean displayALL=false;
    private int level = 1;
    private int argent=0;

    ArrayList<Arme> armes = new ArrayList<>();
    private int arme_courante = 0;


    public Player() {
        this.argent=10;
        this.health = 300 ;
        this.experience=0;
        this.defense = 70;
        this.attack=100;
        this.attack=this.armes.size()==0?this.attack:this.armes.get(arme_courante).getPuissance();
        //tester les armes :
        armes.add(new dague());
        armes.add(new Epee());
        armes.add(new Lance());
    }
    public void switchDisplaymode(){
        this.displayALL=!this.displayALL;
    }
    public boolean getDisplayAll(){
        return this.displayALL;
    }
    public Arme getArme(){
        return this.armes.get(this.arme_courante);
    }
    public ArrayList<Arme> getArmes(){
        return this.armes;
    }

    public void changerDArme(int i){
        if (this.arme_courante==(this.armes.size()-1)){
            this.arme_courante=0;
            if(this.armes.get(arme_courante).getNombre()!=0) {
                this.attack = this.armes.get(arme_courante).getPuissance();
            }
            else{
                this.attack=0;
            }
        }
        else {
            this.arme_courante++;
            this.attack=this.armes.get(arme_courante).getPuissance();

        }
        }


    public void ajouterUneArme(Arme arm){
        this.armes.add(arm);
    }
    public String getArmeNom(){
        return this.armes.get(arme_courante).getNom();
    }


    //Setters
//

    public void setLevel(int level) {
        this.level = level;
    }
    public void  sous_argent(int a){
        this.argent-=a;
    }

    public void addHealth (int health) {
        this.health += health;
    }



    //Getters


    public int getLevel() {
        return level;
    }


    // methodes

    public  void addExperience (int ex)//add experience to player when he kill an enemy
    {
        this.experience += ex ;
        while (this.experience > 100)//increase his force whenever he get 100 experience
        {
            this.experience -= 100 ;
            this.argent+=50;
            this.attack+=20;
            this.defense+=10;
            System.out.println("ennemi mort !!!");
            System.out.println(" + 50 $  ");

        }

    }

    public int takeDamage(int damage)
    {
        damage = damage - this.defense ; // check if attack does damage

        if (damage > 0) {
            this.health = this.health - damage;
            if (this.health <= 0 )// player died
            {
                return 1 ;

            }


        }
        return 0 ;

    }




}
