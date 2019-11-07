package view;
/**
* The view implementation for the game
*
*/
import java.awt.*;
import java.io.File;
import java.net.URL;

import javax.swing.*;

import controller.JumpInController;
import model.*;

public class JumpInView extends JFrame {
	private JumpInGame game;
	private Container contents;
	private BoardButton[][] boardGrid;
	private JFrame frame;
	private JumpInController handler;
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
		String f = File.separator;
		this.game = g;
		this.columns = columns;
		this.rows = rows;
		handler = new JumpInController(this.game, this);
		boardGrid = new BoardButton[columns][rows];
		frame = new JFrame("Jump-In Game");
    	contents = getContentPane();
        contents.setLayout(new GridLayout(columns, rows));	
                
        //Green Holes
    	for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j <columns; j++)
            {
            	boardGrid[j][i] = new BoardButton(j, i, Color.green);
            	contents.add(boardGrid[j][i]);
            	boardGrid[j][i].addActionListener(handler);	                
            		            	            	
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
        
        DirectionButton leftArrow = new DirectionButton(Direction.WEST);
        leftArrow.setBounds(0, 0, 30, 30);
        leftArrow.setIcon(resizeIcon(new ImageIcon(getImageURL("leftArrow.png")),leftArrow.getWidth(), leftArrow.getHeight()));
        arrowPanel.add(leftArrow);
        leftArrow.addActionListener(handler);	
        
        DirectionButton upArrow = new DirectionButton(Direction.NORTH);
        upArrow.setBounds(0, 0, 30, 30);
        upArrow.setIcon(resizeIcon(new ImageIcon(getImageURL("upArrow.png")),upArrow.getWidth(), upArrow.getHeight()));
        arrowPanel.add(upArrow);            
        upArrow.addActionListener(handler);	
        
        DirectionButton downArrow = new DirectionButton(Direction.SOUTH);
        downArrow.setBounds(0, 0, 30, 30);
        downArrow.setIcon(resizeIcon(new ImageIcon(getImageURL("downArrow.png")),downArrow.getWidth(), downArrow.getHeight()));
        arrowPanel.add(downArrow);
        downArrow.addActionListener(handler);	
        
        DirectionButton rightArrow = new DirectionButton(Direction.EAST);
        rightArrow.setBounds(0, 0, 30, 30);
        rightArrow.setIcon(resizeIcon(new ImageIcon(getImageURL("rightArrow.png")),rightArrow.getWidth(), rightArrow.getHeight()));
        arrowPanel.add(rightArrow);
        rightArrow.addActionListener(handler);	
	    
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
	 * @param icon is the image of the icon
	 * @param resizedWidth is the new width you wish to change it to
	 * @param resizedHeight is the new height you wish to change it to
	 * @return the resized image icon to the specified dimensions
	 */
	public Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        	Image img = icon.getImage();
        	Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
        	return new ImageIcon(resizedImage);
    	}	
	
	/**
	* @param column	is the column in which you wish to set icon
	* @param row is the row in which you wish to set icon
	* @param iconName is the name of the icon
	*/
	public void updateIcon(int column, int row, String iconName) {
		boardGrid[column][row].setIcon(resizeIcon(new ImageIcon("images" + File.separator + iconName +".png"), 50, 50)); 
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
			boardGrid[tail.x][tail.y].setIcon(resizeIcon(new ImageIcon(getImageURL("fox.jpg")), 50, 50));
			boardGrid[tail.x + f.getDirection().getX()][tail.y + f.getDirection().getY()].setIcon(resizeIcon(new ImageIcon(getImageURL("fox.jpg")), 50, 50));
		}
		// Assign all Rabbit icons
		String rabbit = null;
		for(Rabbit r : game.getBoard().getRabbits().keySet()) {
			Point p = game.getBoard().getRabbits().get(r);
			rabbit = r.getColor().getSrc();
			boardGrid[p.x][p.y].setIcon(resizeIcon(new ImageIcon(getImageURL(rabbit)), 50, 50));
		}
		// Assign all Mushroom icons
		for(Point m : game.getBoard().getMushrooms().values()) {
			boardGrid[m.x][m.y].setIcon(resizeIcon(new ImageIcon(getImageURL("mushroom.png")), 50, 50));  
		}
		output.setText(s);
	}
	
	private URL getImageURL(String imageName) {
		return JumpInView.class.getResource("/images/" + imageName);
	}
}
