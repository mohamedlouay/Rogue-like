class Player {

    private int sante;
    private int x;
    private int y;
    private int arme_id;
    private int experience;
    private int coins ;

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

    public int getSante() {
        return sante;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public int getArme_id() {
        return arme_id;
    }

    public void setArme_id(int arme_id) {
        this.arme_id = arme_id;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
