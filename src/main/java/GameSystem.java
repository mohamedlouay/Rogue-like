import creatures.Player;

import java.util.Scanner;

public class GameSystem {
    Player player ;
    World world ;
    PlayScreen screen ;
    public int lignes =100;
    public int colonnes =400 ;
    Scanner scanner = new Scanner(System.in);

    public GameSystem()
    {   player = new Player();
        world =new World(player, lignes,colonnes);
        screen = new PlayScreen(50,20);

    }


    public void playGame()
    {
        boolean gameOver =false ;

        while (gameOver == false)
        {

            screen.display(player,world);
            userInput();


        }


    }

    private void userInput() {
        char input ;
        System.out.println("Enter a move command (z/Q/D/W) :");
        input = scanner.next().toUpperCase().charAt(0);
        world.movePlayer(input, player);
    }


    public static  void pause() {
        System.out.println("Press Any Key To Continue...");
        new Scanner(System.in).nextLine();
    }

}


