package view;

import java.awt.BorderLayout;

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
public class ChallengeSelectPanel extends JPanel implements JumpInGameListener {
	private JComboBox<Integer> challengeList;
	private JumpInGame game;

	/**
	 * The challenge drop down panel
	 * 
	 * @param g is the JumpIn game model
	 */
	public ChallengeSelectPanel(JumpInGame g) {
		super();
		this.game = g;

		Integer[] challenges = new Integer[game.getNumChallenges()];

		// Initialize array with number (i + 1) at index i, up to number of challenges
		// in game
		for (int i = 0; i < game.getNumChallenges(); i++) {
			challenges[i] = i + 1;
		}
		challengeList = new JComboBox<>(challenges);
		challengeList.setSelectedIndex(0);
		challengeList.addActionListener(new ChallengeSelectController(this.game, this));

		JLabel selectChallengeText = new JLabel("Select a challenge:");
		this.add(selectChallengeText, BorderLayout.CENTER);
		this.add(challengeList, BorderLayout.SOUTH);
		subscribeToModel();
	}

	@Override
	public void updateView() {
		if(challengeList.getItemCount() < game.getNumChallenges()) challengeList.addItem(game.getNumChallenges());
	}

	@Override
	public void subscribeToModel() {
		this.game.addView(this);	
	}
}
