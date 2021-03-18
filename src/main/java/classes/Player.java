package classes;

public class Player {
    Monde monde;
    int sante=100;
    int experience=60;
    int argent=856;
    int x;
    int y;

    public Player(int x, int y,Monde monde) {
        this.x = x;
        this.y = y;
        this.monde=monde;
    }
    public Player(){
        this.x=0;
        this.y=0;
    }

    public void deplacerADroite() {
        if (this.monde.getMap()[this.y][this.x+1] == 1) {

            this.monde.getMap()[this.y][this.x] = 1;
            this.x++;
            this.monde.getMap()[this.y][this.x] = 2;
        }
    }
    public void deplacerAGauche() {
        if (this.monde.getMap()[this.y][this.x-1] == 1) {
            this.monde.getMap()[this.y][this.x] = 1;
            this.x--;
            this.monde.getMap()[this.y][this.x] = 2;
        }
    }
    public void deplacerEnHaut(){
        if (this.monde.getMap()[this.y-1][this.x]== 1) {
        this.monde.getMap()[this.y][this.x]=1;
        this.y--;
        this.monde.getMap()[this.y][this.x]=2;
    }}
    public void deplacerEnBas(){
        if (this.monde.getMap()[this.y+1][this.x] == 1) {
        this.monde.getMap()[this.y][this.x]=1;
        this.y++;
        this.monde.getMap()[this.y][this.x]=2;
    }}
    public void actualiser(char input){
        switch (input){
            case 'z':
                deplacerEnHaut();
                break;
            case 'd':
                deplacerADroite();
                break;
            case 's':
                deplacerEnBas();
                break;
            case 'q':
                deplacerAGauche();
                break;
            default :
        }
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
