package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import controller.MovePieceController;
import controller.ResetPuzzleController;
import controller.SelectedPieceController;
import model.Model;

public class PuzzleApp extends JFrame {

	private JPanel contentPane;
	private Model m;
	private PuzzleView panel_1;

	/**
	 * Create the frame.
	 */
	public PuzzleView getPuzzleView() {
		return panel_1;
	}

	public PuzzleApp(Model m) {
		this.m=m;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton button = new JButton(">");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(m,PuzzleApp.this,m.getSelectedPiece().getX()+1,m.getSelectedPiece().getY()).move();
			}
		});
		JButton button_1 = new JButton("<");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(m,PuzzleApp.this,m.getSelectedPiece().getX()-1,m.getSelectedPiece().getY()).move();
			}
		});
		JButton button_2 = new JButton("^");
		button_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(m,PuzzleApp.this,m.getSelectedPiece().getX(),m.getSelectedPiece().getY()-1).move();
			}
		});
		JButton btnV = new JButton("v");
		btnV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MovePieceController(m,PuzzleApp.this,m.getSelectedPiece().getX(),m.getSelectedPiece().getY()+1).move();
			}
		});
		panel_1 = new PuzzleView(m);
		panel_1.setBackground(Color.gray);
		panel_1.setSize(new Dimension(500,500));
		/*
		panel_1.addMouseListener(new MouseAdapter () {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e)) {
					new MovePieceController(m,PuzzleApp.this,e.getX(),e.getY()).move();
				}
			}
		});
		*/
		JButton btnReset = new JButton("Reset");
		JLabel lblMoves = new JLabel("Moves:");

		JLabel label = new JLabel("" +m.getMoveCount());
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new ResetPuzzleController(PuzzleApp.this,m).reset();
			}
		});

		panel_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e)) {
					new SelectedPieceController(m,PuzzleApp.this).selectPiece(e.getX(),e.getY());
				}
			}
		});

		JLabel lblMoves_1 = new JLabel("Moves:");

		JLabel lblMgetmovecount = new JLabel(" " + 0);
		lblMgetmovecount.setText(" " +m.getMoveCount());
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(button)
									.addContainerGap())
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button_2)
									.addGap(36))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnReset)
										.addComponent(btnV))
									.addGap(37))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(lblMoves_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblMgetmovecount)
							.addGap(238))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblMoves_1)
								.addComponent(lblMgetmovecount))
							.addGap(49)
							.addComponent(button_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(button)
								.addComponent(button_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnV)
							.addGap(254)
							.addComponent(btnReset))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(233, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
