import creatures.Player;
import creatures.PlayerInventory;

import java.util.Scanner;

public class PlayScreen {

    private int screenWidth = 50;
    private int screenHeight = 20;
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
                    System.out.print('#');
                } else

                    System.out.print(world.getTile(j, i).getSymbole());


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
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("                            INFOS PLAYER                                  ");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println(" |LEVEL : " + player.getLevel() +
                " |HEALTH : " + player.getHealth() +
                " |ATTACK : " + player.getAttack() +
                " |DEFENSE : " + player.getDefense() +
                " |EXPERIENCE : " + player.getExperience() +
                " |ARME : " + player.getArmeNom() + " ( X ) pour attaquer à distance");


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


        for (int i = 0; i < world.getLignes(); i++) {
            for (int j = 0; j < world.getColonnes(); j++) {
                System.out.print(world.getTile(j, i).getSymbole());
            }
            System.out.println();

        }
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("                            INFOS PLAYER                                  ");
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("LEVEL : " + player.getLevel());
        System.out.println("EXPERIENCE : " + player.getExperience());
        System.out.println("HEALTH : " + player.getHealth());
        System.out.println("ATTACK : " + player.getAttack());
        System.out.println("DEFENSE : " + player.getDefense());


    }

    void startScreen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("                                                                                                      \n" +
                "                                                                                                      \n" +
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
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "                                                                                                      \n" +
                "                                                                                                      ");
    }


    static void espaces(int i)
    {
        for (int j = 0; j < i; j++) {
            System.out.println();

        }
    }


}
