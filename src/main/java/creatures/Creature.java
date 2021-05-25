package creatures;

import generationProcedurale.Tile;
import items.Item;

import java.util.ArrayList;
import java.util.Random;


public class Creature {

    protected int health = 100;
    protected int attack = 60;
    protected int defense = 20;
    protected int experience = 90;
    protected int positionX;
    protected int positionY;
    public Tile tile ;
    public Random random = new Random();
    public ArrayList<Item> itemsStolen =new ArrayList<>();

    public Creature() {

    }

    public Creature(Tile tile ,int health, int attack, int defense, int experience, int positionX, int positionY) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
        this.positionX = positionX;
        this.positionY = positionY;
        this.tile = tile ;
    }


//Setters


    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }


    public void setPosition(int x, int y) {
        this.positionX = x;
        this.positionY = y;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }


    //Getters


    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getExperience() {
        return experience;
    }


    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }


    //methodes

    public int attack() {
        return this.attack;
    }

    public int takeDamage(int damage) {
        damage = damage - this.defense; // check if attack does damage


        if (damage > 0) {
            this.health = this.health - damage;
            if (this.health <= 0)// he died
            {
                return this.experience;

            }


        }
        return 0;

    }


    public char move(Player player, ArrayList<Creature> enemies, Tile[][] tiles) {
        int distanceX = this.positionX - player.getPositionX();
        int distanceY = this.positionY - player.getPositionY();
        int adx = Math.abs(distanceX);
        int ady = Math.abs(distanceY);
        int distance = adx + ady;


        //the distance of detecting the player is proportional of his level


        if (distance <= 10 + player.getLevel()) {// the player is in the enemy zone
            if (adx > ady) { //moving the enemy the X axis
                if (distanceX > 0) { // move left

                    return 'Q';
                } else {
                    return 'D';   // move right
                }
            } else {//moving the enemy the Y axis
                if (distanceY > 0) { // move down
                    return 'Z';
                } else {
                    return 'W';   // move up
                }

            }

        } else {//the player is outside the enemy zone. so generate a random move
            String clavier = "AZQDW";
            return clavier.charAt(random.nextInt(clavier.length())); // return random caractere parmi a z q d w


        }


    }


    public void collect (int targetX, int targetY, ArrayList<Item> items, Tile[][]tiles)
    {

    }

}
