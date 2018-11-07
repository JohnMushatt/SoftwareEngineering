package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	HashMap<Point, PuzzlePiece> puzzlePieces = new HashMap<Point, PuzzlePiece>();
	PuzzlePiece selectedPiece;

	public PuzzlePiece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(PuzzlePiece piece) {
		this.selectedPiece = piece;
	}

	public HashMap<Point, PuzzlePiece> getAllPieces() {
		return this.puzzlePieces;
	}

	/**
	 * Initializes the board with Point objects and null PuzzlePiece objects
	 *
	 * @param puzzlePieces
	 *            Arraylist of pieces to add to the board
	 * @param boardHeight
	 *            Y Dimension for the board
	 * @param boardWidth
	 *            X Dimension for the board
	 */
	void initialzieBoard(int boardHeight, int boardWidth) {

		ArrayList<PuzzlePiece> subPieces = new ArrayList<PuzzlePiece>();

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

		subPieces.add(colOne);
		subPieces.add(colTwo);
		subPieces.add(colThree);
		subPieces.add(colFour);
		subPieces.add(rowOne);
		subPieces.add(boxOne);
		subPieces.add(squareOne);
		subPieces.add(squareTwo);
		subPieces.add(squareThree);
		subPieces.add(squareFour);

		// Loop through starting config
		for (int i = 0; i < subPieces.size(); i++) {

			// if there is a piece
			if (subPieces.get(i) != null) {

				PuzzlePiece temp = subPieces.get(i);

				// add to game board with piece's initial starting position
				puzzlePieces.put(new Point(temp.getX(), temp.getY()), temp);
				//If this piece is not 1x1
				if (temp.getHeight() > 1) {

					//Loop through, filling correct adjacent spots with reference to parent piece
					for (int j = 0; j < temp.getHeight(); j++) {

						puzzlePieces.put(new Point(temp.getX(), temp.getY() + j), temp);
					}
				}
				if(temp.getWidth()>1) {

					for(int j = 0; j<temp.getWidth();j++) {
						puzzlePieces.put(new Point(temp.getX()+j,temp.getY()), temp);
					}
				}
			}

		}
	}

	public Model() {
		initialzieBoard(5, 4);

	}

}
