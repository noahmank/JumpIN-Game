package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.JumpInGame;
import view.DirectionButton;
import view.JumpInView;

public class DirectionButtonController implements ActionListener {
	private JumpInGame game;
	private JumpInView view;
	
	public DirectionButtonController(JumpInGame game, JumpInView view) {
		this.game = game;
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(game.getPiece() != null) {
			game.setDirection(((DirectionButton) e.getSource()).getDirection());
		}
	}
}
