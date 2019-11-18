package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.*;

/**
 * The controller for the JumpIN game
 */
public class FrameViewController implements ActionListener {
	private JumpInView jumpInView;

	/**
	 * Constructor for the JumpInController
	 * 
	 * @param game is the JumpInGame
	 * @param homeView is the view of the game
	 */
	public FrameViewController(JumpInView gameView) {
		this.jumpInView = gameView;
	}

	/**
	 * Deals with the actions
	 * 
	 * @param event is the action event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton source = (JButton) event.getSource();
		if (source.getText().equals("Click here to Start Game")) {
			jumpInView.toGameFrame();
		}
		if (source.getText().equals("Click here to Solve Game")) {
			jumpInView.toSolverFrame();
		}
	}
}
