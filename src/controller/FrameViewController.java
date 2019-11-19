package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import model.JumpInGame;
import view.*;

/**
 * The controller that manages which JFrame is currently shown.
 * @author Noah Mank
 */
public class FrameViewController implements ActionListener {
	private JumpInView jumpInView;
	private JumpInGame game;
	/**
	 * Constructor for the JumpInController
	 * 
	 * @param game is the JumpInGame
	 * @param homeView is the view of the game
	 */
	public FrameViewController(JumpInGame game, JumpInView gameView) {
		this.jumpInView = gameView;
		this.game = game;
	}

	/**
	 * Deals with the actions
	 * 
	 * @param event is the action event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton source = (JButton) event.getSource();
		game.startChallenge();
		if (source.getText().equals("Click here to Start Game")) {
			jumpInView.toGameFrame();
			this.game.setConsoleOutput("Challenge " + this.game.getSelectedChallenge() + ": Begun");
		}
		if (source.getText().equals("Click here to Solve Game")) {
			jumpInView.toSolverFrame();
			this.game.setConsoleOutput("Challenge " + this.game.getSelectedChallenge() + " Solver: Begun");
		}
	}
}
