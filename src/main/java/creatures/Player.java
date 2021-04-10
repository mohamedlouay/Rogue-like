package creatures;

import classes.armes.Arme;
import classes.armes.Epee;
import classes.armes.Lance;
import classes.armes.dague;

import java.util.ArrayList;

public class Player extends Creature {
    private int level = 1;

    ArrayList<Arme> armes = new ArrayList<>();
    private int arme_courante = 0;


    public Player() {
        this.health = 100 ;
        this.experience=0;
        this.defense = 50;
        //tester les armes :
        armes.add(new dague());
        armes.add(new Epee());
        armes.add(new Lance());
    }

    public void changerDArme(int i){
        if (this.arme_courante==(this.armes.size()-1)){
            this.arme_courante=0;
        }
        else this.arme_courante++;
    }



    public void ajouterUneArme(Arme arm){
        this.armes.add(arm);
    }
    public String getArmeNom(){
        return this.armes.get(arme_courante).getNom();
    }


    //Setters


    public void setLevel(int level) {
        this.level = level;
    }



    //Getters


    public int getLevel() {
        return level;
    }


    // methodes

    public  void addExperience (int ex)
    {
        this.experience += ex ;
        while (this.experience > 100)
        {
            this.experience -= 100 ;
            this.attack += 50 ;
            this.defense += 20 ;
            this.health += 50 ;
            this.level ++ ;
            System.out.println("enemy mort !!!");
            System.out.println("Bravo , vous avez atteint le niveau "+  this.level);
            System.out.println(" votre nouveau attaque est  "+  this.attack);
            System.out.println(" votre nouveau defense est  "+  this.defense);
            System.out.println(" votre nouveau health est  "+  this.health);

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
