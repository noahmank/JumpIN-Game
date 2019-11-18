package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.*;
import model.*;

/**
 * 
 * @author RunTime Terror
 *
 */
public class GameBoardButtonController implements ActionListener {
	
	private JumpInGame game;
	
	/**
	 * Instantiates the game board button controller
	 * @param game is the JumpIn game model
	 */
	public GameBoardButtonController(JumpInGame game) {
		this.game = game;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BoardButton b = (BoardButton) e.getSource();
		int row = b.getRow();
		int column = b.getColumn();
		if (game.getBoard().getHole(column, row).isOccupied() && (game.getBoard().getHole(column, row).getPiece() instanceof MoveablePiece)) {
			game.setPiece((MoveablePiece) game.getBoard().getHole(column, row).getPiece()); //  change to game.savePieceAt(int c, int r)
		}
	}
}
