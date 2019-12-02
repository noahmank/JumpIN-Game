package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import model.*;

/**
 * Controller for the EditMenu
 * @author RunTime Terror
 *
 */
public class EditMenuController implements ActionListener {
	private JumpInGame game;
	
	/**
	 * Instantiates the 'Edit' menu controller
	 * @param game is the JumpIn game Model
	 */
	public EditMenuController(JumpInGame game) {
		this.game = game;
	}
	
	/**
	* Method that deals with the action performed when the button is pressed
	* @param e is the action event the button that was pressed
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		if(source.getText().equals("Undo")) {
			game.undoMoveAction();
		} 
		else if(source.getText().equals("Redo")) {
			game.redoMoveAction();
		}
	}
}
