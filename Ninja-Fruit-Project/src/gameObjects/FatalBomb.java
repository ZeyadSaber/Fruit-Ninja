package gameObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FatalBomb extends GameObject {
	public  FatalBomb() throws IOException {
		setXlocation(0);
		setYlocation(683);
		isSliced = false;
		size=150;
		// Images to be added
		//--------------------
		imgs[0] = ImageIO.read(new File("src/images/fatalBomb.png"));
		imgs[1] = ImageIO.read(new File("src/images/boom.png"));
	}
	
    @Override
    public gameObj getObjectType() {
        return gameObj.FatalBomb;
    }
}
