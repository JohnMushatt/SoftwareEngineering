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
		System.out.println("ATTEMPTING TO MOVE PIECE AT + " +m.getSelectedPiece().getX()+"," + m.getSelectedPiece().getY()+
				" to "+x + "," + y);
		if(m.getPiece(x, y)==null) {

			m.getSelectedPiece().setX(x);;
			m.getSelectedPiece().setY(y);
			m.updatePiece(m.getSelectedPiece(), x, y);
			System.out.println("Piece is not at: " + m.getSelectedPiece().getX() +","+m.getSelectedPiece().getY());
			m.updateMoves();
		}
		app.getPuzzleView().repaint();
		System.out.println("MOVE CONTROLLER USED");
	}
}
