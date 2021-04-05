package creatures;

public class Enemy extends Creature {
    public Enemy(int PositionX, int PositionY) {

        setPosition(PositionX, PositionY);
    }


    public char moveEnemy(int playerX, int playerY) {
        int distanceX = this.positionX - playerX;
        int distanceY = this.positionY - playerY;
        int adx = Math.abs(distanceX);
        int ady = Math.abs(distanceY);
        int distance = adx + ady;

        if (distance <= 10) {// the player is in the enemy zone
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
