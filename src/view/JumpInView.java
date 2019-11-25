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

	/**
	 * 
	 * @param game that the view is based on
	 */
	public JumpInView(JumpInGame game) {
		frames = new ArrayList<>();
		this.game = game;
		//Setting up frame to display rules and challenges
		frames.add(new InstructionsFrame(this.game, this));
		//Setting up frame to display game
		frames.add(new GameFrame(this.game, this));
		// Setting up frame to display solver
		frames.add(new SolverFrame(this.game, this));
		// Setting up frame to display builder
		frames.add(new BuilderFrame(this.game, this));
		
	}
	
	/**
	 * Make the GameFrame visible, and other frames invisible
	 */
	public void toGameFrame() {
		for(JFrame f : frames) {
			if(f instanceof GameFrame) f.setVisible(true);
			else f.setVisible(false);
		}
    }
	
	/**
	 * Make the InstructionsFrame visible, and other frames invisible
	 */
	public void toInstructionsFrame() {		
		for(JFrame f : frames) {
			if(f instanceof InstructionsFrame) f.setVisible(true);
			else f.setVisible(false);    
		}
    }
	
	/**
	 * Make the SolverFrame visible, and other frames invisible
	 */
	public void toSolverFrame() {		
		for(JFrame f : frames) {
			if(f instanceof SolverFrame) f.setVisible(true);
			else f.setVisible(false);    
		}	    	
    }
	
	/**
	 * Make the BuilderFrame visible, and other frames invisible
	 */
	public void toBuilderFrame() {
		for(JFrame f : frames) {
			if(f instanceof BuilderFrame) f.setVisible(true);
			else f.setVisible(false);    
		}
	}
}
