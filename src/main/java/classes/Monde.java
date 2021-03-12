package classes;

public class Monde {
    private int largeur;
    int hauteur;
    int[][] map;
    Camera camera;

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Monde(int largeur, int hauteur) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        map=new int[hauteur][largeur];

        for (int i=0 ;i<hauteur ;i++){
          for (int j=0 ;j<largeur ; j++){
              map[i][j]=0;
          }
        }
        map[1][1]=1;
    }


    public int[][] getMap() {
        return map;
    }
    public void ajouterUneSalle(Salle salle){
        for (int i=salle.getY() ;i<(salle.getY()+salle.getHauteur()) ;i++){
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

        for (int i=camera.getY() ; i<(camera.getY()+camera.getHauteur()) ;i++){
            for (int j=camera.getX() ;j<(camera.getX() + camera.getLargeur())  ; j++){
                System.out.print(Tools.getSymbole(map[i][j]));
            }
            System.out.println();
        }
    }


}
