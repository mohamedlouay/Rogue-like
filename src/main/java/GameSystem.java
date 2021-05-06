import creatures.Player;
import creatures.PlayerInventory;

import java.awt.*;
import java.util.Scanner;

public class GameSystem {
    Player player ;
    World world ;
    PlayScreen screen ;



    public int lignes =25;
    public int colonnes =150 ;
    Scanner scanner = new Scanner(System.in);

    public GameSystem()
    {
        player = new Player();
        world =new World(player, lignes,colonnes);
        screen = new PlayScreen(150,25);



    }


    public void playGame()
    {
       screen.startScreen();
       pause();
        boolean gameOver =false ;

        while (gameOver == false)
        {
            if(player.getDisplayAll()) screen.displayAll(player , world);
            else screen.display(player , world);

            userInput();
            world.moveEnemies(player);
            world.update(player);



        }


    }

    private void userInput() {
        char input ;
        System.out.println("entrer (z/Q/D/W) pour se deplacer , ( A ) pour changer d'arme , (I) pour vesiter l inventaire ,(X) pour une attack a distance  :");
        input = scanner.next().toUpperCase().charAt(0);

        world.movePlayer(input, player);

    }


    public static  void pause() {
        System.out.println("Press Any Key To Continue...");
        new Scanner(System.in).nextLine();
    }

}


