/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.*;

/**
 * @author Aubin
 *
 */
public class AddButtonController implements ActionListener{
	
	private BoardBuilder builder;
	private JButton view;
	
	public AddButtonController(BoardBuilder builder, JButton view) {
		this.builder = builder;
		this.view = view;
		view.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		builder.constructSelectedPiece();
	}
	

}
