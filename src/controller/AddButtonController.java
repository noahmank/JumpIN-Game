/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.*;

/**
 * Add Button controller to add pieces to the board builder
 * @author Aubin
 *
 */
public class AddButtonController implements ActionListener{
	private JumpInGame game;
	private BoardBuilder builder;
	
	/**
	* Constructor for add button controller 
	* @param game is the game to initialize
	* @param view is the button view
	*/
	public AddButtonController(JumpInGame game, JButton view) {
		this.game = game;
		this.builder = game.getBuilder();
		view.addActionListener(this);
	}
	
	/**
	* deals with the action once the button is toggled
	* @param event is the action event
	*/
	@Override
	public void actionPerformed(ActionEvent event) {
		builder.constructSelectedPiece();
		game.notifyViews();
	}
	

}
