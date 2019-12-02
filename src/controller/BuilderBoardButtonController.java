package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.BoardButton;
/**
* Builder Board Button Controller
*
*/
public class BuilderBoardButtonController implements ActionListener {

	private JumpInGame game;
	
	/**
	 * Instantiates the game board button controller
	 * @param game is the JumpIn game model
	 */
	public BuilderBoardButtonController(JumpInGame game) {
		this.game = game;
	}
	
	/**
	* Deals with the event that happens when the button is pressed
	* @param e is the action event 
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		BoardButton button = (BoardButton) e.getSource();
		BoardBuilder builder = game.getBuilder();
		int row = button.getRow();
		int column = button.getColumn();
		builder.setColumn(column);
		builder.setRow(row);	
	}
}
