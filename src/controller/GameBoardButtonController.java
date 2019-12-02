package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import model.*;

/**
 * Controller for BoardButtons
 * @author RunTime Terror
 *
 */
public class GameBoardButtonController implements ActionListener {
	
	private JumpInGame game;
	
	/**
	 * Instantiates the game board button controller
	 * @param game is the JumpIn game model
	 */
	public GameBoardButtonController(JumpInGame game) {
		this.game = game;
	}
	
	/**
	* deals with the action once the button is toggled
	* @param event is the action event
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		BoardButton button = (BoardButton) e.getSource();
		GameBoard board = game.getBoard();
		int row = button.getRow();
		int column = button.getColumn();
		game.savePieceToMove(column, row);
	}
}
