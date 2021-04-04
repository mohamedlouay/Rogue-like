package creatures;

import java.util.Random;


public class Creature {

    protected int health = 100;
    protected int attack = 100;
    protected int defense = 20;
    protected int experience = 90;
    protected int positionX;
    protected int positionY;
    Random random = new Random();

    public Creature() {

    }


    //Setters



    public void setHealth(int health) {        this.health = health;    }

    public void setAttack(int attack) {        this.attack = attack;    }

    public void setDefense(int defense) {        this.defense = defense;    }
    public void setExperience(int experience) {        this.experience = experience;    }


    public void setPosition(int x ,int y)
    {
        this.positionX = x;
        this.positionY = y;
    }

    public void setPositionX(int positionX) {  this.positionX = positionX;         }

    public void setPositionY(int positionY) {        this.positionY = positionY;     }


    //Getters




    public int getHealth() {        return health;    }

    public int getAttack() {        return attack;    }

    public int getDefense() {        return defense;    }
    public int getExperience() {        return experience;    }



    public int getPositionX() {        return positionX;    }

    public int getPositionY() {        return positionY;    }


    //methodes

    public int attack()
    {
        return random.nextInt(this.attack);
    }

    public int takeDamage(int damage)
    {
        damage = damage - this.defense ; // check if attack does damage



        if (damage > 0) {
            this.health = this.health - damage;
            if (this.health <= 0 )// he died
            {
                return this.experience ;

            }


            }
        return 0 ;

    }




















}
