package view;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
/**
* DirectionButton class to set up the buttons for directions
*/
import javax.swing.JButton;

import controller.DirectionButtonController;
import controller.FrameViewController;
import model.*;

public class DirectionButton extends JButton {
	
	private Direction direction;
	
	/**
	* @param d is the direction you wish the button to indicate
	* @param c is the controller responsible for handling the specified button
	*/
	public DirectionButton(Direction d) {
		this.direction = d;
		this.setBounds(0, 0, 30, 30);
		this.setIcon(ImageHandler.resizeIcon(new ImageIcon(ImageHandler.getImageURL(d.getSrc())), this.getWidth(), this.getHeight()));
	}
	
	/**
	* @return the direction
	*/
	public Direction getDirection() {
		return this.direction;
	}
	
	public void subscribeToDirectionButton(ActionListener l) {
		this.addActionListener(l);
	}
}
