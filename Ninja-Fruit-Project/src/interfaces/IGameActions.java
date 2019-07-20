package interfaces;

import GUI.GameGui;
import javafx.stage.Stage;

public interface IGameActions {
    /**
     *@return ​created game object
     */
    //TODO
    public IGameObject createGameObject();


    /**
     *update moving objects locations
     */
    public void updateObjectsLocations(double time,IGameObject object1);

    public void saveHighScore(int h);
    public int LoadHighScore();
    /**
     * ​it is used to slice fruits located in your swiping region This method can take your swiping region as parameters (they
     depend on how you calculate it).
     */
    public void sliceObjects();


    /**
     *saves the current state of the game
     */
    public void saveGame();


    /**
     *​loads the last saved state of the game
     */
    public void loadGame();


    /**
     *resets the game to its initial state
     */
    public void resetGame(GameGui gui, Stage stage);
}
