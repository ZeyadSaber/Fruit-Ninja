package GUI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import controller.GameActions;
import interfaces.IGameObject;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.image.BufferedImage;
import java.io.File;

import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
public class GameGui {

    	protected AnimationTimer timer;
	    private Group root;
	    private List<IGameObject> drop=new ArrayList();
	    protected double time;
	    protected double falling;
	    protected Label lblMissed,lblLives,lblScore,lblHighestScore;
	    protected int missed,lives=3,score=0,highestScore;
	    protected GameActions ga;
	    private Canvas canvas ;
	    protected GraphicsContext gc;
	    private Scene scene;
	    protected Timeline timeline;
	    private Image background;
	    protected Button reset;
	    private long pauseEnd = 0L;
	    private boolean sliced = false;
	    private MediaPlayer myaudio,ulost;
	    private Media sound,lost;
	    public void startGame(Stage primaryStage) throws Exception {
	    	ga = GameActions.get();
	    	canvas = new Canvas(1024,683);
	        lblMissed = new Label("Missed: 0");
	        lblLives = new Label("Lives: "+lives);
	        lblScore = new Label("Score: "+score);
	        lblHighestScore = new Label("Highest Score: "+highestScore);
	        lblLives.setLayoutX(10);
	        lblLives.setLayoutY(40);
	        lblMissed.setLayoutX(10);
	        lblMissed.setLayoutY(10);
	        lblScore.setLayoutX(10);
	        lblScore.setLayoutY(70);
	        lblHighestScore.setLayoutX(10);
	        lblHighestScore.setLayoutY(100);
	        lblScore.setFont(Font.font("Berlin Sans FB Demi",25));
	        lblScore.setTextFill(Paint.valueOf("#4A88D4"));
	        lblHighestScore.setFont(Font.font("Berlin Sans FB Demi",25));
	        lblHighestScore.setTextFill(Paint.valueOf("#4A88D4"));
	        lblMissed.setFont(Font.font("Berlin Sans FB Demi",25));
	        lblMissed.setTextFill(Paint.valueOf("#4A88D4"));
	        lblLives.setFont(Font.font("Berlin Sans FB Demi",25));
	        lblLives.setTextFill(Paint.valueOf("#4A88D4"));
	        missed = 0;
	        
	        root = new Group();
	        gc = canvas.getGraphicsContext2D();
	        highestScore = ga.LoadHighScore();
	        lblHighestScore.setText("Highest Score: "+highestScore);
	        
	        //creating the background image
	        background = new Image("file:src/images/gameBackground.jpg");
	        ImageView ivBackground = new ImageView(background);
	        ivBackground.setFitHeight(720);
	        ivBackground.setFitWidth(1080);
	        //--------------------------------
	        
	        //setting Cursor
	        root.setCursor(Cursor.cursor("file:src/images/sword.png"));
	        //---------------------------------------------------------
	        
	        
	        
            // setting audio
            //------------------------
			lost = new Media(new File("src/audio/لاي لاي لاي لا لا لا lay lay lay la la la.mp3").toURI().toString());
			ulost = new MediaPlayer(lost);
	        sound = new Media(new File("src/audio/FireBallPitBull.mp3").toURI().toString());
	        myaudio = new MediaPlayer(sound);
            myaudio.setOnEndOfMedia(new Runnable() {

				@Override
				public void run() {
					myaudio.seek(Duration.ZERO);
				}
            });
            myaudio.play();
            //-------------------------
            
	        timeline = new Timeline(new KeyFrame(Duration.millis(falling), event -> {
	            time += falling / 3000;
	        	IGameObject c = ga.createGameObject();
	            drop.add(c);
	        }));
	        timeline.setCycleCount(4000);
	        timeline.play();
	        
	        
	        canvas.setOnMousePressed(event -> {
	            for (IGameObject current : drop) {
	                if(current.insideBounds(event.getX(), event.getY())) {
	                    current.slice();
	                }
	            }
	        });;

	        timer = new AnimationTimer() {

	            @Override
	            public void handle(long arg0) {
	            	
	                gameUpdate(arg0);
	            }

	        };
	        timer.start();
	        
	        //Back button
	        Button back = new Button("Back");
	        back.setLayoutX(930);
	        back.setLayoutY(20);
	        back.setOnAction(e ->{
	        	Levels levels = new Levels();
	        	myaudio.stop();
	        	ulost.stop();
	        	levels.LevelsMenu(primaryStage);
	        });
	        //-------------------------------------------
	        scene = new Scene(root, 1024, 683);

	
	        root.getChildren().addAll(ivBackground,lblMissed,canvas,back,reset);
	        root.getChildren().addAll(lblLives);
	        root.getChildren().addAll(lblScore);
	        root.getChildren().addAll(lblHighestScore);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }

	    	public void setMissed(int missed) {
			this.missed = missed;
		}

		public void setLives(int lives) {
			this.lives = lives;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public void gameUpdate(long timestamp){
		    Image k;
		    gc.drawImage(background, 300, 300);
	    	gc.clearRect(0, 0, 1024, 683);
	    	if(!sliced) {
	    		pauseFor(timestamp, 850);
	    	}
	    	Iterator<IGameObject> itr = drop.iterator();
	        while(itr.hasNext()) {
	            IGameObject current = itr.next();
	            EventHandler<MouseEvent> e = new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						if(current.insideBounds(event.getX(), event.getY()))
							current.slice();
					}
	            	
	            };
	            gc.getCanvas().setOnMousePressed(e);
	            if(!current.isSliced()) {
	            	k = SwingFXUtils.toFXImage(current.getBufferedImages()[0], null);
	                gc.drawImage(k, current.getXlocation(), current.getYlocation());
		            ga.updateObjectsLocations(time,current);
	            }else {
	            	k = SwingFXUtils.toFXImage(current.getBufferedImages()[1], null);
	            	if(current.getObjectType().toString().equalsIgnoreCase("dangerousbomb")) {
	            		gc.drawImage(k, current.getXlocation(), current.getYlocation());
	            		sliced = true;
	            		if(timestamp >= pauseEnd) {
		            		itr.remove();
		            		lives--;
		                	lblLives.setText("Lives: " + String.valueOf(lives));
		                	sliced = false;
	            		}
	            	}else if(current.getObjectType().toString().equalsIgnoreCase("fatalbomb")) {
		    			gameOver();
		    			break;
	            	}else if(current.getObjectType().toString().equalsIgnoreCase("specialfruit")) {
	            		gc.drawImage(k, current.getXlocation(), current.getYlocation());
	            		sliced = true;
	            		if(timestamp>=pauseEnd) {
		            		itr.remove();
		            		score+=5;
		                	lblScore.setText("Score: " + String.valueOf(score));
		                	if(score >= highestScore) {
		            			highestScore = score;
		            			ga.saveHighScore(highestScore);
		            			lblHighestScore.setText("Highest Score: "+highestScore);
		            		}
		                	sliced = false;
	            		}
	            	}else if(current.getObjectType().toString().equalsIgnoreCase("fruit")) {
	            		gc.drawImage(k, current.getXlocation(), current.getYlocation());
	            		sliced = true;
	            		if(timestamp>=pauseEnd) {
		            		itr.remove();
		            		score++;
		                	lblScore.setText("Score: " + String.valueOf(score));
		                	if(score >= highestScore) {
		            			highestScore = score;
		            			ga.saveHighScore(highestScore);
		            			lblHighestScore.setText("Highest Score: "+highestScore);
		            		}
		                	sliced = false;
	            		}
	            	}
	            }
	    	
	    		if(lives==0) {
	    			gameOver();
	    		}
	            if(current.hasMovedOffScreen()) {
	            	root.getChildren().remove(current);
	        		gc.clearRect(0, 0, 1024, 683);
	        		if(current.getObjectType().toString().equalsIgnoreCase("fruit")||current.getObjectType().toString().equalsIgnoreCase("specialfruit"))
	        			lives--;
	            	itr.remove();
	            	missed ++;
	            	lblMissed.setText("Missed: " + String.valueOf(missed));
                	lblLives.setText("Lives: " + String.valueOf(lives));
	            }
	        }
	    }

		private void pauseFor(long currentTime, long durationMillis) {
			// TODO Auto-generated method stub
			pauseEnd = currentTime + 1_000_000L * durationMillis;
		}

		private void gameOver() {
			myaudio.stop();
			ulost.play();
    		timer.stop();
	        Image gameover = new Image("file:src/images/game_over.png");
	        ImageView ivgameover = new ImageView(gameover);
	        ivgameover.setFitHeight(250);
	        ivgameover.setFitWidth(600);
	        ivgameover.setY(200);
	        ivgameover.setX(220);
	    	gc.clearRect(0, 0, 1024, 683);
	        root.getChildren().addAll(ivgameover);
		}
		
		public void cleanUp() {
			ulost.stop();
			root.getChildren().removeAll(drop);
			drop.removeAll(drop);
			timeline.stop();
			gc.clearRect(0, 0, 1024, 683);
			timer.stop();
			myaudio.stop();
		}
		
		public void restart(Stage primaryStage) {
			cleanUp();
			try {
				startGame(primaryStage);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
