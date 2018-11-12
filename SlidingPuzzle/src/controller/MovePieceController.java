package controller;

import model.Model;
import view.PuzzleApp;

public class MovePieceController {
	private Model m;
	private PuzzleApp app;
	private int x, y;

	public MovePieceController(Model m, PuzzleApp app, int x, int y) {
		this.m = m;
		this.app = app;
		this.x = x;
		this.y = y;
	}

	public void move() {
		System.out.println("Attempting to move piece: " + m.getSelectedPiece());
		System.out.println("Piece at attempted destination: " + m.getOriginalPiece(x, y));
		int deltaX = x - m.getSelectedPiece().getX();
		int deltaY = y - m.getSelectedPiece().getY();
		// Moving to the right
		if (m.getSelectedPiece().getWidth() == 1 && m.getSelectedPiece().getHeight() == 1) {
			if (m.getOriginalPiece(x, y) == null) {

				m.getSelectedPiece().setX(x);
				m.getSelectedPiece().setY(y);

				m.updatePiece(m.getSelectedPiece(), x, y);

				m.updateMoves();
				app.getPuzzleView().repaint();

				System.out.println("MOVE CONTROLLER USED");
			}
		} else if (m.getSelectedPiece().getWidth() == 2 && m.getSelectedPiece().getHeight() == 2) {
			if ((m.getOriginalPiece(m.getSelectedPiece().getX(), m.getSelectedPiece().getY() + 1) == null) && (m
					.getOriginalPiece(m.getSelectedPiece().getX() + 1, m.getSelectedPiece().getHeight() + 1) == null)) {
				m.getSelectedPiece().setX(x);
				m.getSelectedPiece().setY(y);

				m.updatePiece(m.getSelectedPiece(), x, y);

				m.updateMoves();
				app.getPuzzleView().repaint();

				System.out.println("MOVE CONTROLLER USED");

			}
		}
		/*
		 * else if(m.getSelectedPiece().getWidth()==2 &&
		 * m.getSelectedPiece().getHeight()==1){
		 * if(m.getOriginalPiece(m.getSelectedPiece().getX()+1, deltaY)) }
		 *
		 * if (m.getOriginalPiece(x, y) == null) {
		 *
		 * m.getSelectedPiece().setX(x); m.getSelectedPiece().setY(y);
		 *
		 * m.updatePiece(m.getSelectedPiece(), x, y);
		 *
		 * m.updateMoves(); app.getPuzzleView().repaint();
		 *
		 * System.out.println("MOVE CONTROLLER USED");
		 *
		 * }
		 */
	}
}
