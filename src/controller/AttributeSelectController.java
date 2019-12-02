package controller;

import java.awt.event.*;
import javax.swing.JComboBox;
import model.*;

/**
* Attribute Select Controller to select the attribute of the piece
* the user wishes to add to the board builder
* Example: Rabbit, Attributes would be the colour: White, Brown, Grey
*/
public class AttributeSelectController implements ActionListener {
	private BoardBuilder builder;
	
	/**
	* Constructor for the attribute select controller
	* @param builder is the board builder
	* @param b is the drop down box to choose the attribute
	*/
	public AttributeSelectController(BoardBuilder builder, JComboBox<String> b) {
		this.builder = builder;
		b.addActionListener(this);
	}
	
	/**
	* deals with the action once the button is toggled
	* @param e is the action event
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> box = (JComboBox<String>) e.getSource();
		String s = (String) box.getSelectedItem();
		builder.setPieceAttribute(s);
	}
}
