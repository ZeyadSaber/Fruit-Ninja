package gameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MangoFruit extends GameObject {

	public MangoFruit() throws IOException {
		setXlocation(0);
		setYlocation(0);
		isSliced = false;
		size=150;
		// Images to be added
		//--------------------
		imgs[0] = ImageIO.read(new File("src/images/mango.png"));
		imgs[1] = ImageIO.read(new File("src/images/slicedMango.png"));
	}
	
    @Override
    public gameObj getObjectType() {
        return gameObj.Fruit;
    }

}
