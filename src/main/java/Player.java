public class Player {

    private int x;
    private int y;


    //initialiser le joueur au position zero
    public Player() {
        this.x =0 ;
        this.y = 0 ;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //changer la position du joueur
    void setPosition(int x ,int y)
    {
        this.x=x;
        this.y=y;
    }
}
