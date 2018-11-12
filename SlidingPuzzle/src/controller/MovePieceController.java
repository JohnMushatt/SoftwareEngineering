package controller;

import model.Model;
import view.PuzzleApp;

public class MovePieceController {
	private Model m;
	private PuzzleApp app;
	private int x,y;
	public MovePieceController (Model m, PuzzleApp app,int x, int y) {
		this.m = m;
		this.app = app;
		this.x=x;
		this.y=y;
	}

	public void move() {
		if(m.getPiece(x, y)!=null && (x+1>0) &&(x<4) &&(y>0) &&(y<5)) {
			m.getSelectedPiece().setX(x);
			m.getSelectedPiece().setY(y);
		}
		app.getPuzzleView().repaint();
		System.out.println("MOVE CONTROLLER USED");
	}
}
