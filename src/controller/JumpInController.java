package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;
/**
* The controller for the JumpIN game
*/
public class JumpInController implements ActionListener{
	private JumpInGame game;
	private Piece piece;
	private Direction direction;	
	private JumpInView view;
	
	/**
	* Constructor for the JumpInController
	* @param game is the JumpInGame 
	* @param view is the view of the game
	*/
	public JumpInController(JumpInGame game, JumpInView view) {		
		this.game = game;
		this.view = view;	
	}
	
	/**
	* Deals with the actions 
	* @param event is the action event 
	*/
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() instanceof BoardButton){
			int row = ((BoardButton) event.getSource()).getRow();
			int column = ((BoardButton) event.getSource()).getColumn();
			if(game.getBoard().getHole(column, row).getIsOccupied()) {
				piece = game.getBoard().getHole(column, row).getPiece();
		}
			System.out.println(row + ", " + column);
		}
		else if(event.getSource() instanceof DirectionButton){
			this.direction = ((DirectionButton) event.getSource()).getDirection();
			System.out.println(this.direction);
		}
		if((direction != null) && (piece != null)) {
			if(piece instanceof Fox) {
				game.slideFox(piece.toString(), direction);
			}
			if(piece instanceof Rabbit) {
				game.jumpRabbit(piece.toString(), direction);
			}
			direction = null;
		}
	}
}
