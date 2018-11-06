package model;

import java.awt.Point;
import java.util.HashMap;

public class Model {

	HashMap<Point,PuzzlePiece> puzzlePieces = new HashMap<Point,PuzzlePiece>();
	PuzzlePiece selectedPiece;


	public PuzzlePiece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(PuzzlePiece piece) {
		this.selectedPiece=piece;
	}

	public HashMap<Point,PuzzlePiece> getAllPieces() {
		return this.puzzlePieces;
	}
}
