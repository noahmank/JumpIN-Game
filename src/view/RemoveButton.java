package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.RemoveButtonController;
import model.JumpInGame;
/**
 * The Remove Button view
 * @author Adela Tullio
 *
 */
public class RemoveButton extends JButton{
	private JButton removeButton;
	private RemoveButtonController removeButtonController;
	private int column;
	private int row;
	private JumpInGame game;

	/**
	 * remove button constructor
	 * @param g is the game
	 * @param column is the column of the piece you wish to remove
	 * @param row is the row of the piece you wish to remove
	 */
	public RemoveButton(JumpInGame g, int column, int row) {
		super();
		this.game = g;
		this.column = column;
		this.row = row;
		removeButton = new JButton("Remove Piece");
		this.add(removeButton);
		removeButtonController = new RemoveButtonController(this.game, this);
	}

	/**
	 * subscribes the view to the action listener
	 * @param l is the action listener
	 */
	public void subscribeToRemoveButton(ActionListener l) {
		removeButton.addActionListener(l);
	}

	/**
	* Returns Row number of button pressed
	* containing the piece the user wishes to remove
	* @return row number
	*/
	public int getRow() {
		return this.row;
	}

	/**
	* Gets Column number of button pressed
	* containing the piece the user wishes to remove
	* @return column number
	*/
	public int getColumn() {
		return this.column;
	}
}