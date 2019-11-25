package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;


import model.*;
import view.*;

/**
 * Remove button controller
 * @author Adela Tullio
 *
 */
public class RemoveButtonController implements ActionListener{
	private JumpInGame game;

	/**
	 * constructor for remove button controller
	 * @param g is the game
	 * @param view is the remove button view
	 */
	public RemoveButtonController(JumpInGame g, RemoveButton view) {
		this.game = g;
		view.subscribeToRemoveButton(this);
	}

	/**
	 * deals with the action once the button is toggled
	 * @param event is the action event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		RemoveButton source = (RemoveButton)event.getSource();
		GameBoard board = game.getBoard();
		int row = source.getRow();
		int column = source.getColumn();
		game.savePieceToMove(column, row);
		if((game.getPiece() != null) && (source.isSelected())) {
			Hole hole = board.getHole(column, row);
			Piece piece = hole.getPiece();
			hole.removePiece(piece);
		}

	}
}