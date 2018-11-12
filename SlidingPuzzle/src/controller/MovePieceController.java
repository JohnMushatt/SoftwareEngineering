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
		System.out.println("Attempting to move piece: " + m.getSelectedPiece());
		System.out.println("Piece at attempted destination: " + m.getOriginalPiece(x, y));
		if(m.getOriginalPiece(x, y)==null) {
			//System.out.println("ATTEMPTING TO MOVE PIECE AT: " +m.getSelectedPiece().getX()+"," + m.getSelectedPiece().getY()+
			//		" to "+x + "," + y);
		//	System.out.println("PIECE AT MOVE DESTINATION: "+m.getOriginalPiece(x, y));
			m.getSelectedPiece().setX(x);
			m.getSelectedPiece().setY(y);
			
			m.updatePiece(m.getSelectedPiece(), x, y);

			m.updateMoves();
			app.getPuzzleView().repaint();

			System.out.println("MOVE CONTROLLER USED");

		}
	}
}
