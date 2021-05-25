package creatures.enemies;

import creatures.Creature;
import creatures.Player;
import generationProcedurale.Center;
import generationProcedurale.Tile;

import java.util.ArrayList;
import java.util.Scanner;

public class Dragon extends Creature {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public Tile tile ;

    public ArrayList<Center> getFireLine() {
        return fireLine;
    }

    private ArrayList<Center> fireLine = new ArrayList<>();

    private int attackDistance ;

    public Dragon(Tile tile , int health, int attack,int attackDistance, int defense, int experience, int positionX, int positionY) {

        super(tile,health,attack,defense,experience, positionX, positionY);
        this.tile = tile ;
        this.attackDistance = attackDistance ;
    }
    public char move(Player player, ArrayList<Creature> enemies, Tile[][] tiles) {
        int distanceX = this.positionX - player.getPositionX();
        int distanceY = this.positionY - player.getPositionY();
        int adx = Math.abs(distanceX);
        int ady = Math.abs(distanceY);
        int distance = adx + ady;


        //the distance of detecting the player is proportional of his level

        fireLineClear(tiles);
        if((distance <= 10 + player.getLevel())&&( player.tile==Tile.PLAYER))  {// the player is in the enemy zone

            if( distance <= 5)
            {
                distanceAttack(player,tiles);
            }


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

    private void distanceAttack(Player player, Tile[][] tiles) {
        int min ;
        int max ;


        if (player.tile==Tile.PLAYER_WITH_ARMOR) // player under protection
            return  ;


        if (this.positionY == player.getPositionY()) // in the same axe Y
        {
            min = Math.min(this.positionX,player.getPositionX());
            max = Math.max(this.positionX,player.getPositionX());
            for (int i = min +1; i < max ; i++) {
                tiles[this.positionY][i] = Tile.FIRE;
                fireLine.add(new Center(i,this.positionY));


            }
            System.out.println( ANSI_RED + this.tile + "( Distance ATTACK :" + this.attackDistance + ")" + ANSI_RESET);
            pause();
            player.takeDamageDistance(this.attackDistance) ;

        }
        else if (this.positionX == player.getPositionX()) // in the same axe X
        {

            min = Math.min(this.positionY,player.getPositionY());
            max = Math.max(this.positionY,player.getPositionY());
            for (int i = min +1; i < max ; i++) {
                tiles[i][this.positionX] = Tile.FIRE;
                fireLine.add(new Center(this.positionX,i));

            }

            System.out.println( ANSI_RED + this.tile + "( Distance ATTACK :" + this.attackDistance + ")" + ANSI_RESET);
            pause();
            if (player.takeDamageDistance(this.attackDistance) != 0 ) {
                System.out.println("le player est mort!!!");
                tiles[player.getPositionY()][player.getPositionX()] = Tile.SOL;
                pause();
                System.exit(0);
            }
        }




    }

    private void fireLineClear(Tile[][] tiles) {

        for (Center p :fireLine) { //center is the point of the fire symbol that have x and y

            tiles[p.getCenterY()][p.getCenterX()] = Tile.SOL ;

        }

        fireLine.clear();

    }


    public   void pause() {
        System.out.println("Press Any Key To Continue...");
        new Scanner(System.in).nextLine();
    }


}

