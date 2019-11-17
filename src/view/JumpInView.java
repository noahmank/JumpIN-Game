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
		
		//Setting up frame to display rules and challenges
		preFrame = new InstructionsFrame(this);
		
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
	
	public void toGameFrame() {			
	    preFrame.setVisible(false);
    	frame.setVisible(true);	    	
    }
	
	public void toGameMenu() {			
	    preFrame.setVisible(true);
    	frame.setVisible(false);	    	
    }
}
