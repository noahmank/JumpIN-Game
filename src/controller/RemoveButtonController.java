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
	private JumpInGame game;
	private BoardBuilder build;

	/**
	 * constructor for remove button controller
	 * @param g is the game
	 * @param view is the remove button view
	 */
	public RemoveButtonController(JumpInGame game, JButton view) {
		this.game = game;
		this.build = game.getBuilder();
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
		build.removePieceAt(column, row);
		game.notifyViews();
	}
}
