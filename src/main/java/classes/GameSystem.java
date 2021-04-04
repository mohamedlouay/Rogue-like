package classes;

import classes.scenes.PlayScene;
import classes.scenes.Scene;

public class GameSystem {

    private Scene scene ;
    GameSystem(){
        scene= new PlayScene();
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }
    public Scene getScene() {
        return scene;
    }

}
