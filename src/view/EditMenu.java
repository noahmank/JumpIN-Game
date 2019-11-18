package view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controller.EditMenuController;
import model.JumpInGame;

/**
 * 
 * @author RunTime Terror
 *
 */
public class EditMenu extends JMenu implements JumpInGameListener {
	
	EditMenuController controller;
	JumpInGame game;
	
	/**
	 * Creating an 'Edit' menu to include 'undo' and 'redo'
	 * @param game
	 */
	public EditMenu(JumpInGame game) {
		super("Edit");
		this.game = game;
		this.controller = new EditMenuController(game);
		
		JMenuItem item;
		item = new JMenuItem("Undo");
        item.addActionListener(controller);
        this.add(item);
        
        item = new JMenuItem("Redo");
        item.addActionListener(controller);
        this.add(item);
	}
	
	public void updateView() {
		
	}
	
	/**
	 * Subscribes the 'Edit' menu to the JumpIn game model
	 */
	public void subscribeToModel() {
		this.game.addView(this);
	}
}
