package controller;

import java.io.IOException;
import java.util.Random;

import GUI.GameGui;
import command.LoadHighestScore;
import command.SaveHighestScore;
import command.invoker;
import gameObjects.GameObject;
import gameObjects.ObjectsFactory;
import interfaces.IGameActions;
import interfaces.IGameObject;
import javafx.stage.Stage;

public class GameActions implements IGameActions{
	private GameObject object;
	private ObjectsFactory factory = new ObjectsFactory();
	private Random rg = new Random();
	   private SaveHighestScore save;
	    private LoadHighestScore load = new LoadHighestScore();
	    private invoker proccess;
    //-----------------------------------------------------------------------------------------------------------------
    /**
     Implementing Singleton design pattern in GameActions Class.
     */
    private static GameActions gameActions;
    public static GameActions get() {
        if (gameActions == null) gameActions = new GameActions();
        return gameActions;
    }
    private GameActions() {

    }
    //-----------------------------------------------------------------------------------------------------------------

    @Override
    public IGameObject createGameObject() {
		int rand = rg.nextInt(7);
		try {
			switch (rand) {
			case 0:
				object = factory.getObject("watermelon");
				break;
			case 1:
				object = factory.getObject("orange");
				break;
			case 2:
					object = factory.getObject("mango");
				break;
			case 3:
				object = factory.getObject("fatal bomb");
				break;
			case 4:
				object = factory.getObject("strawberry");
				break;
			case 5:
				object = factory.getObject("dangerous bomb");
				break;
			default:
				object = factory.getObject("banana");
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		object.setXlocation(((int) (50 + rg.nextDouble() * 700)));
		object.setYlocation(589);
		object.setMaxHeight(((int) ( rg.nextDouble() * 110)));
        return object;
    }

	@Override
    public void updateObjectsLocations(double time, IGameObject object1) {
        object1.move(time);
    }

    @Override
    public void sliceObjects() {
        object.slice();
    }

    @Override
    public void saveGame() {
        //TODO
    }

    //TODO
    @Override
    public void loadGame() {
        //TODO
    }

    //TODO
    @Override
    public void resetGame(GameGui gui, Stage stage) {
    	gui.setLives(3);
    	gui.setMissed(0);
    	gui.setScore(0);
    	gui.cleanUp();
    	gui.restart(stage);
    }
	@Override
	public void saveHighScore(int h) {
		save = new SaveHighestScore(h);
		proccess = new invoker(save);
		proccess.execute();
	}
	@Override
	public int LoadHighScore() {
		proccess = new invoker(load);
		proccess.execute();
		return load.getHighestScore();
	}

}
