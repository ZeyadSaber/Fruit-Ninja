package GUI;

import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Levels{

	 public void LevelsMenu(Stage stage) {

	        //creating the background image
	        Image background = new Image("file:src/images/FruitNinjaMenuBackground.jpg");
	        ImageView ivBackground = new ImageView(background);
	        ivBackground.setFitHeight(720);
	        ivBackground.setFitWidth(1080);




	        Button easy = new Button("Easy");

	        easy.setLayoutX(710);
	        easy.setLayoutY(50);
	        easy.setPrefHeight(31*2);
	        easy.setPrefWidth(125*2);
	        easy.setTextFill(Paint.valueOf("Green"));


	        easy.setOnAction( e -> {
	            EasyGameLevel easyLevel = new EasyGameLevel(stage);
	            try {
	                easyLevel.startGame(stage);
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        });



	        Button medium = new Button("Medium");
	        Button hard = new Button("Hard");

	        medium.setLayoutX(710);
	        medium.setLayoutY(150);

	        medium.setPrefHeight(31*2);
	        medium.setPrefWidth(125*2);
	        medium.setTextFill(Paint.valueOf("Green"));


	        hard.setLayoutX(710);
	        hard.setLayoutY(250);

	        hard.setPrefHeight(31*2);
	        hard.setPrefWidth(125*2);
	        hard.setTextFill(Paint.valueOf("Green"));

	        medium.setOnAction( e -> {
	            MediumGameLevel mediumLevel = new MediumGameLevel(stage);
	            try {
	                mediumLevel.startGame(stage);
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        });
	        

	        hard.setOnAction( e -> {
	            HardGameLevel hardLevel = new HardGameLevel(stage);
	            try {
	                hardLevel.startGame(stage);
	            } catch (Exception ex) {
	                ex.printStackTrace();
	            }
	        });
	        Button back = new Button("Back");
	        back.setLayoutX(930);
	        back.setLayoutY(620);
	        back.setPrefHeight(150);
	        back.setPrefHeight(30);
	        back.setOnAction(e ->{
	        	MainMenu mainmenu = new MainMenu();
	        	mainmenu.mainMenu(stage);
	        });

	        javafx.scene.text.Font font = new Font(25);
	        easy.setFont(font);
	        medium.setFont(font);
	        hard.setFont(font);
	        back.setFont(font);
	        Pane root = new Pane();
	        root.getChildren().addAll(ivBackground, easy, medium,hard,back);
	        root.setCursor(Cursor.cursor("file:src/images/sword.png"));
	        Scene startMenuScene = new Scene(root,1080,720);
	        stage.setScene(startMenuScene);
	        stage.show();

	    }


}
