package view;
/**
* DirectionButton class to set up the buttons for directions
*/
import javax.swing.JButton;

import model.*;

public class DirectionButton extends JButton {
	private Direction direction;
	
	/**
	* @param d is the direction you wish the button to be
	*/
	public DirectionButton(Direction d) {
		this.direction = d;
	}
	
	/**
	* @return the direction
	*/
	public Direction getDirection() {
		return this.direction;
	}
}
