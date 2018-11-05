package view;

import javax.swing.JFrame;

import model.Model;

public class Application extends JFrame {
	Model model;
	public Application(Model m) {
		super ("Puzzle Game");

		this.model = m;

		setSize(400, 400);
	}
}
