package gameObjects;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameObjects.GameObject.gameObj;

public class BananaFruit extends GameObject {
	
	public  BananaFruit() throws IOException {
		isSliced = false;
		size = 100;
		// Images to be added
		//--------------------
		imgs[0] = ImageIO.read(new File("src/images/banana.png"));
		imgs[1] = ImageIO.read(new File("src/images/slicedBanana.png"));
	}
	
    @Override
    public gameObj getObjectType() {
        return gameObj.SpecialFruit;
    }
}
