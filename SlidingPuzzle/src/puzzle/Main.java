package puzzle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import controller.ExitApplicationController;
import model.Model;
import view.PuzzleApp;
public class Main {
	public static void main(String[] args) {
		Model m = new Model();
		final PuzzleApp app = new PuzzleApp(m);
		
		app.addWindowListener (new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				new ExitApplicationController(app).process();
			}

		});
		app.setVisible(true);


	}
}
