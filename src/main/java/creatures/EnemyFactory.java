package creatures;

import creatures.enemies.*;
import generationProcedurale.Tile;

public class EnemyFactory {


    public static Creature createNewEnemy(Tile e, int level, int x, int y) {

        int evolution = level * 5;

        switch (e) {

            case ZOMBIE:
                return new Zombie(Tile.ZOMBIE, 100, 30 + evolution, 20 + evolution, 60, x, y);
            case BAT:
                return new Bat(Tile.BAT, 10, 5 + evolution, 0 + evolution, 5, x, y);
            case GOBLIN:
                return new Goblin(Tile.GOBLIN, 100, 70 + evolution, 60 + evolution, 100, x, y);
            case DRAGON:
                return new Dragon(Tile.DRAGON, 100, 100 + evolution, 80 + evolution, 200, x, y);

        }
        return null;
    }
}
