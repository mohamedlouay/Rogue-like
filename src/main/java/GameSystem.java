import java.io.IOException;
        import java.util.Scanner;

public class GameSystem {

    private Map map ;
    private Player player ;

    public GameSystem(String fileName) throws IOException {
        player =new Player();
        map  =new Map(fileName,player);


    }

    public void playGame() {
        boolean isDone =false ;

        while (isDone== false)
        {
            map.displayMap();
            userInput();
        }


    }

    private void userInput() {
        Scanner scanner = new Scanner(System.in);
        char input ;
        System.out.println("Enter a move command (z/Q/D/W) :");
        input = scanner.next().charAt(0);
        map.movePlayer(input, player);
    }
}
