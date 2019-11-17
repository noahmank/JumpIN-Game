package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import view.*;

/**
 * The controller for the JumpIN game
 */
public class JumpInController implements ActionListener {

	private JumpInView view;

	/**
	 * Constructor for the JumpInController
	 * 
	 * @param game is the JumpInGame
	 * @param view is the view of the game
	 */
	public JumpInController(JumpInView view) {
		this.view = view;
	}

	/**
	 * Deals with the actions
	 * 
	 * @param event is the action event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if ((event.getSource() instanceof JButton) && ((JButton) event.getSource()).getText().equals("Click here to Start Game")) {
			this.view.ToGameFrame();
		}
	}
}
