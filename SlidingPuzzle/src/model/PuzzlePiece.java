package model;

public class PuzzlePiece {

	private int x,y;
	private int width,height;

	public PuzzlePiece(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height= height;
	}

	public int getX() {
		return x;
	}
	public int getY() {
		return y;

	}
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}

	public void setX(int x) {
		this.x = x;

	}
	public void setY(int y) {
		this.y=y;
	}

}
