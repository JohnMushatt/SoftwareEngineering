package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import model.Model;
import model.PuzzlePiece;

/**
 * Knows how to visually present the puzzle.
 */
public class PuzzleView extends JPanel {
	Model m;
	int offset = 5;
	Image offScreenImage = null;
	Graphics offScreenGraphics = null;
	Font largeFont = new Font("Arial",Font.PLAIN,72);
	public PuzzleView(Model m) {

		this.m = m;
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/*
		if(offScreenImage ==null) {
			Dimension s = getPreferredSize();
			offScreenImage = this.createImage(s.width,s.height);
			if(offScreenImage==null) {
				return;
			}
			offScreenGraphics = offScreenImage.getGraphics();
			redraw();
		}
		g.drawImage(offScreenImage, 0, 0, this);

		if(m == null)
			return;
		if(m)
			*/
		int boxWidth = 100;
		int boxHeight = 100;
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 4; c++) {
				if(m.isSolved()) {
					g.setColor(Color.blue);
				}
				PuzzlePiece value = m.getOriginalPiece(c, r);
				if (value != null) {
					if (value.getWidth() == 2 && value.getHeight() == 2) {
						g.setColor(Color.red);
					} else {
						g.setColor(Color.white);
					}

					g.fillRect(offset + c * boxWidth, offset  + r * boxHeight,
							(boxWidth *value.getWidth()) - 2 * offset, (boxHeight *value.getHeight()) - 2 * offset);
					value.setScreenX(offset + c * boxWidth);
					value.setScreenY(offset  + r * boxHeight);
					//System.out.println("Piece: " +value.getWidth() + "x" + value.getHeight()+"\tXVALUE: " + value.getScreenX() + "\tYVALUE: " + value.getScreenY());
					//if(m.getSelectedPiece()==value) {
						//g.drawRect(offset+c*boxWidth, offset +r*boxHeight, (boxWidth *value.getWidth()) - 2 * offset, height);
					//}
					// if (value==m.getSelectedPiece() ||true) {
					// g.setColor(Color.black);
					// g.fillRect(offset+ c*boxWidth, offset + r*boxHeight, boxWidth-2*offset,
					// boxHeight-2*offset);
					// } else {
					// g.drawString("" + value, c*boxWidth + boxWidth/2, r*boxHeight + boxHeight/2);
					// }

				}
			}
		}

	}
	public void redraw() {
		for(PuzzlePiece p: m.getPieces()) {
			if(p.getWidth()==2 &&p.getHeight()==2) {

			}
		}
	}
	public void refresh() {
		//redraw();
		repaint();
	}

}
