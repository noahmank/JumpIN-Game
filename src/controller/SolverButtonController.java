package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.JumpInGame;

public class SolverButtonController implements ActionListener {
	private JumpInGame game;
	
	public SolverButtonController(JumpInGame g) {
		this.game = g;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton source = (JButton) event.getSource();
		if (source.getText().equals("Solve Board")) {
			this.game.solveGame();
			source.setText("Do next move");
		}
		else if (source.getText().equals("Do next move")) {
			this.game.doNextMoveFromSolution();
		}
	}

}
