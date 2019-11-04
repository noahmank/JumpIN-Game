package view;

import javax.swing.JButton;

import model.*;

public class DirectionButton extends JButton {
	private Direction direction;
	
	public DirectionButton(Direction d) {
		this.direction = d;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
}
