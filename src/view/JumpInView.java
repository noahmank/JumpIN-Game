package view;
/**
* The view implementation for the game
*
*/
import java.awt.*;
import javax.swing.*;
import controller.JumpInController;
import model.*;

public class JumpInView extends JFrame {
	private JumpInGame game;
	private JPanel gridPanel;
	private JFrame frame;
	private JFrame preFrame;
	private JumpInController controller;
	private JPanel arrowPanel;
	private JPanel textPanel;

	/**
	 * 
	 * @param g is the game
	 * @param columns is the number of columns
	 * @param rows is the number of rows
	 */
	public JumpInView(JumpInGame g) {
		this.game = g;
		this.controller = new JumpInController(this);
		
		//Setting up frame to display rules and challenges
		preFrame = new JFrame("Welcome to Jump-In Game");
		JButton start = new JButton("Click here to Start Game");
		start.addActionListener(controller);
		
				//setting up the rulePanel
    	JLabel ruleText = new JLabel("<html>Welcome to The JumpIn Game.<br/><br/>GAME RULES<br/> "    			
    			+ "1) The Objective of the game is to move the rabbits and foxes around the gameboard until all of the rabbits are safe in brown holes.<br/> "
    			+ "2) To move a rabbit or a fox, select one of them first then click the direction you want to move them in from the direction buttons at the bottom of the screen <br/><html/>"
    			+ "3) You have found a solution when all of the rabbits are inside brown holes!<br/><html/>");       	    	
    	ruleText.setPreferredSize(new Dimension(400,200));
    	preFrame.add(ruleText);
    	 
		preFrame.add(start, BorderLayout.SOUTH);
		preFrame.setSize(700, 700);
		preFrame.setVisible(true);
		preFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Setting up frame to display game
		frame = new JFrame("Jump-In Game");
    	gridPanel = new GridPanel(game);
    	
    	//setting arrow panel with all arrow buttons
        arrowPanel = new ArrowPanel(game);
        
        
        //creating console for output (game over)
        textPanel = new ConsoleOutputPanel(game);
	
        //Creating menu bar
        JMenuBar menuBar = new GameMenuBar(game, this);
        	
        
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(menuBar);
        frame.add(arrowPanel, BorderLayout.SOUTH);	
    	frame.add(gridPanel, BorderLayout.CENTER);
    	frame.add(textPanel, BorderLayout.NORTH);    	
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	public void ToGameFrame() {			
	    preFrame.setVisible(false);
    	frame.setVisible(true);	    	
    }
	
	public void ToGameMenu() {			
	    preFrame.setVisible(true);
    	frame.setVisible(false);	    	
    }
}
