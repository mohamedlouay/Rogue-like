package gameSystem;

import classes.armes.Lance;
import creatures.Creature;
import creatures.Player;
import creatures.PlayerInventory;
import generationProcedurale.ConstructeurDuMonde;
import generationProcedurale.Room;
import generationProcedurale.Tile;
import items.Item;

import java.util.ArrayList;

public class World {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    private Tile[][] tiles;
    ArrayList<Room> rooms;
    ArrayList<Creature> enemies = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<Item>();
    Player player;
    private int colonnes;
    private int lignes;

    ConstructeurDuMonde worldBuilder;
    PlayerInventory playerInventory;

    public World(Player player, int lignes, int colonnes) {
        this.player = player;
        this.colonnes = colonnes;
        this.lignes = lignes;
        playerInventory = new PlayerInventory();
        worldBuilder = new ConstructeurDuMonde(player, lignes, colonnes);
        this.tiles = worldBuilder.getTiles();
        this.rooms = worldBuilder.getRooms();
        this.enemies = worldBuilder.getenemies();
        this.items = worldBuilder.getItems();

    }


    //setters

    public void setTile(int x, int y, Tile t) {
        tiles[y][x] = t;
    }


    //getters
    public Tile getTile(int x, int y) {
        Tile tile = tiles[y][x];
        return tile;
    }

    public int getColonnes() {
        return colonnes;
    }

    public int getLignes() {
        return lignes;
    }
    public ArrayList<Creature> getEnnemies() {
        return enemies;
    }
  public Tile[][] getTiles() {
        return tiles;
    }


    // functions

    public void movePlayer(char input, Player player) {

        player.setHealth(player.getHealth() - 1);
        player.addProtection(player.getProtection() + -1);

        int playerX = player.getPositionX();
        int playerY = player.getPositionY();


        switch (input) {
            case 'Z': {
                tryMovePlayer(playerX, playerY - 1, player);
                break;
            } //up
            case 'Q': {
                tryMovePlayer(playerX - 1, playerY, player);
                break;
            } //left
            case 'D': {
                tryMovePlayer(playerX + 1, playerY, player);
                break;
            } //right
            case 'W': {
                tryMovePlayer(playerX, playerY + 1, player);
                break;
            } //down
            case 'A':
                player.changerDArme(0);
                break;
            case 'X':
                battleAdistance(player);
                break;

            case 'I':
                PlayScreen.DisplayInvetory(playerInventory, player);
                break;
            case 'C':
                player.switchDisplaymode();
                break;

            default:
                System.out.println("invalid input ! ");
                try {
                    Thread.sleep(700);// to see the displayed statement : invalid input !  !!!!!
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }
    }


    private void tryMovePlayer(int targetX, int targetY, Player player) {
        Tile tile = getTile(targetX, targetY);
        int oldX = player.getPositionX();
        int oldY = player.getPositionY();
        switch (tile) {
            case MUR: {
                System.out.println("Mur !!!!!!!!!!!!");
                GameSystem.pause();
                break;
            }
            case SOL: {

                player.setPosition(targetX, targetY);
                setTile(targetX, targetY, player.tile);
                setTile(oldX, oldY, Tile.SOL);
                break;
            }
            case PORTE: {

                //level up :
                if (player.aLACle()) moveToNextLevel(player);

                break;
            }
            case cle: {

                //level up :
                player.setCle();
                player.setPosition(targetX, targetY);
                setTile(targetX, targetY, player.tile);
                setTile(oldX, oldY, Tile.SOL);

                break;
            }


            case ZOMBIE:
            case ZOMBIE_INVISIBLE :
            case GOBLIN:
            case BAT:
            case DRAGON: {

                battleEnemey(player, targetX, targetY);// battle with the enemy
                break;
            }


            case MONEY:
            case INVISIBILITY_CLOAK:
            case FOOD: {
                updateInventory(player, targetX, targetY);
                break;
            }


            default: {

                break;

            }

        }


    }


    //move enemies

    public void moveEnemies(Player player) {
        ArrayList<Creature> enemiesCopy = new ArrayList<>(enemies) ;
        char input;
        for (Creature enemy : enemiesCopy) {
            input = enemy.move(player,this.enemies,this.tiles); // return a move

            int enemyX = enemy.getPositionX();
            int enemyY = enemy.getPositionY();

            switch (input) {
                case 'Z': {
                    tryMoveEnemy(enemyX, enemyY - 1, enemy, player);
                    break;
                } //up
                case 'Q': {
                    tryMoveEnemy(enemyX - 1, enemyY, enemy, player);
                    break;
                } //left
                case 'D': {
                    tryMoveEnemy(enemyX + 1, enemyY, enemy, player);
                    break;
                } //right
                case 'W': {
                    tryMoveEnemy(enemyX, enemyY + 1, enemy, player);
                    break;
                } //down

            }


        }

        ArrayList<Creature> enemies = new ArrayList<>(enemiesCopy) ;


    }


    private void tryMoveEnemy(int targetX, int targetY, Creature enemy, Player player) {
        Tile tile = getTile(targetX, targetY);
        int oldX = enemy.getPositionX();
        int oldY = enemy.getPositionY();
        switch (tile) {
            case MUR: {
                break;
            }
            case SOL: {

                enemy.setPosition(targetX, targetY);
                setTile(targetX, targetY, enemy.tile);
                setTile(oldX, oldY, Tile.SOL);
                break;
            }


            case PLAYER: {

                battleEnemey(player, targetX, targetY);// battle with the player
                break;
            }

            case  FOOD:
            {
                enemy.collect(targetX,targetY,this.items,this.tiles);
            }
            default: {

                break;

            }

        }


    }


    public void battleEnemey(Player player, int targetX, int targetY) {

        if (player.tile == Tile.PLAYER_WITH_ARMOR)
            return ;


        ArrayList<Creature> enemiesCopy = new ArrayList<>(enemies);

        int attackPower;
        int damageResult;
        for (Creature enemey : enemiesCopy) {
            //find the enemy in the x and y position and battle with him
            if (targetX == enemey.getPositionX() && targetY == enemey.getPositionY()) {

                //player turn

                attackPower = player.attack();
                System.out.println(ANSI_BLUE + "PLAYER (ATT:" + player.getAttack() + " ,DEF:" + player.getDefense() + ") " +
                        "==> " + ANSI_RED + enemey.tile + "(ATT:" + enemey.getAttack() + ",DEF:" + enemey.getDefense() + ")" + ANSI_RESET);

                damageResult = enemey.takeDamage(attackPower);

                if (damageResult != 0) // he died and we return his experience
                {


                    if (enemey.tile==Tile.GOBLIN)
                    {
                        items.addAll(enemey.itemsStolen);
                        for (Item i : enemey.itemsStolen)
                        {
                            System.out.println("vous avez recuperé un "+i.toString());
                        }
                    }
                    player.addExperience(damageResult);
                    GameSystem.pause();
                    setTile(targetX, targetY, Tile.SOL);
                    enemies.remove(enemey); //remove the died enemy from the list of enemies
                    break;

                }

                //the enemey is still alive
                //his turn to attack
                attackPower = enemey.attack();
                System.out.println(ANSI_BLUE + "PLAYER (ATT:" + player.getAttack() + " ,DEF:" + player.getDefense() + ") " +
                        "<== " + ANSI_RED + enemey.tile + "(ATT:" + enemey.getAttack() + ",DEF:" + enemey.getDefense() + ")" + ANSI_RESET);
                GameSystem.pause();

                damageResult = player.takeDamage(attackPower);
                if (damageResult != 0) {
                    System.out.println("le player est mort!!!");
                    setTile(player.getPositionX(), player.getPositionY(), Tile.SOL);
                    GameSystem.pause();
                    System.exit(0);

                }


                break;
            }

        }

        ArrayList<Creature> enemies = new ArrayList<>(enemiesCopy);


    }


    void battleAdistance(Player player) {
        for (Creature e : enemies) {
            if ((distance(player.getPositionX(), player.getPositionY(), e.getPositionX(), e.getPositionY()) <= player.getArme().getDistanceDAttack()) && (player.getArme().getNombre() > 0)) {
                if (player.getArme() instanceof Lance) {
                    ((Lance) player.getArme()).sous_lance();
                }
                System.out.println("le player va attacker l'ennemie avec une force de  " + player.getAttack());
                e.takeDamage(player.getAttack());

                int damageResult = e.takeDamage(player.getAttack());
                if (damageResult != 0) // he died and we return his experience
                {
                    player.addExperience(damageResult);
                    GameSystem.pause();
                    setTile(e.getPositionX(), e.getPositionY(), Tile.SOL);
                    enemies.remove(e); //remove the died enemy from the list of enemies
                    return;

                }
            }
        }
    }

    public int distance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }


    public void update(Player player) {


        if (player.getHealth() == 0) {
            System.out.println("player died of hungry ");
            GameSystem.pause();
            System.exit(0);
        }


        if (player.getProtection() >0)
        {

            player.setTile(Tile.PLAYER_WITH_ARMOR);

        }
        else
        {
            player.setTile(Tile.PLAYER);
        }
    }


    void createWindow(Player player) {
        // find in wich room the player is ?
        int x = player.getPositionX();
        int y = player.getPositionY();

        for (Room room : rooms) {
            if ((room.getX1() <= x) && (room.getX2() >= x) && (room.getY1() <= y) && (room.getY2() >= y)) {
                // create a window in the center of this room
                createWindowCenter(room.getCenter().getCenterX(), room.getCenter().getCenterY());
                setTile(x, y, player.tile);//repaint the @ in the case he was in the middle and
                // have been overrided by the windows symbol
                break;


            }

        }


    }

    private void createWindowCenter(int centerX, int centerY) {


        //create a window of 2 * 2 Tiles
        setTile(centerX, centerY, Tile.WINDOW);
        setTile(centerX, centerY + 1, Tile.WINDOW);
        setTile(centerX + 1, centerY, Tile.WINDOW);
        setTile(centerX + 1, centerY + 1, Tile.WINDOW);


    }

    private void moveToNextLevel(Player player) {


        // generate new world
        worldBuilder = new ConstructeurDuMonde(player, lignes, colonnes);
        this.tiles = worldBuilder.getTiles();
        this.rooms = worldBuilder.getRooms();
        this.enemies = worldBuilder.getenemies();
        this.items = worldBuilder.getItems();

        player.setLevel(player.getLevel() + 1);


    }

    //add items to player's inventory
    private void updateInventory(Player player, int targetX, int targetY) {


        for (Item item : items) {

            if (targetX == item.getX() && targetY == item.getY()) {

                if (item.getTile() == Tile.MONEY) {
                    playerInventory.addMoney(item.getValue());
                } else if (item.getTile() == Tile.FOOD) {

                    player.addHealth(item.getValue());
                }else if (item.getTile() == Tile.INVISIBILITY_CLOAK) {

                    player.addProtection(item.getValue());
                }
                System.out.println("vous avez collecté un item de type : " + item.getTile() + " de valeur de : " + item.getValue());
                GameSystem.pause();
                break;


            }


        }
        setTile(player.getPositionX(), player.getPositionY(), Tile.SOL);
        player.setPosition(targetX, targetY);
        setTile(targetX, targetY, player.tile);


    }


}




