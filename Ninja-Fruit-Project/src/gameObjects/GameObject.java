package gameObjects;

import java.awt.image.BufferedImage;

import interfaces.IGameObject;

public class GameObject implements IGameObject<Object> {
	
	private int Xlocation;
	private int Ylocation;
	protected int size;
	public int getSize() {
		return size;
	}

	private int maxHeight;
	protected int initialVelocity=100;
	protected int fallingVelocity=0;
	protected boolean isSliced;
	private boolean up = true;
	protected BufferedImage[] imgs = new BufferedImage[5];
	protected enum gameObj{
		Fruit,
		SpecialFruit,
		DangerousBomb,
		FatalBomb
	}


	@Override
	public gameObj getObjectType() {
		return null;
	}

	@Override
	public int getXlocation() {
		return Xlocation;
	}

	@Override
	public int getYlocation() {
		return Ylocation;
	}

	@Override
	public int getMaxHeight() {
		return maxHeight;
	}

	@Override
	public int getInitialVelocity() {
		return initialVelocity;
	}

	@Override
	public int getFallingVelocity() {
		return fallingVelocity;
	}

	@Override
	public boolean isSliced() {
		return isSliced;
	}
	
	@Override
	public boolean hasMovedOffScreen() {
		if(getYlocation() >= 590)
			return true;
		else
			return false;
	}

	@Override
	public void slice() {
		isSliced = true;	
	}

	@Override
	public void move(double time) {
		fallingVelocity = (int) (initialVelocity + 9.8 * (time/1000));
		if(getYlocation() > getMaxHeight() && up) {
			Ylocation -= fallingVelocity * (time/2500);
		}
		else if(getYlocation() <= getMaxHeight() && up) {
			up = false;
			initialVelocity=fallingVelocity;
			fallingVelocity =0;
		}else
			Ylocation += fallingVelocity * (time/2500);

	}

	@Override
	public BufferedImage[] getBufferedImages() {
		return imgs;
	}

	public boolean insideBounds(double x, double y) {
		if(x>=getXlocation() && x<getXlocation()+size && y>=getYlocation() && y<getYlocation()+size)
			return true;
		else
			return false;
	}

	/**
	 * @param xlocation the xlocation to set
	 */
	public void setXlocation(int xlocation) {
		Xlocation = xlocation;
	}

	/**
	 * @param ylocation the ylocation to set
	 */
	public void setYlocation(int ylocation) {
		Ylocation = ylocation;
	}

	/**
	 * @param maxHeight the maxHeight to set
	 */
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}


}
