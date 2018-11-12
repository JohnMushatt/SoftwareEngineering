package controller;

import model.Model;
import model.PuzzlePiece;
import view.PuzzleApp;

public class MovePieceController {
	private Model m;
	private PuzzleApp app;
	private int x,y;
	private PuzzlePiece piece;
	public MovePieceController (Model m, PuzzleApp app, PuzzlePiece piece,int x, int y) {
		this.m = m;
		this.app = app;
		this.x=x;
		this.y=y;
		this.piece=piece;
	}
	
	public void move() {
		if(m.getPiece(x, y)!=null) {
			piece.setX(x);
			piece.setY(y);
		}
		app.getPuzzleView().refresh();
	}
}
