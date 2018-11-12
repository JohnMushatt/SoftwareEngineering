package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExitApplicationController {
	JFrame app;

	public ExitApplicationController(JFrame app) {
		this.app = app;
	}

	public void process() {
		int c = JOptionPane.showConfirmDialog (app, "Do you wish to exit Application?");

		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}
}
