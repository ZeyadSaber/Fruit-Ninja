package interfaces;

import java.awt.image.BufferedImage;

public interface IGameObject<ENUM>{
    /**
     *​​@return​ the type of game object
     */
    public ENUM getObjectType();


    /**
     *​@return​ X location of game object
     */
    public int getXlocation();
//
//    public void setX(int x);
//    public void setMaxHeight(int maxHeight);
    /**
     ​*​@return​ Y location of game object
     */
    public int getYlocation();


    /**
     *@return​ max Y location that the object can reach on the screen
     */
    public int getMaxHeight();


    /**
     *​@return​ velocity at which game object is thrown
     */
    public int getInitialVelocity();

    /**
     ​*​@return​ failing velocity of game object
     */
    public int getFallingVelocity();


    /**
     ​*​@return​ whether the object is sliced or not
     */
    public boolean isSliced();


    /**
     ​    *​@return​ whether the object is dropped off the screen or not
     */
    public boolean hasMovedOffScreen();


    /**
     *it is used to slice the object
     */
    public void slice();

	public boolean insideBounds(double x, double y);
    /**
     *it is used to move the object on the screen
     ​@param ​deltaTime: time elapsed since the object is thrown
     it is used calculate the new position of
     fruit object.
     */
    public void move(double time);


    /**
     *​@return​ at least two images of the object, one when it is sliced and one when it is not.
     */
    public BufferedImage[] getBufferedImages();
}
