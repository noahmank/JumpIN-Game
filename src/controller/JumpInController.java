package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import model.*;
import view.*;

/**
 * The controller for the JumpIN game
 */
public class JumpInController implements ActionListener {
	private JumpInGame game;
	private MoveablePiece piece;
	private Direction direction;
	private JumpInView view;

	/**
	 * Constructor for the JumpInController
	 * 
	 * @param game is the JumpInGame
	 * @param view is the view of the game
	 */
	public JumpInController(JumpInGame game, JumpInView view) {
		this.game = game;
		this.view = view;
	}

	/**
	 * Deals with the actions
	 * 
	 * @param event is the action event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() instanceof BoardButton) {
			int row = ((BoardButton) event.getSource()).getRow();
			int column = ((BoardButton) event.getSource()).getColumn();
			if (game.getBoard().getHole(column, row).isOccupied()
					&& (game.getBoard().getHole(column, row).getPiece() instanceof MoveablePiece)) {
				piece = (MoveablePiece) game.getBoard().getHole(column, row).getPiece();
			}

		} else if ((event.getSource() instanceof DirectionButton) && (piece != null)) {
			this.direction = ((DirectionButton) event.getSource()).getDirection();
		} else if ((event.getSource() instanceof JButton)
				&& ((JButton) event.getSource()).getText().equals("Click here to Start Game")) {

			this.view.ToGameFrame();

		} else if ((event.getSource() instanceof JMenuItem)
				&& ((JMenuItem) event.getSource()).getText().equals("Home")) {
			this.view.ToGameMenu();

		} else if ((event.getSource() instanceof JMenuItem)
				&& ((JMenuItem) event.getSource()).getText().equals("Undo")) {
			game.undoMoveAction();
		} else if ((event.getSource() instanceof JMenuItem)
				&& ((JMenuItem) event.getSource()).getText().equals("Redo")) {
			game.redoMoveAction();
		}
		if ((direction != null) && (piece != null)) {
			game.movePiece(piece, direction);
			direction = null;
		}
	}
}
