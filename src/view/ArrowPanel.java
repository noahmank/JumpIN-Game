package view;

import javax.swing.JPanel;

import controller.DirectionButtonController;
import model.Direction;
import model.JumpInGame;

public class ArrowPanel extends JPanel  implements View {
	DirectionButtonController controller;
	JumpInGame g;
	
	public ArrowPanel(JumpInGame g) {
		super();
		this.g = g;
		this.controller = new DirectionButtonController(this.g);
		DirectionButton leftArrow = new DirectionButton(Direction.WEST, controller);
        this.add(leftArrow);	
        
        DirectionButton upArrow = (new DirectionButton(Direction.NORTH, controller));
        this.add(upArrow);            
        
        DirectionButton downArrow = new DirectionButton(Direction.SOUTH, controller);
        this.add(downArrow);
        
        DirectionButton rightArrow = new DirectionButton(Direction.EAST, controller);
        this.add(rightArrow);
        subscribeToModel();
	}
	
	public void updateView(String s) {
		
	}
	
	public void subscribeToModel() {
		this.g.addView(this);
	}
}
