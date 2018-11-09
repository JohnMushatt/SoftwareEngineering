package model;

import java.util.ArrayList;

public class Model {
	// HashMap<Point, PuzzlePiece> puzzlePieces = new HashMap<Point, PuzzlePiece>();
	ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<PuzzlePiece>();
	PuzzlePiece selectedPiece;
	PuzzlePiece keyPiece;
	public final int BOARD_HEIGHT = 5;
	public final int BOARD_WIDTH = 4;

	public PuzzlePiece getSelectedPiece() {
		return selectedPiece;
	}

	public PuzzlePiece getPiece(int x, int y) {
		//Check list of puzzle pieces
		for (int i = 0; i < puzzlePieces.size(); i++) {
			//Get current piece
			PuzzlePiece current = puzzlePieces.get(i);

			//If the current piece has coordinates
			if ((current.getX() == x) && (current.getY() == y)) {
				return current;
			}
		}

		return null;

	}

	public boolean isSolved() {
		if (keyPiece != null) {
			if (keyPiece.getX() == 1 && keyPiece.getY() == 5) {
				return true;
			}
		}

		return false;
	}

	public void setSelectedPiece(PuzzlePiece piece) {
		this.selectedPiece = piece;
	}

	/*
	 * public HashMap<Point, PuzzlePiece> getAllPieces() { return this.puzzlePieces;
	 * }
	 *
	 */
	/**
	 * Initializes the board with Point objects and null PuzzlePiece objects
	 *
	 * @param boardHeight
	 *            Y Dimension for the board
	 * @param boardWidth
	 *            X Dimension for the board
	 */
	void initialzieBoard() {

		PuzzlePiece colOne = new PuzzlePiece(0, 0, 1, 2);
		PuzzlePiece colTwo = new PuzzlePiece(3, 0, 1, 2);
		PuzzlePiece colThree = new PuzzlePiece(0, 2, 1, 2);
		PuzzlePiece colFour = new PuzzlePiece(3, 2, 1, 2);

		PuzzlePiece rowOne = new PuzzlePiece(1, 2, 2, 1);

		PuzzlePiece boxOne = new PuzzlePiece(1, 0, 2, 2);

		PuzzlePiece squareOne = new PuzzlePiece(1, 3, 1, 1);
		PuzzlePiece squareTwo = new PuzzlePiece(2, 3, 1, 1);
		PuzzlePiece squareThree = new PuzzlePiece(0, 4, 1, 1);
		PuzzlePiece squareFour = new PuzzlePiece(3, 4, 1, 1);

		puzzlePieces.add(colOne);
		puzzlePieces.add(colTwo);
		puzzlePieces.add(colThree);
		puzzlePieces.add(colFour);
		puzzlePieces.add(rowOne);
		puzzlePieces.add(boxOne);
		puzzlePieces.add(squareOne);
		puzzlePieces.add(squareTwo);
		puzzlePieces.add(squareThree);
		puzzlePieces.add(squareFour);

	}

	public Model() {
		initialzieBoard();
	}

}
