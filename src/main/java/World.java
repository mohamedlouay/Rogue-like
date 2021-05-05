

import classes.armes.Lance;
import creatures.Enemy;
import creatures.Player;
import creatures.PlayerInventory;
import generationProcedurale.ConstructeurDuMonde;
import generationProcedurale.Room;
import generationProcedurale.Tile;
import items.Item;

import java.util.ArrayList;

public class World {
    private Tile[][] tiles;
    ArrayList<Room> rooms;
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    ArrayList<Item> items = new ArrayList<Item>();

    private int colonnes;
    private int lignes;

    ConstructeurDuMonde worldBuilder;
    PlayerInventory playerInventory;

    public World(Player player, int  lignes, int colonnes) {

        this.colonnes = colonnes;
        this.lignes = lignes;
        playerInventory = new PlayerInventory();
        worldBuilder = new ConstructeurDuMonde(player,lignes, colonnes);
        this.tiles = worldBuilder.getTiles();
        this.rooms = worldBuilder.getRooms();
        this.enemies= worldBuilder.getenemies();
        this.items=worldBuilder.getItems();

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


    // functions

    public void movePlayer ( char input , Player player) {
        int playerX = player.getPositionX();
        int playerY = player.getPositionY();



        switch (input)
        {
            case 'Z' : {tryMovePlayer(playerX,playerY-1,player);break;} //up
            case 'Q' : {tryMovePlayer(playerX-1,playerY,player);break;} //left
            case 'D' : {tryMovePlayer(playerX+1,playerY,player);break;} //right
            case 'W' : {tryMovePlayer(playerX,playerY+1,player);break;} //down
            case 'A':
                player.changerDArme(0);
                break;
            case 'X':
                battleAdistance( player);
                break;

            case 'I':
                PlayScreen.DisplayInvetory(playerInventory,player);
                break;

            default:
                System.out.println("invalid input ! ");
                try {
                    Thread.sleep(700);// to see the displayed statement : invalid input !  !!!!!
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }

        //decrease health by 1 in every mouvement so the player should always eat food
        player.addHealth(-1);
        if (player.getHealth()<1)
        {
            System.out.println("the player died by hunger !!");
            GameSystem.pause();
            System.exit(0);
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


            case ZOMBIE:
            case WOLF:
            case SNAKE:
            case DRAGON:{

                battleEnemey(player ,targetX,targetY ) ;// battle with the enemy
                break;
            }


            case MONEY:
            case FOOD: {
                updateInventory(player, targetX, targetY);
                break;
            }


            case WINDOW:
            {
                moveToNextLevel(player);
                break;}

            default: {

                break ;// battle with the enemy

            }

        }


    }



    //move enemies

    public void moveEnemies ( Player player)
    {
        char input ;
        for (Enemy enemy:enemies) {
            input = enemy.moveEnemy(player); // return a move

            int enemyX = enemy.getPositionX() ;
            int enemyY = enemy.getPositionY() ;

            switch (input)
            {
                case 'Z' : {tryMoveEnemy(enemyX,enemyY-1,enemy,player);break;} //up
                case 'Q' : {tryMoveEnemy(enemyX-1,enemyY,enemy,player);break;} //left
                case 'D' : {tryMoveEnemy(enemyX+1,enemyY,enemy,player);break;} //right
                case 'W' : {tryMoveEnemy(enemyX,enemyY+1,enemy,player);break;} //down

            }



        }


    }




    private void tryMoveEnemy (int targetX ,int targetY,Enemy enemy,Player player)  {
        Tile tile = getTile(targetX,targetY) ;
        int oldX = enemy.getPositionX();
        int oldY = enemy.getPositionY();
        switch (tile)
        {
            case MUR :{
                break;
            }
            case SOL: {

                enemy.setPosition(targetX,targetY);
                setTile(targetX,targetY,enemy.tile);
                setTile(oldX,oldY,Tile.SOL);
                break;
            }


            case PLAYER: {

                battleEnemey(player ,targetX,targetY ) ;// battle with the player
                break;
            }


            default:
                break;
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
                System.out.println("le joueur  va attaquer le "+ enemey.tile +" avec une force de  " + attackPower);

                damageResult = enemey.takeDamage(attackPower);
                if(damageResult != 0 ) // he died and we return his experience
                {
                    player.addExperience(damageResult);
                    GameSystem.pause();
                    setTile(targetX,targetY,Tile.SOL);
                    enemies.remove(enemey); //remove the died enemy from the list of enemies
                    break;

                }

                //the enemey is still alive
                //his turn to attack
                attackPower= enemey.attack();
                System.out.println("le "+ enemey.tile +" va attaquer le player avec une force de  " + attackPower);
                GameSystem.pause();

                damageResult = player.takeDamage(attackPower);
                if(damageResult != 0)
                {
                    //aaj
                    System.out.println("le player est mort!!!");
                    setTile(player.getPositionX(), player.getPositionY(), Tile.SOL);
                    GameSystem.pause();
                    System.exit(0);

                }






                break ;
            }

        }


    }



    void battleAdistance(Player player){
        for(Enemy e:enemies){
            if((distance(player.getPositionX(),player.getPositionY(),e.getPositionX(),e.getPositionY())<=player.getArme().getDistanceDAttack())&&(player.getArme().getNombre()>0)){
                if(player.getArme() instanceof Lance){
                    ((Lance) player.getArme()).sous_lance();
                }
                System.out.println("le player va attacker l'ennemie avec une force de  " + player.getAttack());
                e.takeDamage(player.getAttack());

                int damageResult = e.takeDamage(player.getAttack());
                if(damageResult != 0 ) // he died and we return his experience
                {
                    player.addExperience(damageResult);
                    GameSystem.pause();
                    setTile(e.getPositionX(),e.getPositionY(),Tile.SOL);
                    enemies.remove(e); //remove the died enemy from the list of enemies
                    return;

                }
            }
        }
    }
    int distance (int x1,int y1,int x2,int y2){
        return  (int) Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
    }


    public void update(Player player) {

        // check if all the enemies are died so create a windows to the next level
        if (enemies.size()==0 )
        {
            createWindow(player);
        }
    }




    void createWindow( Player player)
    {
        // find in wich room the player is ?
        int x = player.getPositionX();
        int y = player.getPositionY();

        for ( Room room : rooms)
        {
            if ((room.getX1() <=x )&& (room.getX2() >=x ) && (room.getY1() <= y) && (room.getY2()>= y))
            {
                // create a window in the center of this room
                createWindowCenter(room.getCenter().getCenterX(),room.getCenter().getCenterY());
                setTile(x,y,Tile.PLAYER);//repaint the @ in the case he was in the middle and
                                         // have been overrided by the windows symbol
                break;



            }

        }



    }

    private void createWindowCenter(int centerX, int centerY) {


        //create a window of 2 * 2 Tiles
        setTile(centerX,centerY,Tile.WINDOW);
        setTile(centerX,centerY+1,Tile.WINDOW);
        setTile(centerX+1,centerY,Tile.WINDOW);
        setTile(centerX+1,centerY+1,Tile.WINDOW);



    }

    private void moveToNextLevel(Player player) {


        // generate new world
        worldBuilder = new ConstructeurDuMonde(player,lignes, colonnes);
        this.tiles = worldBuilder.getTiles();
        this.rooms = worldBuilder.getRooms();
        this.enemies= worldBuilder.getenemies();
        this.items= worldBuilder.getItems();

        player.setLevel(player.getLevel()+1);


    }

    //add items to player's inventory
    private void updateInventory(Player player, int targetX, int targetY) {



        for ( Item item : items)
        {

            if (targetX == item.getX() && targetY == item.getY())
            {

                if (item.getTile()==Tile.MONEY)
                {
                    playerInventory.addMoney(item.getValue());
                }
                else if (item.getTile()==Tile.FOOD)
                {

                    player.addHealth(item.getValue());
                }
                System.out.println("vous avez collecté un item de type : "+item.getTile() + " de valeur de : " +item.getValue());
                GameSystem.pause();
                break;



            }



        }
        setTile(player.getPositionX(), player.getPositionY(), Tile.SOL);
        player.setPosition(targetX,targetY);
        setTile(targetX,targetY,Tile.PLAYER);


    }



}




