package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class MainMenu{

	 public void mainMenu(Stage stage) {

	        //creating the background image
	        Image background = new Image("file:src/images/FruitNinjaMenuBackground.jpg");
	        ImageView ivBackground = new ImageView(background);
	        ivBackground.setFitHeight(720);
	        ivBackground.setFitWidth(1080);



	        Button newGame = new Button("New Game");
	        newGame.setPrefHeight(31*2);
	        newGame.setPrefWidth(125*2);
	        newGame.setTextFill(Paint.valueOf("Green"));


	        newGame.setLayoutX(710);
	        newGame.setLayoutY(100);

	        newGame.setOnAction( e -> {
	            Levels levels = new Levels();
	            levels.LevelsMenu(stage);
	        });



	        Button exit = new Button("Exit");

	        exit.setLayoutX(710);
	        exit.setLayoutY(200);
	        exit.setPrefHeight(31*2);
	        exit.setPrefWidth(125*2);
	        exit.setTextFill(Paint.valueOf("Red"));
	        exit.setOnAction( e -> {
	            stage.close();
	        });

	        javafx.scene.text.Font font = new Font(35);
	        newGame.setFont(font);
	        exit.setFont(font);

	        
	        Pane root = new Pane();

	        root.getChildren().addAll(ivBackground, newGame, exit);
	        root.setCursor(Cursor.cursor("file:src/images/sword.png"));
	        Scene startMenuScene = new Scene(root,1080,720);
	        stage.setScene(startMenuScene);
	        stage.show();

	    }

}
