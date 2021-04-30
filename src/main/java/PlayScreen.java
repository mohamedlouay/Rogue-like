import creatures.Player;
import generationProcedurale.Tile;

public class PlayScreen {

    private int screenWidth = 50;
    private int screenHeight = 20;

    public PlayScreen(int screenWidth, int screenHeight) {
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
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
                " |EXPERIENCE : " + player.getExperience() +
                " |HEALTH : " + player.getHealth() +
                " |ATTACK : " + player.getAttack() +
                " |DEFENSE : " + player.getDefense() +
                " |ARME : " + player.getArmeNom() + " ( X ) pour attaquer à distance");


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


}
