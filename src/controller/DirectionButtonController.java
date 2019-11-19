package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

/**
 * Controller for the DirectionButtons
 * @author Noah Mank
 *
 */
public class DirectionButtonController implements ActionListener {
	private JumpInGame game;
	
	/**
	 * Constructor for a DirectionButtonController
	 * @param game is the model that needs to be updated
	 */
	public DirectionButtonController(JumpInGame game) {
		this.game = game;
	}
	
	/**
	 * Method that is called when a DirectionButton is pressed, updates Direction variable in model.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		DirectionButton b = (DirectionButton) e.getSource();
		if(game.getPiece() != null) {
			game.setDirection(b.getDirection());
		}
		if ((game.getDirection() != null) && (game.getPiece() != null)) {
			game.movePiece();
			game.setDirection(null);
		}
	}
}
