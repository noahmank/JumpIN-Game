/**
 * 
 */
package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.AddButtonController;
import model.JumpInGame;

/**
 * @author Aubin
 *
 */
public class AddButton extends JButton{
	
	private JButton AddButton;
	private AddButtonController addButtonController;
	private JumpInGame game;

	/**
	 * Constructs a Add Button 
	 * @param game is the Jump In Game model
	 */
	public AddButton(JumpInGame game, AddButton view) {
		super();
		this.game = game;
		AddButton = new JButton("Add Piece");
		this.add(AddButton);
		addButtonController = new AddButtonController(this.game, this);
	}

	/**
	 * Subscribes the add button to its corresponding controller
	 * @param event is the action listener
	 */
	public void subscribeToAddButton(ActionListener event) {
		AddButton.addActionListener(event);
	}

}

// This class will not be used, since this doesn't actually implement any new functionality from JButton (unlike direction or board button classes)