package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.*;

/**
 * The controller for the JumpIN game
 */
public class JumpInController implements ActionListener {

	private InstructionsFrame homeView;
	private JumpInView gameView;

	/**
	 * Constructor for the JumpInController
	 * 
	 * @param game is the JumpInGame
	 * @param homeView is the view of the game
	 */
	public JumpInController(InstructionsFrame homeView, JumpInView gameView) {
		this.homeView = homeView;
		this.gameView = gameView;
	}

	/**
	 * Deals with the actions
	 * 
	 * @param event is the action event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if ((event.getSource() instanceof JButton) && ((JButton) event.getSource()).getText().equals("Click here to Start Game")) {
			gameView.toGameFrame();
		}
	}
}
