/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.BoardBuilder;
import model.GameBoard;
import model.JumpInGame;

/**
 * @author Aubin
 *
 */
public class AddButtonController implements ActionListener{
	
	private JumpInGame game;
	private JButton addPiece;
	
	public AddButtonController(JumpInGame game, JButton addPiece) {
		this.game = game;
		this.addPiece = addPiece;
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton addButton = (JButton) event.getSource();
		BoardBuilder bBuilder = this.game.getBuilder();
		bBuilder.addPieceToBoard();
	}
	

}
