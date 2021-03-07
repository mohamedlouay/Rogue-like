import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Map {


    private char[][] map;
    private int nbLine;
    private int nbColonne;


    public Map(String fileName,Player player) throws IOException {

        map = readMap("maps/"+fileName);
        nbLine = map.length;
        nbColonne = map[0].length;

        setPosition(player) ;



    }

    public char[][] getMap() {
        return map;
    }

    public int getNbLine() {
        return nbLine;
    }

    public int getNbColonne() {
        return nbColonne;
    }


    //lire le fichier map et creer un tableau 2d qui contient cette map
    public  char[][] readMap(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        List<String> lignes = Files.readAllLines(path);
        int n = lignes.size();
        int m = lignes.get(0).length();
        char vect[][] = new char[n][m];

        for (int i = 0; i < n; i++) {
            vect[i] = lignes.get(i).toCharArray();
        }


        return vect;


    }

    void setPosition(Player player)
    {
        char tile ;

        for (int i = 0; i < this.nbLine; i++) {
            for (int j = 0; j < this.nbColonne; j++) {

                tile = map[i][j] ;
                switch (tile)
                {
                    case '@' : {player.setPosition(j,i);
                        break;}
                }
            }

        }



    }


    public void movePlayer ( char input , Player player) {
        int playerX = player.getX();
        int playerY = player.getY();



        switch (Character.toUpperCase(input))
        {
            case 'Z' : {tryMovePlayer(playerX,playerY-1,player);break;}
            case 'Q' : {tryMovePlayer(playerX-1,playerY,player);break;}
            case 'D' : {tryMovePlayer(playerX+1,playerY,player);break;}
            case 'W' : {tryMovePlayer(playerX,playerY+1,player);break;}
            default:
                System.out.println("invalid input ! ");
                try {
                    Thread.sleep(700);// to see the displayed statement : invalid input !  !!!!!
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


        }
    }

    private void tryMovePlayer (int x ,int y,Player player)  {
        char tile = getTile(x,y) ;
        int oldX = player.getX();
        int oldY = player.getY();
        switch (tile)
        {
            case '#' :{
                System.out.println("mur!!!!!!!!!");
                try {
                    Thread.sleep(700);// to see the displayed statement : mur !!!!!
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            default: {

                player.setPosition(x,y);
                setTile(x,y,'@');
                setTile(oldX,oldY,'.');
            }

        }


    }






    public char getTile (int x , int y )
    {
        char c = map[y][x];
        return c;
    }
    public void setTile (int x , int y , char c )
    {
        map[y][x] = c;
    }


    public void displayMap() {
        clearScreen(20);
        for (int i = 0; i < this.nbLine; i++) {
            for (int j = 0; j < this.nbColonne; j++) {
                System.out.print(this.map[i][j]);

            }
            System.out.println();

        }


    }
    public void clearScreen(int n) {
        for (int i = 0; i < n; ++i) System.out.println();
    }
}
