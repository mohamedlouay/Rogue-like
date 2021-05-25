package creatures.enemies;

import creatures.Creature;
import creatures.Player;
import generationProcedurale.Tile;
import items.Item;

import java.util.ArrayList;

public class Goblin extends Creature {
    public Tile tile ;



    public Goblin(Tile tile , int health, int attack, int defense, int experience, int positionX, int positionY) {

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


        if ((distance <= 10 + player.getLevel())&&( player.tile==Tile.PLAYER))  {// the player is in the Globin zone
            if (adx > ady) { //moving the Goblin the X axis
                if (distanceX > 0) { // move right : to run away

                    return 'D';
                } else {
                    return 'Q';   // move left : to run away
                }
            } else {//moving the enemy the Y axis
                if (distanceY > 0) { // move up : to run away
                    return 'W';
                } else {
                    return 'Z';   // move down : to run away
                }

            }

        } else {//the player is outside the enemy zone. so generate a random move
            String clavier = "AZQDW";
            return clavier.charAt(random.nextInt(clavier.length())); // return random caractere parmi a z q d w


        }


    }

    @Override
    public void collect (int targetX, int targetY, ArrayList<Item> items, Tile[][]tiles)
    {
        Item currentItem =null; ;
        for(Item i : items)
        {
            if ((i.getX()==targetX)&&(i.getY()==targetY))
            {
                System.out.println("un goblin  a volé un :"+i.toString());
                this.itemsStolen.add(i);
                currentItem =  i;

                tiles[targetY][targetX] = Tile.SOL;

                break;

            }
        }
        if (currentItem != null ) {
            items.remove(currentItem);
        }






    }

}
