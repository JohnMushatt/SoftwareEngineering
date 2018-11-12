package controller;

import model.Model;
import model.PuzzlePiece;
import view.PuzzleApp;

public class SelectedPieceController {
	private Model m;
	private PuzzleApp app;
	private int x,y;
	public SelectedPieceController(Model m, PuzzleApp app,int x, int y) {
		this.m =m;
		this.app = app;
		this.x=x;
		this.y=y;
	}

	public void selectPiece() {
		System.out.println("X: " +x + " Y: " + y);
		for(PuzzlePiece p: m.getPieces()) {

			if(p.getRectangle().contains(x, y)) {
				m.setSelectedPiece(p);
			}
			//boolean correctPiece = true;
			/*
			if((x<p.getX()) || (x> p.getX()+p.getWidth()*100 - 10)) {
				correctPiece = false;
			}
			if( (y<p.getY()) || (y>p.getY()+p.getWidth()*100 -10)) {
				correctPiece = false;
			}
			*/
			//if(correctPiece) {
				//m.setSelectedPiece(p);
			//}
		}
		System.out.println("SELECT PIECE USED\t CURRENT SELECTED PIECE: " + m.getSelectedPiece());

		app.getPuzzleView().repaint();
	}
}
