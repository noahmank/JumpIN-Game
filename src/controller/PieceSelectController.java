package controller;

import java.awt.event.*;
import javax.swing.JComboBox;
import model.*;

/**
* Piece Select Controller
* 
*/
public class PieceSelectController implements ActionListener {
	private BoardBuilder builder;
	
	/**
	* Constructor for piece select controller
	* @param builder is the board builder
	* @param b is the drop down box to choose what piece the user wants to place on the
	* board to build
	*/
	public PieceSelectController(BoardBuilder builder, JComboBox<String> b) {
		this.builder = builder;
		b.addActionListener(this);
	}
	
	/**
	* deals with the action once the button is toggled
	* @param event is the action event
	*/
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox<String> box = (JComboBox<String>) e.getSource();
		String s = (String) box.getSelectedItem();
		this.builder.setPieceName(s);
	}
}
