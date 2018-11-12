package model;

import java.awt.Point;
import java.awt.Rectangle;

public class PuzzlePiece {

	private Point origin;
	private final Point original;
	private int width,height;
	private int screenX,screenY;
	Rectangle piece;
	public PuzzlePiece(int x, int y, int width, int height) {
		this.width = width;
		this.height= height;

		//Set "origin" of puzzle piece
		origin = new Point(x,y);
		original = new Point(x,y);
		screenX=0;
		screenY=0;
		piece = new Rectangle(screenX,screenY,width,height);
		//computeRectangle();

	}

	public void computeRectangle() {
		System.out.println("Rectangle Updated");
		piece.setRect(screenX, screenY, width, height);
	}
	public Rectangle getRectangle() {
		return this.piece;
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

	public int getScreenX() {
		return screenX;
	}

	public void setScreenX(int screenX) {
		this.screenX = screenX;
	}

	public int getScreenY() {
		return screenY;
	}

	public void setScreenY(int screenY) {
		this.screenY = screenY;
	}
}
