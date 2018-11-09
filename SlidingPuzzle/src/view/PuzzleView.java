package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Model;

/**
 * Knows how to visually present the puzzle.
 */
public class PuzzleView extends JPanel {
	Model m;
	int offset = 10;

	public PuzzleView(Model m) {

		this.m = m;

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// have to set here SINCE not known when in constructor; this is a Java Swing
		// thing.
		int boxHeight = getHeight() / 3;
		int boxWidth = getWidth() / 3;

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 4; c++) {
				if (m.isSolved()) {
					g.setColor(Color.blue);
				} else {
					g.setColor(Color.gray);
				}
				if(m.getPiece(r, c)==null) {
					System.out.println("HELP");
				}
				g.fillRect(offset + c * m.getPiece(r, c).getWidth(), offset + r * m.getPiece(r, c).getHeight(), boxWidth - 2 * offset,
						boxHeight - 2 * offset);
				g.setColor(Color.white);


				if(m.getSelectedPiece()== m.getPiece(r, c)) {
					g.setColor(Color.white);
					g.fillRect(offset+ c*boxWidth, offset + r*boxHeight, boxWidth-2*offset, boxHeight-2*offset);

				}
				else {

				}
			}
		}

	}

}
