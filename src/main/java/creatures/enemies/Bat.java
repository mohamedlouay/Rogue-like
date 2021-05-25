package creatures.enemies;

import creatures.Creature;
import creatures.EnemyFactory;
import creatures.Player;
import generationProcedurale.Tile;

import java.util.ArrayList;

public class Bat extends Creature {
    public Tile tile;

    public Bat(Tile tile, int health, int attack, int defense, int experience, int positionX, int positionY) {

        super(tile, health, attack, defense, experience, positionX, positionY);
        this.tile = tile;
    }

    @Override
    public char move(Player player, ArrayList<Creature> enemies, Tile[][] tiles) {
        int distanceX = this.positionX - player.getPositionX();
        int distanceY = this.positionY - player.getPositionY();
        int adx = Math.abs(distanceX);
        int ady = Math.abs(distanceY);
        int distance = adx + ady;


        //the distance of detecting the player is proportional of his level


        if ((distance <= 10 + player.getLevel())&&( player.tile==Tile.PLAYER))  {// the player is in the enemy zone
            duplicate(player, enemies, tiles);

        }

        //the player is outside the enemy zone. so generate a random move
        String clavier = "AZQDW";
        return clavier.charAt(random.nextInt(clavier.length())); // return random caractere parmi a z q d w


    }

    private void duplicate(Player player, ArrayList<Creature> enemies, Tile[][] tiles) {
        int wx = this.positionX + random.nextInt(3);
        int wy = this.positionY + random.nextInt(3);

        int prob = random.nextInt(100);

        if ((tiles[wy][wx] == Tile.SOL) && (prob <= 30)) // probabilty that the bat is duplicated is under 30%
        {

            enemies.add(EnemyFactory.createNewEnemy(Tile.BAT, player.getLevel(), wx, wy));
        }


    }


}
