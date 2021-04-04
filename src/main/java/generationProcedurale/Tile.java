package generationProcedurale;

public enum Tile {


    SOL('.') ,MUR(' '),EDGE('#') ,PLAYER('@') ,ZOMBIE('Z');

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
