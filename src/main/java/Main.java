
import java.io.IOException;
import java.util.Scanner;

public class Main {





    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String fileName ;
        System.out.println("choisissez une map parmi : map1.txt map2.txt map3.txt");
        fileName = scanner.next();
        GameSystem gameSystem = new GameSystem(fileName) ;
        gameSystem.playGame();


    }


}
