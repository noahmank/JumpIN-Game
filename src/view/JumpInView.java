package view;
/**
* The view implementation for the game
*
*/
import javax.swing.*;
import model.*;

public class JumpInView extends JFrame {
	private GameFrame gameFrame;
	private InstructionsFrame instructionsFrame;


	/**
	 * 
	 * @param g is the game
	 * @param columns is the number of columns
	 * @param rows is the number of rows
	 */
	public JumpInView(JumpInGame game) {
		//Setting up frame to display rules and challenges
		instructionsFrame = new InstructionsFrame(this);	
		//Setting up frame to display game
		gameFrame = new GameFrame(game, this);
	}
	
	public void toGameFrame() {			
	    instructionsFrame.setVisible(false);
    	gameFrame.setVisible(true);	    	
    }
	
	public void toInstructionsFrame() {			
	    instructionsFrame.setVisible(true);
    	gameFrame.setVisible(false);	    	
    }
}
