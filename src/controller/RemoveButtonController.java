package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JButton;

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
	public RemoveButtonController(BoardBuilder build, JButton view) {
		this.build = build;
		view.addActionListener(this);
	}

	/**
	 * deals with the action once the button is toggled
	 * @param event is the action event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton source = (JButton) event.getSource();
		int column = build.getColumn();
		int row = build.getRow();
		JumpInGame game = new JumpInGame();
		game.savePieceToMove(column, row);
		build.setSelectedPiece(game.getPiece());
		build.removePieceFromBoard();
	}
}
