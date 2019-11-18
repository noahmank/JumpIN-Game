package view;
/**
* The view implementation for the game
*
*/
import javax.swing.*;
import model.*;

public class JumpInView extends JFrame {
	private JumpInGame game;
	private GameFrame gameFrame;
	private InstructionsFrame instructionsFrame;
	private SolverFrame solverFrame;

	/**
	 * 
	 * @param g is the game
	 * @param columns is the number of columns
	 * @param rows is the number of rows
	 */
	public JumpInView(JumpInGame game) {
		this.game = game;
		//Setting up frame to display rules and challenges
		instructionsFrame = new InstructionsFrame(game, this);	
		//Setting up frame to display game
		gameFrame = new GameFrame(this.game, this);
		// Setting up frame to display solver
		solverFrame = new SolverFrame(this.game, this);
	}
	
	public void toGameFrame() {			
		solverFrame.setVisible(false);
	    instructionsFrame.setVisible(false);
    	gameFrame.setVisible(true);	    	
    }
	
	public void toInstructionsFrame() {		
		solverFrame.setVisible(false);
	    instructionsFrame.setVisible(true);
    	gameFrame.setVisible(false);	    	
    }
	
	public void toSolverFrame() {		
		solverFrame.setVisible(true);
	    instructionsFrame.setVisible(false);
    	gameFrame.setVisible(false);	    	
    }
}
