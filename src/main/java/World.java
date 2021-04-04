

import creatures.Enemy;
import creatures.Player;
import generationProcedurale.ConstructeurDuMonde;
import generationProcedurale.Room;
import generationProcedurale.Tile;

import java.util.ArrayList;

public class World {
    private Tile[][] tiles;
    ArrayList<Room> rooms;
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    private int colonnes;
    private int lignes;
    private int maxRooms = 30;
    private int maxRoomSize = 15;
    private int minRoomSize = 10;
    ConstructeurDuMonde worldBuilder;

    public World(Player player, int  lignes, int colonnes) {

        this.colonnes = colonnes;
        this.lignes = lignes;
        worldBuilder = new ConstructeurDuMonde(player,lignes, colonnes, this.maxRooms ,this.minRoomSize, this.maxRoomSize);
        this.tiles = worldBuilder.getTiles();
        this.rooms = worldBuilder.getRooms();
        this.enemies= worldBuilder.getenemies();

    }

    public World(Player player ,int lignes, int colonnes, int minRoomSize, int maxRoomSize, int maxRooms) {

        this.colonnes = colonnes;
        this.lignes = lignes;
        worldBuilder = new ConstructeurDuMonde(player,lignes, colonnes, minRoomSize, maxRoomSize, maxRooms);

        this.tiles = worldBuilder.getTiles();
    }

    //setters

    public void setTile (int x , int y , Tile t )
    {
        tiles[y][x] = t;
    }


    //getters
    public Tile getTile (int x , int y )
    {
        Tile tile = tiles[y][x];
        return tile;
    }

    public int getColonnes() {
        return colonnes;
    }

    public int getLignes() {
        return lignes;
    }

    public void display2() {
        for (int i = 0; i < this.lignes; i++) {
            for (int j = 0; j < this.colonnes; j++) {
                System.out.print(this.tiles[i][j].getSymbole());
            }
            System.out.println();

        }
    }



    public void movePlayer ( char input , Player player) {
        int playerX = player.getPositionX();
        int playerY = player.getPositionY();



        switch (input)
        {
            case 'Z' : {tryMovePlayer(playerX,playerY-1,player);break;} //up
            case 'Q' : {tryMovePlayer(playerX-1,playerY,player);break;} //left
            case 'D' : {tryMovePlayer(playerX+1,playerY,player);break;} //right
            case 'W' : {tryMovePlayer(playerX,playerY+1,player);break;} //down
            default:
                System.out.println("invalid input ! ");
                try {
                    Thread.sleep(700);// to see the displayed statement : invalid input !  !!!!!
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }
    }

    private void tryMovePlayer (int targetX ,int targetY,Player player)  {
        Tile tile = getTile(targetX,targetY) ;
        int oldX = player.getPositionX();
        int oldY = player.getPositionY();
        switch (tile)
        {
            case MUR :{
                System.out.println("Mur !!!!!!!!!!!!");
                GameSystem.pause();
                break;
            }
            case SOL: {

                player.setPosition(targetX,targetY);
                setTile(targetX,targetY,Tile.PLAYER);
                setTile(oldX,oldY,Tile.SOL);
                break;
            }


            case ZOMBIE: {

                battleEnemey(player ,targetX,targetY ) ;// battle with the enemy
                break;
            }
            default: {

                battleEnemey(player ,targetX,targetY ) ;// battle with the enemy

            }

        }


    }



    public void battleEnemey(Player player , int targetX , int  targetY)
    {
        int attackPower ;
        int damageResult;
        for (Enemy enemey:enemies) {
            //find the enemy in the x and y position and battle with him
            if (targetX == enemey.getPositionX() && targetY == enemey.getPositionY())
            {

                //player turn

                attackPower = player.attack();
                System.out.println("le player va attacker l'ennemie avec une force de  " + attackPower);

                damageResult = enemey.takeDamage(attackPower);
                if(damageResult != 0 ) // he die and we return his experience
                {
                    player.addExperience(damageResult);
                    GameSystem.pause();
                    setTile(targetX,targetY,Tile.SOL);
                    return;

                }

                //the enemey is still alive
                //his turn to attack
                attackPower= enemey.attack();
                System.out.println("le ennemie va attacker le player avec une force de  " + attackPower);
                GameSystem.pause();

                damageResult = player.takeDamage(attackPower);
                if(damageResult != 0)
                {
                    System.out.println("le player est mort!!!");
                    setTile(player.getPositionX(), player.getPositionY(), Tile.SOL);
                    GameSystem.pause();
                    System.exit(0);

                }




                return ;
            }

        }


    }






}




