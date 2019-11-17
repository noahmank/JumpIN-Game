package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.JumpInGame;
import view.JumpInView;

public class HomeMenuButtonController implements ActionListener {
	JumpInGame game;
	JumpInView view;
	
	public HomeMenuButtonController(JumpInGame game, JumpInView view) {
		this.game = game;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		if(source.getText().equals("Home")) {
			this.view.ToGameMenu(); // Needs to change when JumpInView is fully split up
		} 
	}

}
