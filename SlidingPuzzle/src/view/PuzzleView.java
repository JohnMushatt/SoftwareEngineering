package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import model.Model;



public class PuzzleView extends JPanel {
	Model m;
	int offset = 10;

	int boxHeight;
	int boxWidth;
	public PuzzleView(Model m) {

		this.m = m;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);


		boxHeight = getHeight() /3;
		boxWidth = getWidth()/3;


		for(int r = 0; r< 5;r++) {
			for(int c = 0; c<4; c++) {
				if(m.isSolved()) {
					g.setColor(Color.YELLOW);
				}
				else {
					g.setColor(Color.white);
				}

				g.fillRect(offset + c*boxWidth, offset + r*boxHeight,
						boxWidth-2*offset, boxHeight-2*offset);
				g.setColor(Color.white);

				int value = m.getPiece(r,c);
			}
		}
	}
}
