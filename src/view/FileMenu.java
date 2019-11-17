package view;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import controller.FileMenuController;
import model.JumpInGame;

public class FileMenu extends JMenu implements View{
	FileMenuController controller;
	JumpInView view;
	JumpInGame game;
	
	public FileMenu(JumpInGame game, JumpInView view) {
		super("Home");
		this.game = game;
		this.controller = new FileMenuController(game, view);
		
		JMenuItem item;
		
        item = new JMenuItem("Home");
        item.addActionListener(controller);
        this.add(item);	
	}
	
	public void updateView(String s) {
		
	}
	
	public void subscribeToModel() {
		this.game.addView(this);
	}
}
