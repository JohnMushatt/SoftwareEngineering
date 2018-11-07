package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

public class Model {
	HashMap<Point, PuzzlePiece> puzzlePieces = new HashMap<Point, PuzzlePiece>();
	PuzzlePiece selectedPiece;
	public final int BOARD_HEIGHT =5;
	public final int BOARD_WIDTH = 4;
	public PuzzlePiece getSelectedPiece() {
		return selectedPiece;
	}
	void displayBoardBasic() {
		for(int i =0;i < BOARD_HEIGHT;i++) {
			for(int j=0; j<BOARD_WIDTH;j++) {
				PuzzlePiece temp = puzzlePieces.get(new Point(j,i));
				if(temp==null) {
					System.out.print(" ");
				}
				else {
					System.out.print("2");
				}
			}
			System.out.println();

		}
	}
	public void setSelectedPiece(PuzzlePiece piece) {
		this.selectedPiece = piece;
	}

	/**
	 * Retreive all the puzzlepieces in the form of a hasmap with key:Point(x,y) value:PuzzlePiece
	 * @return Hashmap containing Point keys and PuzzlePiece values
	 */
	public HashMap<Point, PuzzlePiece> getAllPieces() {
		return this.puzzlePieces;
	}

	/**
	 * Initializes the board with Point objects and null PuzzlePiece objects
	 *
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
					for (int j = 1; j < temp.getHeight(); j++) {

						puzzlePieces.put(new Point(temp.getX(), temp.getY() + j), temp);
					}
				}
				//If width is greater than 1, start filling in the rest
				if(temp.getWidth()>1) {

					//Fill in the appropriate amount of extra pieces by adding references to the parent piece
					for(int j = 1; j<temp.getWidth();j++) {
						puzzlePieces.put(new Point(temp.getX()+j,temp.getY()), temp);
					}
				}

				if(temp.getHeight()==2 && temp.getWidth()==2) {
					puzzlePieces.put(new Point(temp.getX()+1,temp.getY()+1), temp);
				}
			}

		}
		/*
		//Fill in rest of board with null values to complete the board
		for(int i =0; i <BOARD_HEIGHT;i++) {
			for(int j = 0; j < BOARD_WIDTH;j++) {
				if(puzzlePieces.get(new Point(i,j))==null) {
					puzzlePieces.put(new Point(i,j), null);
				}
			}
		}
		*/
	}

	public Model() {
		initialzieBoard(5, 4);
		displayBoardBasic();

	}

}
