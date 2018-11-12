package model;

import java.awt.Point;

public class PuzzlePiece {

	private Point origin;
	private final Point original;
	private int width,height;

	public PuzzlePiece(int x, int y, int width, int height) {
		this.width = width;
		this.height= height;

		//Set "origin" of puzzle piece
		origin = new Point(x,y);
		original = new Point(x,y);
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public void setX(int x) {
		this.origin.x=x;
	}
	public void setY(int y) {
		this.origin.y=y;
	}
	public int getX() {
		return origin.x;
	}
	public int getY() {
		return origin.y;
	}
	public int getOriginalX() {
		return original.x;
	}
	public int getOriginalY() {
		return original.y;
	}
	@Override
	public String toString() {
		return "Dimensions: " + getHeight() +"x" + getWidth() + " X: " +this.origin.getX() + " Y: " + this.origin.getY();
	}
}
