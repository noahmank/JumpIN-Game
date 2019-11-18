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
