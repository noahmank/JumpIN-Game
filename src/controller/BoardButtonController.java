package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.MoveablePiece;
import view.BoardButton;
import model.*;
import view.*;

public class BoardButtonController implements ActionListener {
	JumpInGame game;
	JumpInView view;
	MoveablePiece piece;
	Direction direction;
	
	public BoardButtonController(JumpInGame game, JumpInView view) {
		this.game = game;
		this.view = view;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BoardButton b = (BoardButton) e.getSource();
		int row = b.getRow();
		int column = b.getColumn();
		if (game.getBoard().getHole(column, row).isOccupied() && (game.getBoard().getHole(column, row).getPiece() instanceof MoveablePiece)) {
			piece = (MoveablePiece) game.getBoard().getHole(column, row).getPiece();
		}
		if ((direction != null) && (piece != null)) {
			game.movePiece(piece, direction);
			direction = null;
		}
		
	}

}
