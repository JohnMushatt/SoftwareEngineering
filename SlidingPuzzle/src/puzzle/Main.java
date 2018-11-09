package puzzle;
import model.Model;
import view.SlidingPuzzleApp;
public class Main {
	public static void main(String[] args) {
		Model m = new Model();
		SlidingPuzzleApp app = new SlidingPuzzleApp(m);

		app.setVisible(true);


	}
}
