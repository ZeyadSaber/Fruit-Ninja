package GUI;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EasyGameLevel extends GameGui{
    public EasyGameLevel(Stage stage){
        time = 102;
        falling = 3100;
        reset = new Button("Reset");
        reset.setLayoutX(930);
        reset.setLayoutY(60);
        reset.setOnAction(e -> {
        	ga.resetGame(this,stage);
	        lblHighestScore.setText("Highest Score: "+highestScore);
        	lblLives.setText("Lives: " + String.valueOf(lives));
        	lblScore.setText("Score: " + String.valueOf(score));
        	lblMissed.setText("Missed: " + String.valueOf(missed));

        });
    }
}
