package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

import model.JumpInGame;
import view.JumpInView;

public class FileMenuController implements ActionListener {
	private JumpInView view;
	private JumpInGame game;
	
	public FileMenuController(JumpInGame game, JumpInView view) {
		this.view = view;
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		if(source.getText().equals("Home")) {
			this.game.resetChallenge();
			this.view.toInstructionsFrame();
		} 
	}

}
