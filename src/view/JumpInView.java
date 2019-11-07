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
	private Container contents;
	private BoardButton[][] boardGrid;
	private JFrame frame;
	private JumpInController controller;
	private JPanel arrowPanel;
	private JTextField output;
	private JPanel textPanel;
	private int columns;
	private int rows;

	/**
	 * 
	 * @param g is the game
	 * @param columns is the number of columns
	 * @param rows is the number of rows
	 */
	public JumpInView(JumpInGame g, int columns, int  rows) {
		this.game = g;
		this.columns = columns;
		this.rows = rows;
		controller = new JumpInController(this.game, this);
		boardGrid = new BoardButton[columns][rows];
		frame = new JFrame("Jump-In Game");
    	contents = getContentPane();
        contents.setLayout(new GridLayout(columns, rows));	
                
        //Green Holes
    	for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
            	boardGrid[j][i] = new BoardButton(j, i, Color.green);
            	contents.add(boardGrid[j][i]);
            	boardGrid[j][i].addActionListener(controller);	                	            	            	
            }
        }
    	
    	Color brown = new Color(175, 100, 0);
    	Color darkgreen = new Color(0, 100, 0);
    	boardGrid[0][0].setBackground(brown);
    	boardGrid[0][4].setBackground(brown);
    	boardGrid[4][0].setBackground(brown);
    	boardGrid[4][4].setBackground(brown);
    	boardGrid[2][2].setBackground(brown);
    	boardGrid[0][2].setBackground(darkgreen);
    	boardGrid[2][0].setBackground(darkgreen);
    	boardGrid[4][2].setBackground(darkgreen);
    	boardGrid[2][4].setBackground(darkgreen);
    	
    	//setting arrow panel with all arrow buttons
        arrowPanel = new JPanel();
        
        DirectionButton leftArrow = new DirectionButton(Direction.WEST, controller);
        arrowPanel.add(leftArrow);	
        
        DirectionButton upArrow = (new DirectionButton(Direction.NORTH, controller));
        arrowPanel.add(upArrow);            
        
        DirectionButton downArrow = new DirectionButton(Direction.SOUTH, controller);
        arrowPanel.add(downArrow);
        
        DirectionButton rightArrow = new DirectionButton(Direction.EAST, controller);
        arrowPanel.add(rightArrow);
        
        //creating console for output (game over)
        textPanel = new JPanel();
        output = new JTextField("Game initialized", 60);
        output.setEditable(false);
        textPanel.add(output);
		
        //setting up the rulePanel
    	JLabel ruleText = new JLabel("<html>Welcome to The JumpIn Game.<br/><br/>GAME RULES<br/> "    			
    			+ "1) The Objective of the game is to move the rabbits and foxes around the gameboard until all of the rabbits are safe in brown holes.<br/> "
    			+ "2) To move a rabbit or a foxe, select one of them first then click the direction you want to move them in from the direction buttons at the bottom of the screen <br/><html/>"
    			+ "3) You have found a solution when all of the rabbits are inside brown holes!<br/><html/>");   
    	    	
    	ruleText.setPreferredSize(new Dimension(400,200));
    	
    	textPanel.add(ruleText);
        	          		    	       		        	         
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.add(arrowPanel, BorderLayout.SOUTH);	
    	frame.add(contents, BorderLayout.CENTER);
    	frame.add(textPanel, BorderLayout.NORTH);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	    
    	frame.setVisible(true);	    	
    }
	
	/**
	 * Subscribe this view to the model
	 */
	public void init() {
        this.game.addView(this);
	}
	
	/**
	 * Reconstruct the view based on the location of all the pieces on the board
	 * @param s is the console output for the view
	 */
	public void updateView(String s) {
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				boardGrid[i][j].setIcon(null);
			}
		}
    	// Assign all Fox icons
		for(Fox f : game.getBoard().getFoxes().keySet()) {
			Point tail = game.getBoard().getFoxes().get(f);
			boardGrid[tail.x][tail.y].updateButtonIcon(Fox.getSrc());
			boardGrid[tail.x + f.getDirection().getX()][tail.y + f.getDirection().getY()].updateButtonIcon(Fox.getSrc());
		}
		// Assign all Rabbit icons
		String rabbit = null;
		for(Rabbit r : game.getBoard().getRabbits().keySet()) {
			Point p = game.getBoard().getRabbits().get(r);
			rabbit = r.getColor().getSrc();
			boardGrid[p.x][p.y].updateButtonIcon(rabbit);
		}
		// Assign all Mushroom icons
		for(Point m : game.getBoard().getMushrooms().values()) {
			boardGrid[m.x][m.y].updateButtonIcon(Mushroom.getSrc());
		}
		output.setText(s);
	}
}
