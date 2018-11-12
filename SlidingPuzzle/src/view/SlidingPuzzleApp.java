package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import model.Model;

public class SlidingPuzzleApp extends JFrame {

	private JPanel contentPane;
	Model m;
	PuzzleView puzzleView;

	public PuzzleView getPuzzleView() {
		return puzzleView;
	}
	/**
	 * Create the frame.
	 */
	public SlidingPuzzleApp(Model m) {
		this.m = m;
		setTitle("SlidingPuzzleApp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200  , 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		puzzleView = new PuzzleView(m);
		puzzleView.setBackground(Color.GRAY);
		puzzleView.setSize(new Dimension(700, 600));

		JButton btnReset = new JButton("Reset");

		JButton button = new JButton("^");

		JButton button_1 = new JButton("<");

		JButton button_2 = new JButton(">");

		JButton btnV = new JButton("V");

		JLabel lblMoves = new JLabel("Moves:");

		JLabel label = new JLabel("12");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(puzzleView, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(38)
										.addComponent(button)
										.addGap(36))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(button_1)
										.addGap(33)
										.addComponent(button_2)))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 39, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnReset)
										.addComponent(btnV))
									.addGap(15))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblMoves)
							.addGap(18)
							.addComponent(label)))
					.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(puzzleView, GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves)
								.addComponent(label))
							.addGap(189)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(button)
								.addPreferredGap(ComponentPlacement.UNRELATED))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(button_2)
								.addComponent(button_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnV)
							.addPreferredGap(ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
							.addComponent(btnReset)))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
