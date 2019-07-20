package gameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class OrangeFruit extends GameObject {

	public OrangeFruit() throws IOException {
		setXlocation(0);
		setYlocation(0);
		isSliced = false;
		size=150;
		// Images to be added
		//--------------------
		imgs[0] = ImageIO.read(new File("src/images/orange.png"));
		imgs[1] = ImageIO.read(new File("src/images/slicedOrange.png"));
	}
	
    @Override
    public gameObj getObjectType() {
        return gameObj.Fruit;
    }

}
