package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import model.JumpInGame;

/**
 * 
 * @author RunTime Terror
 *
 */
public class InstructionsFrame extends JFrame {
	private JumpInView view;
	private FrameModePanel frameModePanel;
	private ChallengeSelectPanel challengeSelectPanel;
	/**
	 * Constructing a frame containing all the game rules, the Start game Button and the Solve game Button
	 * @param g
	 * @param v
	 */
	public InstructionsFrame(JumpInGame g, JumpInView v) {
		super("Welcome to Jump-In Game");
		this.view = v;
		this.frameModePanel = new FrameModePanel(g, this.view);
		this.challengeSelectPanel = new ChallengeSelectPanel(g);
		
    	JLabel ruleText = new JLabel("<html>Welcome to The JumpIn Game.<br/><br/>GAME RULES<br/> "    			
    			+ "1) The Objective of the game is to move the rabbits and foxes around the gameboard until all of the rabbits are safe in brown holes.<br/> "
    			+ "2) To move a rabbit or a fox, select one of them first then click the direction you want to move them in from the direction buttons at the bottom of the screen <br/><html/>"
    			+ "3) You have found a solution when all of the rabbits are inside brown holes!<br/><html/>");       	    	
    	ruleText.setPreferredSize(new Dimension(400,200));
    	
    	this.add(ruleText, BorderLayout.NORTH);
    	this.add(challengeSelectPanel, BorderLayout.CENTER);
		this.add(frameModePanel, BorderLayout.SOUTH);
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
