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
	private BoardBuilder build;

	/**
	 * constructor for remove button controller
	 * @param g is the game
	 * @param view is the remove button view
	 */
	public RemoveButtonController(BoardBuilder build, RemoveButton view) {
		this.build = build;
		view.subscribeToRemoveButton(this);
	}

	/**
	 * deals with the action once the button is toggled
	 * @param event is the action event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		RemoveButton source = (RemoveButton)event.getSource();
		int column = build.getColumn();
		int row = build.getRow();
		JumpInGame game = new JumpInGame();
		game.savePieceToMove(column, row);
		build.setSelectedPiece(game.getPiece());
		if(source.isSelected()) {
			build.removePieceFromBoard();
		}

	}
}
