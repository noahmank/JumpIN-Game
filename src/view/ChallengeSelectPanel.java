package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ChallengeSelectController;
import model.JumpInGame;

/**
 * 
 * @author Runtime Terror
 *
 */
public class ChallengeSelectPanel extends JPanel {
	
	private JumpInGame game;
	
	/**
	 * The challenge drop down panel
	 * @param g is the JumpIn game model
	 */
	public ChallengeSelectPanel(JumpInGame g) {
		super();
		this.game = g;
		Integer[] challenges = new Integer[game.getNumChallenges()]; 
		// Initialize array with number (i + 1) at index i, up to number of challenges in game
		for(int i = 0; i < game.getNumChallenges(); i++) {
			challenges[i] = i + 1;
		}
		JComboBox<Integer> challengeList = new JComboBox<>(challenges);
		challengeList.setSelectedIndex(0);
		challengeList.addActionListener(new ChallengeSelectController(this.game));
		
		JLabel selectChallengeText = new JLabel("Select a challenge:");
		this.add(selectChallengeText, BorderLayout.CENTER);
		this.add(challengeList, BorderLayout.SOUTH);
	}
}
