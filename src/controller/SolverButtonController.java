package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.JumpInGame;

/**
 * Controller for SolverButton
 * @author RunTime Terror
 *
 */
public class SolverButtonController implements ActionListener {
	
	private JumpInGame game;
	
	/**
	 * Instantiates the solver button controller
	 * @param g is the JumpIn game model
	 */
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
