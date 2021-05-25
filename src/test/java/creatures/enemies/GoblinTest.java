package creatures.enemies;

import creatures.EnemyFactory;
import creatures.Player;
import gameSystem.World;
import generationProcedurale.Tile;
import items.Item;
import items.ItemsFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {
    Player player = new Player();
    World world =new World(player , 100 ,100) ;
    Goblin goblin = (Goblin) EnemyFactory.createNewEnemy(Tile.GOBLIN,1, player.getPositionX()+1, player.getPositionY()+1);

    Item food = ItemsFactory.createNewItem(Tile.FOOD,1, player.getPositionX()+2,player.getPositionY()+2 );



    @Test
    void collect() {
        world.getItems().add(food);

        int nb_items_avant = goblin.getItemStolen().size();

        goblin.collect(goblin.getPositionX()+1, goblin.getPositionY()+1, world.getItems(), world.getTiles());

        int nb_items_apres = goblin.getItemStolen().size();

        assert (nb_items_avant+1 == nb_items_apres) ;




    }
}