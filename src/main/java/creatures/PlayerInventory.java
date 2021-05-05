package creatures;

public class PlayerInventory {

    int money =50 ;

    public PlayerInventory()
    {

    }


    public void addMoney(int money)
    {
        this.money += money ;
    }

    public int getMoney() {
        return money;
    }
}
