package generationProcedurale;

public enum Tile {


    SOL('.') ,
    MUR(' '),
    WINDOW('<'),
    EDGE('#') ,
    PLAYER('@') ,
    ZOMBIE('Z'),
    SNAKE('S'),
    DRAGON('D'),
    WOLF('W');

    private char symbole ;

    Tile(char symbole)
    {
        this.symbole=symbole;
    }
    public char getSymbole()
    {
        return this.symbole;
    }



}
