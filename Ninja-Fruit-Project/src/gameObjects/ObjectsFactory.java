package gameObjects;

import java.io.IOException;

public class ObjectsFactory {

    /**
     *
     * Implementing the <Factory> Design Pattern.
     * @throws IOException 
     */

    public GameObject getObject(String type) throws IOException {
        if (type.equalsIgnoreCase("orange")) return new OrangeFruit();
        else if (type.equalsIgnoreCase("watermelon")) return new WatermelonFruit();
        else if (type.equalsIgnoreCase("Mango")) return new MangoFruit();
        else if (type.equalsIgnoreCase("fatal bomb")) return new FatalBomb();
        else if (type.equalsIgnoreCase("dangerous bomb")) return new DangerousBomb();
        else if (type.equalsIgnoreCase("strawberry")) return new StrawberryFruit();
        else if (type.equalsIgnoreCase("banana")) return new BananaFruit();

        return null;
    }
}
