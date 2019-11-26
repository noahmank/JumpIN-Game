/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.JumpInGame;
import view.AddButton;

/**
 * @author Aubin
 *
 */
public class AddButtonController implements ActionListener{
	
	private JumpInGame game;
	private AddButton view;
	
	public AddButtonController(JumpInGame game, AddButton view) {
		this.game = game;
		this.view = view;
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		AddButton addButton = (AddButton) event.getSource();
		
	}
	

}
