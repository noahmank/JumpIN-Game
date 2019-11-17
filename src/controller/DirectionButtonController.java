package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

public class DirectionButtonController implements ActionListener {
	private JumpInGame game;
	
	public DirectionButtonController(JumpInGame game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(game.getPiece() != null) {
			game.setDirection(((DirectionButton) e.getSource()).getDirection());
		}
		// Might need to be JumpInGame's responsibility
		if ((game.getDirection() != null) && (game.getPiece() != null)) {
			game.movePiece(game.getPiece(), game.getDirection());
			game.setDirection(null);
		}
	}
}
