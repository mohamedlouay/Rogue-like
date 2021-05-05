import classes.armes.Lance;
import creatures.Player;
import creatures.PlayerInventory;

import java.util.Scanner;

public class PlayScreen {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private int screenWidth = 100;
    private int screenHeight = 30;
    Scanner sc;



    public PlayScreen(int screenWidth, int screenHeight) {
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        sc = new Scanner(System.in);
    }




    public void display(Player player, World world) {

        displayInfo(player);

        int startY = Math.max(player.getPositionY() - screenHeight / 2, 0);
        int startX = Math.max(player.getPositionX() - screenWidth / 2, 0);

        int endY = Math.min(player.getPositionY() + screenHeight / 2, world.getLignes());
        int endX = Math.min(player.getPositionX() + screenWidth / 2, world.getColonnes());


        for (int i = startY; i < endY; i++) {
            for (int j = startX; j < endX; j++) {

                if ((i == startY) || (j == startX) || (i == endY - 1) || (j == endX - 1))//créer le cadre
                {
                    System.out.print(ANSI_PURPLE+'#'+ANSI_RESET);
                } else {
                    char symbol = world.getTile(j, i).getSymbole();
                    switch (symbol) {
                        case '@':
                            System.out.print(ANSI_BLUE+symbol+ANSI_RESET);
                            break;
                        case '*':
                            System.out.print(ANSI_BLACK+ANSI_PURPLE_BACKGROUND+symbol+ANSI_RESET);
                            break;
                        case '$':
                            System.out.print(ANSI_BLACK+ANSI_YELLOW_BACKGROUND+symbol+ANSI_RESET);
                            break;
                        case 'D':
                            System.out.print(ANSI_RED+symbol+ANSI_RESET);
                            break;
                        case 'S':
                            System.out.print(ANSI_RED+symbol+ANSI_RESET);
                            break;
                        case 'W':
                            System.out.print(ANSI_RED+symbol+ANSI_RESET);
                            break;
                        case 'Z':
                            System.out.print(ANSI_RED+symbol+ANSI_RESET);
                            break;
                        case 'X':
                            System.out.print(ANSI_GREEN+'O'+ANSI_RESET);
                            break;
                        case '!':
                            System.out.print(ANSI_YELLOW+symbol+ANSI_RESET);
                            break;
                        case 'C':
                            System.out.print(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+symbol+ANSI_RESET);
                            break;
                        case 'L':
                            System.out.print(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+symbol+ANSI_RESET);
                            break;
                        case 'E':
                            System.out.print(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+symbol+ANSI_RESET);
                            break;
                        default:
                            System.out.print(symbol);

                    }
                }


            }

            System.out.println();

        }


    }

    private void displayInfo(Player player) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(ANSI_PURPLE+"----------------------------------------------------------------------------------------------------");
        System.out.println("                                                     INFOS PLAYER                                  ");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println(ANSI_BLUE+" |LEVEL : " + player.getLevel() +ANSI_RESET+
                ANSI_GREEN+" |HEALTH : " + player.getHealth() +ANSI_RESET+
                ANSI_RED+" |ATTACK : " + player.getAttack() +ANSI_RESET+
                ANSI_BLUE+" |DEFENSE : " + player.getDefense() +ANSI_RESET+
                ANSI_BLUE+" |DEFENSE : " + player.getDefense() +ANSI_RESET+
                ANSI_PURPLE+" |EXPERIENCE : " + player.getExperience() +ANSI_RESET+
                ANSI_CYAN+" |ARME : " + player.getArmeNom() +ANSI_RESET);


    }



    //screen to display inventory
    public static void DisplayInvetory(PlayerInventory playerInventory, Player player) {

        espaces(50);
        System.out.println("Votre Solde est : "+playerInventory.getMoney() );

        System.out.println("1 : acheter des armes ");
        System.out.println("2 : acheter de nourriture ");
        int choix = new Scanner(System.in).nextInt();
        System.out.println();

        switch (choix)
        { case 1 :
            buyarmes(playerInventory, player);
            break;
            case 2 :
                buyFood(playerInventory, player);
                break;
            default:
                System.out.println("invalid choice !!!");
                GameSystem.pause();


        }




    }

    private static void buyFood(PlayerInventory playerInventory , Player player) {

        espaces(50);

        System.out.println("choisissez une option : ");
        System.out.println("1 : 50 foods for 50$");
        System.out.println("2 : 100 foods for 100$");
        System.out.println("3 : 150 foods for 150$");
        System.out.println("4 : 200 foods for 200$");
        int choix = new Scanner(System.in).nextInt();
        System.out.println();

        switch (choix)
        {
            case 1 :
                soldeVerification(playerInventory,player,50);
                break;
            case 2 :
                soldeVerification(playerInventory,player,100);
                break;
            case 3 :
                soldeVerification(playerInventory,player,150);
                break;
           case 4 :
                soldeVerification(playerInventory,player,200);
                break;
            default:
                System.out.println("invalid input!!");
                GameSystem.pause();
                break;


        }





    }


    private static void buyarmes(PlayerInventory playerInventory , Player player) {

        espaces(50);

        System.out.println("choisissez une option : ");
        System.out.println("1-(X1) Lance LVL1  10$                            4-(X3) Lance LVL1   25$   ");
        System.out.println("2-Dague LVL2       50$                            5-Dague LVL3        100$  ");
        System.out.println("3-EPEE LVL2       100$                            6-EPEE LVL3         200$  ");
        int choix = new Scanner(System.in).nextInt();
        System.out.println();

        switch (choix)
        {
            case 1 :
                if (playerInventory.getMoney()>=10){
                    if (player.getArmes().get(2) instanceof Lance){
                        ((Lance) player.getArmes().get(2)).add_lance(1);
                        playerInventory.addMoney(-10);
                    }
                }else {
                    System.out.println("solde insuffisant !");
                }
                break;

            case 2 :
                if (playerInventory.getMoney()>=50){
                    player.getArmes().get(0).setLevel(2);
                    playerInventory.addMoney(-50);
                    System.out.println("Dague Level 2");


                }else {
                    System.out.println("solde insuffisant !");
                }                break;
            case 3 :
                if (playerInventory.getMoney()>=100){
                    player.getArmes().get(1).setLevel(2);
                    playerInventory.addMoney(-100);

                }else {
                    System.out.println("solde insuffisant !");
                }                break;
            case 4 :
                if (playerInventory.getMoney()>=25){
                    if (player.getArmes().get(2) instanceof Lance){
                        ((Lance) player.getArmes().get(2)).add_lance(3);
                        playerInventory.addMoney(-25);
                    }
                }else {
                    System.out.println("solde insuffisant !");
                }
                break;
            case 5 :
                if (playerInventory.getMoney()>=100){
                    player.getArmes().get(0).setLevel(3);
                    playerInventory.addMoney(-100);

                }else {
                    System.out.println("solde insuffisant !");
                }                break;
                case 6 :
                    if (playerInventory.getMoney()>=200){
                        player.getArmes().get(1).setLevel(3);
                        playerInventory.addMoney(-200);
                        System.out.println("EPEE Level 3");


                    }else {
                        System.out.println("solde insuffisant !");
                    }                break;
            default:
                System.out.println("invalid input!!");
                GameSystem.pause();
                break;


        }





    }

    private static void soldeVerification(PlayerInventory playerInventory, Player player, int montant) {
        if (playerInventory.getMoney()>= montant  )
        {
            playerInventory.addMoney(-montant);
            player.addHealth(montant);

            System.out.println("super , votre nouveau niveau health : " + player.getHealth() + " et votre nouveau solde est "+playerInventory.getMoney());
        }
        else
        {
            System.out.println("montant insuffisant !!! ");
        }

        GameSystem.pause();



    }


    public void displayAll(Player player, World world) //function to display all world
    {
        displayInfo(player);

        for (int i = 0; i < world.getLignes(); i++) {
            for (int j = 0; j < world.getColonnes(); j++) {
                if ((i == 0) || (j == 0) || (i == world.getLignes() - 1) || (j == world.getColonnes() - 1))//créer le cadre
                {
                    System.out.print(ANSI_PURPLE+'#'+ANSI_RESET);
                } else {
                    char symbol = world.getTile(j, i).getSymbole();
                    switch (symbol) {
                        case '@':
                            System.out.print(ANSI_BLUE+symbol+ANSI_RESET);
                            break;
                        case '*':
                            System.out.print(ANSI_BLACK+ANSI_PURPLE_BACKGROUND+symbol+ANSI_RESET);
                            break;
                        case '$':
                            System.out.print(ANSI_BLACK+ANSI_YELLOW_BACKGROUND+symbol+ANSI_RESET);
                            break;
                        case 'D':
                            System.out.print(ANSI_RED+symbol+ANSI_RESET);
                            break;
                        case 'S':
                            System.out.print(ANSI_RED+symbol+ANSI_RESET);
                            break;
                        case 'W':
                            System.out.print(ANSI_RED+symbol+ANSI_RESET);
                            break;
                        case 'Z':
                            System.out.print(ANSI_RED+symbol+ANSI_RESET);
                            break;
                        case 'X':
                            System.out.print(ANSI_GREEN+'O'+ANSI_RESET);
                            break;
                        case '!':
                            System.out.print(ANSI_YELLOW+symbol+ANSI_RESET);
                            break;
                        case 'C':
                            System.out.print(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+symbol+ANSI_RESET);
                            break;
                        case 'L':
                            System.out.print(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+symbol+ANSI_RESET);
                            break;
                        case 'E':
                            System.out.print(ANSI_YELLOW_BACKGROUND+ANSI_BLACK+symbol+ANSI_RESET);
                            break;
                        default:
                            System.out.print(symbol);

                    }
                }
            }
            System.out.println();

        }

    }

    void startScreen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println(ANSI_CYAN+"                                                                                                      \n" +
                " ********************************************************************************************************************************************************************************************\n" +
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "                        ██████╗  ██████╗  ██████╗ ██╗   ██╗███████╗    ██╗     ██╗██╗  ██╗███████╗    \n" +
                "                        ██╔══██╗██╔═══██╗██╔════╝ ██║   ██║██╔════╝    ██║     ██║██║ ██╔╝██╔════╝    \n" +
                "                        ██████╔╝██║   ██║██║  ███╗██║   ██║█████╗      ██║     ██║█████╔╝ █████╗      \n" +
                "                        ██╔══██╗██║   ██║██║   ██║██║   ██║██╔══╝      ██║     ██║██╔═██╗ ██╔══╝      \n" +
                "                        ██║  ██║╚██████╔╝╚██████╔╝╚██████╔╝███████╗    ███████╗██║██║  ██╗███████╗    \n" +
                "                        ╚═╝  ╚═╝ ╚═════╝  ╚═════╝  ╚═════╝ ╚══════╝    ╚══════╝╚═╝╚═╝  ╚═╝╚══════╝    \n" +
                "                                                                                                      \n" +
                "                                                                                 2020-2021                                                               \n" +
                "                                                                           KHERROUBI Abdelkader                    \n" +
                "                                                                                BELAHCEN MOHAMED     \n" +
                "                                                                                    KOUS Nourhene        \n" +
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "********************************************************************************************************************************************************************************************"+ANSI_RESET);
    }


    static void espaces(int i)
    {
        for (int j = 0; j < i; j++) {
            System.out.println();

        }
    }


}
