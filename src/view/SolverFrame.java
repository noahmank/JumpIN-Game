package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import model.JumpInGame;

public class SolverFrame extends JFrame {

	public SolverFrame(JumpInGame game, JumpInView view) {
		
		
		
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
