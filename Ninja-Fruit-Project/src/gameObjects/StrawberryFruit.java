package gameObjects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class StrawberryFruit extends GameObject {
	public  StrawberryFruit() throws IOException {
		isSliced = false;
		size= 100;
		// Images to be added
		//--------------------
		imgs[0] = ImageIO.read(new File("src/images/strawberry.png"));
		imgs[1] = ImageIO.read(new File("src/images/slicedStrawberry.png"));
	}
	
    @Override
    public gameObj getObjectType() {
        return gameObj.SpecialFruit;
    }
}
