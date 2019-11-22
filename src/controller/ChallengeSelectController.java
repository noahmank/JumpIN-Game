package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.JumpInGame;
import view.ChallengeSelectPanel;

/**
 * Controller for the challenge select JComboBox
 * 
 * @author Noah Mank
 *
 */
public class ChallengeSelectController implements ActionListener {
	private JumpInGame game;
	private ChallengeSelectPanel view;

	/**
	 * Constructor for the ChallengeSelectController
	 * 
	 * @param game is the game with methods to be called when an action is performed
	 */
	public ChallengeSelectController(JumpInGame game, ChallengeSelectPanel challengeSelectPanel) {
		this.game = game;
		this.view = challengeSelectPanel;
	}

	/**
	 * Method that is called when a new item is selected in the JComboBox. Updates
	 * the challenge selected in model.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<Integer> box = (JComboBox<Integer>) e.getSource();
		int c = (int) box.getSelectedItem();
		this.game.setSelectedChallenge(c);
	}

}
