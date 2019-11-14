package view;
/**
* Class to instantiate Undo and Redo buttons
* @author Adela Tullio
*/
import javax.swing.*;

import controller.JumpInController;

public class UndoRedoButton extends JMenuItem{
	private String label;
	
  /**
  * Constructor that instantiates a JMenuItem by calling
  * the constructor of the super class and adds the button as
  * an action listener
  * @param label is the label of the button
  * @param c is the controller
  */
	public UndoRedoButton(String label, JumpInController c) {
		super(label);
		this.label = label;
		this.addActionListener(c);
		
	}
	
	/**
  * Returns the label of the button
  */
	public String getLabel() {
		return this.label;
	}
}
