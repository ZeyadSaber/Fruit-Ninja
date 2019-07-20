package gameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import gameObjects.GameObject.gameObj;

public class DangerousBomb extends GameObject {

	public  DangerousBomb() throws IOException {
		setXlocation(0);
		setYlocation(0);
		isSliced = false;
		size = 150;
		// Images to be added
		//--------------------
		imgs[0] = ImageIO.read(new File("src/images/dangerousBomb.png"));
		imgs[1] = ImageIO.read(new File("src/images/explosion.png"));
	}
	
    @Override
    public gameObj getObjectType() {
        return gameObj.DangerousBomb;
    }
}
