package GUI;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HardGameLevel extends GameGui{

    public HardGameLevel(Stage stage) {
        time = 302;
        falling = 1200;
        reset = new Button("Reset");
        reset.setLayoutX(930);
        reset.setLayoutY(60);
        reset.setOnAction(e -> {
        	ga.resetGame(this,stage);
        	gc.clearRect(0, 0, 1024, 683);
        	timeline.setDelay(Duration.seconds(3));
	        lblHighestScore.setText("Highest Score: "+highestScore);
        	lblLives.setText("Lives: " + String.valueOf(lives));
        	lblScore.setText("Score: " + String.valueOf(score));
        	lblMissed.setText("Missed: " + String.valueOf(missed));

        });
    }
}
