package creatures;

import generationProcedurale.Tile;

public class Enemy extends Creature {

    public Tile tile ;


    public Enemy(Tile tile ,int health, int attack, int defense, int experience, int positionX, int positionY) {

      super(health,attack,defense,experience, positionX, positionY);
      this.tile = tile ;
    }






    public char moveEnemy(Player player) {
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


}
