package model;

import java.awt.Point;

public class PuzzlePiece {

	private Point origin;
	private int width,height;

	public PuzzlePiece(int x, int y, int width, int height) {
		this.width = width;
		this.height= height;

		//Set "origin" of puzzle piece
		origin = new Point(x,y);
	}

	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public int getX() {
		return origin.x;
	}
	public int getY() {
		return origin.y;
	}
	@Override
	public String toString() {
		return "Dimensions: " + getHeight() +"x" + getWidth();
	}
}
