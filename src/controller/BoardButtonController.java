package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import model.*;

public class BoardButtonController implements ActionListener {
	private JumpInGame game;
	
	public BoardButtonController(JumpInGame game) {
		this.game = game;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BoardButton b = (BoardButton) e.getSource();
		int row = b.getRow();
		int column = b.getColumn();
		if (game.getBoard().getHole(column, row).isOccupied() && (game.getBoard().getHole(column, row).getPiece() instanceof MoveablePiece)) {
			game.setPiece((MoveablePiece) game.getBoard().getHole(column, row).getPiece());
		}
		// Might need to be JumpInGame's responsibility
		if ((game.getDirection() != null) && (game.getPiece() != null)) {
			game.movePiece(game.getPiece(), game.getDirection());
			game.setDirection(null);
		}
	}

}
