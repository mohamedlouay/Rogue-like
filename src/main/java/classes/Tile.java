package classes;

public enum Tile {

    SOL('.') ,MUR(' '),EDGE('#') ;
    private char value ;

    Tile(char value)
    {
        this.value=value;
    }
    public char getValue()
    {
        return this.value;
    }

}
