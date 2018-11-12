package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Model;
import model.PuzzlePiece;

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
		int boxHeight = getHeight() / 5;
		int boxWidth = getWidth() / 4;
		int count = 0;
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 4; c++) {
				int width = boxWidth - 2 * offset;
				int height = boxHeight - 2 * offset;
				PuzzlePiece current = m.getOriginalPiece(c,r);

				if (current != null) {
					if (current.getHeight() > 1) {
						width = width*2;
					}
					if (current.getHeight() > 1) {
						height = height*2;
					}
					g.fillRect(offset + 2*c, offset + 2* r, width*10, height*10);
					if (current.getHeight() == 2 && current.getWidth() == 2) {
						System.out.println(current);
						g.setColor(Color.red);
						System.out.println("2x2 is now red");
					} else {

						g.setColor(Color.white);
					}
				}
			}
		}
	}

}
