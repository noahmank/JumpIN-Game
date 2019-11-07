package view;
import javax.swing.ImageIcon;
/**
* DirectionButton class to set up the buttons for directions
*/
import javax.swing.JButton;

import controller.JumpInController;
import model.*;

public class DirectionButton extends JButton {
	private Direction direction;
	private ImageHandler handler;
	/**
	* @param d is the direction you wish the button to be
	*/
	public DirectionButton(Direction d) {
		this.direction = d;
		handler = new ImageHandler();
		this.setBounds(0, 0, 30, 30);
		this.setIcon(handler.resizeIcon(new ImageIcon(handler.getImageURL(d.getSrc())), this.getWidth(), this.getHeight()));
	}
	
	/**
	* @return the direction
	*/
	public Direction getDirection() {
		return this.direction;
	}
}
