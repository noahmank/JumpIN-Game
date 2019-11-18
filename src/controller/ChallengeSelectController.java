package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.JumpInGame;

public class ChallengeSelectController implements ActionListener {
	private JumpInGame game;
	
	public ChallengeSelectController(JumpInGame game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<Integer> box = (JComboBox<Integer>) e.getSource();
		int c = (int) box.getSelectedItem();
		this.game.setSelectedChallenge(c);
	}

}
