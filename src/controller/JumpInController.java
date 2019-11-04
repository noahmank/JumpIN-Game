package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;

public class JumpInController implements ActionListener{
	private JumpInGame game;
	private Piece piece;
	private Direction direction;	
	private JumpInView view;
	
	public JumpInController(JumpInGame game, JumpInView view) {		
		this.game = game;
		this.view = view;
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
	
		if(event.getSource() instanceof BoardButton){
			int row = ((BoardButton) event.getSource()).getRow();
			int column = ((BoardButton) event.getSource()).getColumn();
//			if(game.getBoard().getHoleContent(column, row).getIsOccupied()) {
//				piece = game.getBoard().getHoleContent(column, row).getPiece();
//			}
			System.out.println(row + ", " + column);
		}
		else if(event.getSource() instanceof DirectionButton){
			this.direction = ((DirectionButton) event.getSource()).getDirection();
			System.out.println(this.direction);
		}
		if((direction != null) && (piece != null)) {
			if(piece instanceof Fox) {
				//game.slideFox(piece.toString(), direction);
			}
			if(piece instanceof Rabbit) {
				//game.jumpRabbit(piece.toString(), direction);
			}
			direction = null;
		}
	}


	public void updateView() {
		// TODO Auto-generated method stub
		
	}

}
