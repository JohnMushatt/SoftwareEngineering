package controller;

import model.Model;
import model.PuzzlePiece;
import view.PuzzleApp;

public class SelectedPieceController {
	private Model m;
	private PuzzleApp app;
	private int x,y;
	public SelectedPieceController(Model m, PuzzleApp app, int x, int y) {
		this.m =m;
		this.app = app;
		this.x=x;
		this.y=y;
	}

	public void selectPiece() {
		for(PuzzlePiece p: m.getPieces()) {
			boolean correctPiece = false;
			if( (x>=p.getX()) && (x<= p.getX()+p.getWidth()*100)) {
				correctPiece = true;
			}
			else {
				correctPiece = false;
			}
			if( (p.getY() < y) && (p.getY() + p.getHeight()*100-10) >y) {
				correctPiece = true;
			}
			else {
				correctPiece =false;
			}

			if(correctPiece) {
				m.setSelectedPiece(p);
			}
		}
		app.getPuzzleView().repaint();
		System.out.println("SELECT PIECE USED\t CURRENT SELECTED PIECE: " + m.getSelectedPiece());
	}
}
