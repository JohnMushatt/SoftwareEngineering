package model;

import java.awt.Point;
import java.util.ArrayList;
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
	void setBoard(ArrayList<PuzzlePiece> puzzlePieces, int boardHeight, int boardWidth) {
		for(int i = 0; i <boardHeight;i++) {
			for(int j = 0; j<boardWidth;j++) {
				this.puzzlePieces.put(new Point(i,j), null);
			}
		}
	}
	public Model(int startConfig) {


	}

}
