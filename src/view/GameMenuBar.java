package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.EditMenuButtonController;
import model.JumpInGame;

public class GameMenuBar extends JMenuBar {
	JumpInGame g;
	EditMenuButtonController controller;
	
	public GameMenuBar(JumpInGame g) {
		//Creating menu bar
        super();
        this.g = g;
        this.controller = new EditMenuButtonController(g);
        
        JMenu fileMenu = new JMenu("File");
        this.add(fileMenu);
        
        JMenu editMenu = new JMenu("Edit");
        this.add(editMenu);
        
        JMenuItem item;
	
        item = new JMenuItem("Home");
        item.addActionListener(controller);
        fileMenu.add(item);	
	
        item = new JMenuItem("Undo");
        item.addActionListener(controller);
        editMenu.add(item);
        
        item = new JMenuItem("Redo");
        item.addActionListener(controller);
        editMenu.add(item);
	}
}
