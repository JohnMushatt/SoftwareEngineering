package controller;

import model.Model;
import model.PuzzlePiece;
import view.PuzzleApp;

public class MovePieceController {
	private Model m;
	private PuzzleApp app;
	private int x, y;
	private int deltaX, deltaY;

	public MovePieceController(Model m, PuzzleApp app, int x, int y) {
		this.m = m;
		this.app = app;
		this.x = x;
		this.y = y;
		deltaX = x - m.getSelectedPiece().getX();
		deltaY = y - m.getSelectedPiece().getY();
	}

	public boolean test2x2Move() {
		// Piece at the new move
		PuzzlePiece move = m.getOriginalPiece(m.getSelectedPiece().getX() + x, m.getSelectedPiece().getHeight() + y);
		if (move == null) {
			return true;
		} else {
			return false;
		}
	}

	public void move() {
		System.out.println("Attempting to move piece: " + m.getSelectedPiece());
		System.out.println("Piece at attempted destination: " + m.getOriginalPiece(x, y));
		PuzzlePiece piece = m.getSelectedPiece();
		// if 2x2
		if ((piece.getWidth() == 2 && piece.getHeight() == 2)) {
			// if moving down or up
			if ((y > 0 && y < 5) && deltaY != 0) {
				// If we are moving down
				if (deltaY == 1) {
					if (m.getOriginalPiece(x, y + 1) == null && m.getOriginalPiece(x + 1, y + 1) == null) {
						m.getSelectedPiece().setX(x);
						m.getSelectedPiece().setY(y);

						m.updatePiece(m.getSelectedPiece(), x, y);

						m.updateMoves();
						app.getPuzzleView().repaint();

						System.out.println("MOVE CONTROLLER USED");
					}
				} else if (deltaY == -1) {
					if (m.getOriginalPiece(x, y - 1) == null && m.getOriginalPiece(x + 1, y - 1) == null) {
						m.getSelectedPiece().setX(x);
						m.getSelectedPiece().setY(y);

						m.updatePiece(m.getSelectedPiece(), x, y);

						m.updateMoves();
						app.getPuzzleView().repaint();

						System.out.println("MOVE CONTROLLER USED");
					}
				}
			}
			// To the right or left
			else if ((x > 0 && x < 4) && deltaX != 0) {
				if (deltaX == 1) {
					if (m.getOriginalPiece(x + 1, y) == null && m.getOriginalPiece(x + 1, y + 1) == null) {
						m.getSelectedPiece().setX(x);
						m.getSelectedPiece().setY(y);

						m.updatePiece(m.getSelectedPiece(), x, y);

						m.updateMoves();
						app.getPuzzleView().repaint();

						System.out.println("MOVE CONTROLLER USED");
					}
				} else if (deltaX == -1) {
					if (m.getOriginalPiece(x - 1, y) == null && m.getOriginalPiece(x + 1, y + 1) == null) {
						m.getSelectedPiece().setX(x);
						m.getSelectedPiece().setY(y);

						m.updatePiece(m.getSelectedPiece(), x, y);

						m.updateMoves();
						app.getPuzzleView().repaint();

						System.out.println("MOVE CONTROLLER USED");
					}
				}
			}

			// If 1x2
			else if (piece.getHeight() == 1 && piece.getWidth() == 2) {
				// if moving up or down
				if (y > 0 && y < 5 && deltaY != 0) {
					if (deltaY == 1) {
						if (m.getOriginalPiece(x, y + 1) == null && m.getOriginalPiece(x + 1, y + 1) == null) {
							m.getSelectedPiece().setX(x);
							m.getSelectedPiece().setY(y);

							m.updatePiece(m.getSelectedPiece(), x, y);

							m.updateMoves();
							app.getPuzzleView().repaint();

							System.out.println("MOVE CONTROLLER USED");
						}
					} else if (deltaY == -1) {
						if (m.getOriginalPiece(x, y - 1) == null && m.getOriginalPiece(x + 1, y - 1) == null) {
							m.getSelectedPiece().setX(x);
							m.getSelectedPiece().setY(y);

							m.updatePiece(m.getSelectedPiece(), x, y);

							m.updateMoves();
							app.getPuzzleView().repaint();

							System.out.println("MOVE CONTROLLER USED");
						}
					}
				} else if (x > 0 && x < 4 && deltaX != 0) {
					if (deltaX == 1) {
						if (m.getOriginalPiece(x + 1, y) == null) {
							m.getSelectedPiece().setX(x);
							m.getSelectedPiece().setY(y);

							m.updatePiece(m.getSelectedPiece(), x, y);

							m.updateMoves();
							app.getPuzzleView().repaint();

							System.out.println("MOVE CONTROLLER USED");
						}
					} else if (deltaX == -1) {
						if (m.getOriginalPiece(x - 1, y) == null) {
							m.getSelectedPiece().setX(x);
							m.getSelectedPiece().setY(y);

							m.updatePiece(m.getSelectedPiece(), x, y);

							m.updateMoves();
							app.getPuzzleView().repaint();

							System.out.println("MOVE CONTROLLER USED");
						}
					}
				}
			}
			//2x1
			else if(piece.getWidth()==1 && piece.getHeight()==2) {
				//Up and down
				if(y>0 && y<5 &&deltaY!=0) {
					//Down
					if(deltaY==1) {
						if (m.getOriginalPiece(x, y + 1) == null) {
							m.getSelectedPiece().setX(x);
							m.getSelectedPiece().setY(y);

							m.updatePiece(m.getSelectedPiece(), x, y);

							m.updateMoves();
							app.getPuzzleView().repaint();

							System.out.println("MOVE CONTROLLER USED");
						}
					}
					else if(deltaY==-1) {
						if (m.getOriginalPiece(x, y - 1) == null) {
							m.getSelectedPiece().setX(x);
							m.getSelectedPiece().setY(y);

							m.updatePiece(m.getSelectedPiece(), x, y);

							m.updateMoves();
							app.getPuzzleView().repaint();

							System.out.println("MOVE CONTROLLER USED");
						}
					}
				}
				else if(x>0 &&x<4 && deltaX!=0) {
					if(deltaX==1) {
						if (m.getOriginalPiece(x, y) == null && m.getOriginalPiece(x, y + 1) == null) {
							m.getSelectedPiece().setX(x);
							m.getSelectedPiece().setY(y);

							m.updatePiece(m.getSelectedPiece(), x, y);

							m.updateMoves();
							app.getPuzzleView().repaint();

							System.out.println("MOVE CONTROLLER USED");
						}
					}
					else if(deltaX==-1) {
						if (m.getOriginalPiece(x, y) == null && m.getOriginalPiece(x, y + 1) == null) {
							m.getSelectedPiece().setX(x);
							m.getSelectedPiece().setY(y);

							m.updatePiece(m.getSelectedPiece(), x, y);

							m.updateMoves();
							app.getPuzzleView().repaint();

							System.out.println("MOVE CONTROLLER USED");
						}
					}
				}
			}
			else if(piece.getWidth()==1 && piece.getHeight()==1) {
				if(y>0 && y<5 &&deltaY!=0) {
					if(deltaY==1) {
						if (m.getOriginalPiece(x, y)==null) {
							m.getSelectedPiece().setX(x);
							m.getSelectedPiece().setY(y);

							m.updatePiece(m.getSelectedPiece(), x, y);

							m.updateMoves();
							app.getPuzzleView().repaint();

							System.out.println("MOVE CONTROLLER USED");
						}
					}
				}
			}
 		}
	}
}
