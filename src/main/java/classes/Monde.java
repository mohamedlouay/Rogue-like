package classes;

import java.util.Scanner;

public class Monde {
    private int largeur;
    int hauteur;
    int[][] map;
    Camera camera;
    Player player;
    Scanner scanner;

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    public void addPlayer(Player player){
        this.player=player;
        map[player.getY()][player.getX()]=2;

    }

    public Monde(int largeur, int hauteur) {
        scanner = new Scanner(System.in);
        this.largeur = largeur;
        this.hauteur = hauteur;
        map=new int[hauteur][largeur];

        for (int i=0 ;i<hauteur ;i++){
          for (int j=0 ;j<largeur ; j++){
              map[i][j]=0;
          }
        }
    }


    public int[][] getMap() {
        return map;
    }


    public void ajouterUneSalle(Salle salle){

        for (int i=salle.getY() ;i<(salle.getY()+salle.getHauteur()) ;i++){
            // la valeur 1  indique une place a occuper .
            for (int j=salle.getX(); j<(salle.getX() + salle.getLargeur())  ; j++){
                map[i][j]=1;
            }
        }
    }

    public void afficher(){
        System.out.println();
        System.out.println();
        System.out.println("___________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println("                                       SANTE : 100                         EXPERIENCES : 100                    ARGENT : 60$   ");
        System.out.println("____________________________________________________________________________________________________________________________________________________________________________________________________________________");
        System.out.println();

        // affichage de la partie de projection de la cemera :

        for (int i=camera.getY() ; i<(camera.getY()+camera.getHauteur()) ;i++){
            for (int j=camera.getX() ;j<(camera.getX() + camera.getLargeur())  ; j++){
                //affichage du symbole selon l entier :
                System.out.print(Tools.getSymbole(map[i][j]));
            }
            System.out.println();
        }
    }


    public void actulaiser(){
    this.playGame();
    }
    public void playGame() {


        while (true)
        {
            userInput();
            this.afficher();
        }

    }

    private void userInput() {
        char input ;
        input = scanner.next().charAt(0);
        player.actualiser(input);
    }



}
