package view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controller.EditMenuController;
import model.JumpInGame;

public class EditMenu extends JMenu {
	EditMenuController controller;
	JumpInGame game;
	
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
}
