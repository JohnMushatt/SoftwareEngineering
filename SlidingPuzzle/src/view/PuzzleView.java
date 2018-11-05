package view;

import java.awt.Graphics;

import javax.swing.JPanel;



public class PuzzleView extends JPanel {
	public PuzzleView() {

	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fillRect(0, 0,  400, 500);
	}
}
