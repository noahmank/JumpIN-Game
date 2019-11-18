package view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controller.FileMenuController;
import model.JumpInGame;

/**
 * 
 * @author RunTime Terror
 *
 */
public class FileMenu extends JMenu implements JumpInGameListener{
	FileMenuController controller;
	JumpInView view;
	JumpInGame game;
	
	/**
	 * Creating the 'Home' menu option
	 * @param game
	 * @param view
	 */
	public FileMenu(JumpInGame game, JumpInView view) {
		super("Home");
		this.game = game;
		this.controller = new FileMenuController(game, view);
		
		JMenuItem item;
		
        item = new JMenuItem("Home");
        item.addActionListener(controller);
        this.add(item);	
	}
	
	/**
	 * 
	 */
	public void updateView() {
		
	}
	
	/**
	 * Subscribes the File menu to the JumpIn game model
	 */
	public void subscribeToModel() {
		this.game.addView(this);
	}
}
