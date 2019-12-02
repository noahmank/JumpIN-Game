/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.*;

/**
 * @author Aubin
 *
 */
public class AddButtonController implements ActionListener{
	private JumpInGame game;
	private BoardBuilder builder;
	
	public AddButtonController(JumpInGame game, JButton view) {
		this.game = game;
		this.builder = game.getBuilder();
		view.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		builder.constructSelectedPiece();
		builder.addPieceToBoard();
		game.notifyViews();
	}
	

}
