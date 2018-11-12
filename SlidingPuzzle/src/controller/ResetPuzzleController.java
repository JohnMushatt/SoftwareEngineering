package controller;

import model.Model;
import model.PuzzlePiece;
import view.PuzzleApp;

public class ResetPuzzleController {
	private Model m;
	private PuzzleApp app;
	
	public ResetPuzzleController(PuzzleApp app, Model m) {
		this.m=m;
		this.app=app;
	}
	
	public void reset() {
		for(PuzzlePiece p: m.getPieces()) {
			p.setX(p.getOriginalX());
			p.setY(p.getOriginalY());
		}
		app.getPuzzleView().refresh();
		System.out.println("RESET USED");
	}
}
