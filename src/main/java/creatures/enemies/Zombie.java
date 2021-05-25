package creatures.enemies;

import creatures.Creature;
import creatures.Player;
import generationProcedurale.Tile;

import java.util.ArrayList;

public class Zombie extends Creature implements Enemi {
    public Tile tile ;

    private int counter = 1 ;

    public Zombie(Tile tile , int health, int attack, int defense, int experience, int positionX, int positionY) {

        super(tile,health,attack,defense,experience, positionX, positionY);
        this.tile = tile ;

    }


    @Override
    public char move(Player player, ArrayList<Creature> enemies, Tile[][] tiles) {
        int distanceX = this.positionX - player.getPositionX();
        int distanceY = this.positionY - player.getPositionY();
        int adx = Math.abs(distanceX);
        int ady = Math.abs(distanceY);
        int distance = adx + ady;


        //the distance of detecting the player is proportional of his level


        if (distance <= 10 + player.getLevel()) {// the player is in the zombie  zone

            switchVisibility();

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

        } else {//the player is outside the zombie zone. so generate a random move
            this.counter=1;
            String clavier = "AZQDW";
            return clavier.charAt(random.nextInt(clavier.length())); // return random caractere parmi a z q d w


        }


    }

    private void switchVisibility() {

        this.counter = random.nextInt(5) ;
        System.out.println("inside ozmbie tile  : "+ this.tile);
        if( (this.counter % 2 )== 0)
        {
            super.tile = Tile.ZOMBIE_INVISIBLE ;



        }
        else {
            super.tile = Tile.ZOMBIE;
        }





    }


}
