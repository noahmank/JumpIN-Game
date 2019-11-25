package view;

import javax.swing.JPanel;
import controller.DirectionButtonController;
import model.Direction;
import model.JumpInGame;

/**
 * 
 * @author RunTime Terror
 *
 */
public class DirectionButtonPanel extends JPanel implements JumpInGameListener {
	private DirectionButton leftArrow;
	private DirectionButton rightArrow;
	private DirectionButton upArrow;
	private DirectionButton downArrow;
	private JumpInGame g;
	
	/**
	 * Constructs buttons that show the directions the user can select
	 * @param g is the JumpIn game model
	 */
	public DirectionButtonPanel(JumpInGame g) {
		super();
		this.g = g;
		
		leftArrow = new DirectionButton(Direction.WEST);
		new DirectionButtonController(this.g, leftArrow);
        this.add(leftArrow);	
        
        upArrow = new DirectionButton(Direction.NORTH);
        new DirectionButtonController(this.g, upArrow);
        this.add(upArrow);            
        
        downArrow = new DirectionButton(Direction.SOUTH);
        new DirectionButtonController(this.g, downArrow);
        this.add(downArrow);
        
        rightArrow = new DirectionButton(Direction.EAST);
        new DirectionButtonController(this.g, rightArrow);
        this.add(rightArrow);
        
        subscribeToModel();
	}
	
	public void updateView() {
	}
	
	/**
	 * Subscribes the Arrow button panel to the JumpIn game model
	 */
	public void subscribeToModel() {
		this.g.addView(this);
	}
}
