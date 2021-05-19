package creatures.enemies;

import creatures.Creature;
import creatures.EnemyFactory;
import creatures.Player;
import generationProcedurale.Tile;

import java.util.ArrayList;

public class Bat extends Creature implements Enemi {
    public Tile tile ;

    public Bat(Tile tile ,int health, int attack, int defense, int experience, int positionX, int positionY) {

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


        if (distance <= 10 + player.getLevel()) {// the player is in the enemy zone
            duplicate(player,enemies,tiles) ;
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


        }



        else {//the player is outside the enemy zone. so generate a random move
            String clavier = "AZQDW";
            return clavier.charAt(random.nextInt(clavier.length())); // return random caractere parmi a z q d w


        }


    }

    private void duplicate(Player player,ArrayList<Creature> enemies,Tile[][] tiles ) {
        int wx = this.positionX + random.nextInt(2);
        int wy = this.positionY + random.nextInt(2);

        int prob = random.nextInt(100);

        if ((tiles[wy][wx] == Tile.SOL) &&(prob <= 10 )) // probabilty that the bat is dupicate is under 10%
        {

            enemies.add(EnemyFactory.createNewEnemy(Tile.BAT, player.getLevel(), wx, wy));
        }


    }


}
