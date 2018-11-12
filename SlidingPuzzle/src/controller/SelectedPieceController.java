package controller;

import java.awt.Rectangle;

import model.Model;
import model.PuzzlePiece;
import view.PuzzleApp;

public class SelectedPieceController {
	private Model m;
	private PuzzleApp app;

	public SelectedPieceController(Model m, PuzzleApp app) {
		this.m =m;
		this.app = app;

	}

	public void selectPiece(int x, int y) {
		System.out.println("X: " +x + "\tY: " + y);
		for(PuzzlePiece p: m.getPieces()) {


			Rectangle rect = new Rectangle(p.getScreenX(), p.getScreenY(), p.getWidth()*100-10, p.getHeight()*100-10);

			if(rect.contains(x, y)) {

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
