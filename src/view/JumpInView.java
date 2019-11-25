package view;

import java.util.ArrayList;

import javax.swing.*;
import model.*;

/**
* The main view class for the game, that manages the various JFrames
*
*/
public class JumpInView extends JFrame {
	private ArrayList<JFrame> frames;
	private JumpInGame game;
	private GameFrame gameFrame;
	private InstructionsFrame instructionsFrame;
	private SolverFrame solverFrame;
	private BuilderFrame builderFrame;

	/**
	 * 
	 * @param game that the view is based on
	 */
	public JumpInView(JumpInGame game) {
		this.game = game;
		//Setting up frame to display rules and challenges
		instructionsFrame = new InstructionsFrame(game, this);	
		//Setting up frame to display game
		gameFrame = new GameFrame(this.game, this);
		// Setting up frame to display solver
		solverFrame = new SolverFrame(this.game, this);
		// Setting up frame to display builder
		builderFrame = new BuilderFrame(this.game, this);
	}
	
	/**
	 * Make the GameFrame visible, and other frames invisible
	 */
	public void toGameFrame() {			
		solverFrame.setVisible(false);
	    instructionsFrame.setVisible(false);
    	gameFrame.setVisible(true);	    	
    }
	
	/**
	 * Make the InstructionsFrame visible, and other frames invisible
	 */
	public void toInstructionsFrame() {		
		solverFrame.setVisible(false);
	    instructionsFrame.setVisible(true);
    	gameFrame.setVisible(false);	    	
    }
	
	/**
	 * Make the SolverFrame visible, and other frames invisible
	 */
	public void toSolverFrame() {		
		solverFrame.setVisible(true);
	    instructionsFrame.setVisible(false);
    	gameFrame.setVisible(false);	    	
    }
	
	public void toBuilderFrame() {
		solverFrame.setVisible(false);
		gameFrame.setVisible(false);
		instructionsFrame.setVisible(false);
		builderFrame.setVisible(true);
	}
}
