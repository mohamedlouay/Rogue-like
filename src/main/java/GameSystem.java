import creatures.Player;

import java.awt.*;
import java.util.Scanner;

public class GameSystem {
    Player player ;
    World world ;
    PlayScreen screen ;



    public int lignes =30;
    public int colonnes =100 ;
    Scanner scanner = new Scanner(System.in);

    public GameSystem()
    {
        player = new Player();
        world =new World(player, lignes,colonnes);
        screen = new PlayScreen(50,20);


    }


    public void playGame()
    {
       screen.startScreen();
       pause();
        boolean gameOver =false ;

        while (gameOver == false)
        {

            screen.display(player , world);

            userInput();
            world.moveEnemies(player);
            world.update(player);



        }


    }

    private void userInput() {
        char input ;
        System.out.println("entrer (z/Q/D/W) pour se deplacer , ( A ) pour changer d'arme  :");
        input = scanner.next().toUpperCase().charAt(0);

        world.movePlayer(input, player);

    }


    public static  void pause() {
        System.out.println("Press Any Key To Continue...");
        new Scanner(System.in).nextLine();
    }

}


