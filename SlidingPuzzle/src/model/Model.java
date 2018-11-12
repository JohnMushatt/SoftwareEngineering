package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	HashMap<Point, PuzzlePiece> board = new HashMap<Point, PuzzlePiece>();
	ArrayList<PuzzlePiece> puzzlePieces = new ArrayList<PuzzlePiece>();
	PuzzlePiece selectedPiece;
	PuzzlePiece keyPiece;
	public final int BOARD_HEIGHT = 5;
	public final int BOARD_WIDTH = 4;

	public PuzzlePiece getSelectedPiece() {
		return selectedPiece;
	}

	public PuzzlePiece getPiece(int x, int y) {

		return this.board.get(new Point(y,x));
	}
	public PuzzlePiece getOriginalPiece(int x, int y) {
		for(int i = 0; i < puzzlePieces.size();i++) {
			PuzzlePiece current = puzzlePieces.get(i);
			if(current.getX()==x && current.getY()==y) {
				return current;
			}
		}
		return null;
	}
	public void updatePiece(PuzzlePiece piece, int x, int y) {
		
	}
	public ArrayList<PuzzlePiece> getPieces() {
		return this.puzzlePieces;
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
		// Loop throught board
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 4; c++) {

				// Get the current piece
				PuzzlePiece currentPiece = getOriginalPiece(c,r);
				// If we are currently on a piece's origin coordinate
				if ((currentPiece!=null) && (currentPiece.getX() == c) && (currentPiece.getY() == r)) {
					board.put(new Point(r, c), currentPiece);

					// Check if piece is at least 2xn
					if (currentPiece.getHeight() > 1) {
						board.put(new Point(r +1, c), currentPiece);

					}
					// Check if piece is at least nx2
					if (currentPiece.getWidth() > 1) {
						board.put(new Point(r, c + 1), currentPiece);
					}
					// Check if piece is 2x2
					if (currentPiece.getHeight() > 1 && currentPiece.getWidth() > 1) {
						board.put(new Point(r + 1, c + 1), currentPiece);
					}

				} else {
					board.put(new Point(r, c), null);
				}

			}
		}

	}

	public Model() {
		initialzieBoard();
	}

}
