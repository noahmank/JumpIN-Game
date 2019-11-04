package view;
/**
* The view implementation for the game
*
*/
import java.awt.*;
import java.io.File;

import javax.swing.*;

import controller.JumpInController;
import model.*;

public class JumpInView extends JFrame {
	private JumpInGame game;
	private Container contents;
	private BoardButton[][] BoardGrid;
	
	private JFrame frame;
	
	
	private JumpInController handler;
	private JPanel arrowPanel;

	/**
	 * 
	 * @param g is the game
	 * @param columns is the number of columns
	 * @param rows is the number of rows
	 */
	public JumpInView(JumpInGame g, int columns, int  rows) {
		this.game = g;
		handler = new JumpInController(this.game, this);
		BoardGrid = new BoardButton[columns][rows];
		frame = new JFrame("Jump-In Game");
    	contents = getContentPane();
        contents.setLayout(new GridLayout(columns, rows));	
                
//      this.game.addDisplay(this);
        //Green Holes
    	for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j <columns; j++)
            {
            		BoardGrid[j][i] = new BoardButton(j, i, Color.green);
            		contents.add(BoardGrid[j][i]);
            		BoardGrid[j][i].addActionListener(handler);	                
            		            	            	
            }
        }
    	
    	 Color brown = new Color(150,75,0);
    	 Color darkgreen = new Color(0, 100, 0);
    	 String mushroom  = "images" + File.separator +"mushroom.png";
    	 
    	BoardGrid[3][1].setIcon(resizeIcon(new ImageIcon(mushroom), 50, 50));   
    	BoardGrid[4][2].setIcon(resizeIcon(new ImageIcon(mushroom), 50, 50)); 
    	
    	BoardGrid[0][0].setBackground(brown);
    	BoardGrid[0][4].setBackground(brown);
    	BoardGrid[4][0].setBackground(brown);
    	BoardGrid[4][4].setBackground(brown);
    	BoardGrid[2][2].setBackground(brown);
    	BoardGrid[0][2].setBackground(darkgreen);
    	BoardGrid[2][0].setBackground(darkgreen);
    	BoardGrid[4][2].setBackground(darkgreen);
    	BoardGrid[2][4].setBackground(darkgreen);
    	
    	//setting arrow panel with all arrow buttons
        arrowPanel = new JPanel();
        
        DirectionButton leftArrow = new DirectionButton(Direction.WEST);
        leftArrow.setBounds(0, 0, 30, 30);
        leftArrow.setIcon(resizeIcon(new ImageIcon("images" + File.separator +"leftArrow.png"),leftArrow.getWidth(), leftArrow.getHeight()));
        arrowPanel.add(leftArrow);
        leftArrow.addActionListener(handler);	
        
        DirectionButton upArrow = new DirectionButton(Direction.NORTH);
        upArrow.setBounds(0, 0, 30, 30);
        upArrow.setIcon(resizeIcon(new ImageIcon("images" + File.separator +"upArrow.png"),upArrow.getWidth(), upArrow.getHeight()));
        arrowPanel.add(upArrow);            
        upArrow.addActionListener(handler);	
        
        DirectionButton downArrow = new DirectionButton(Direction.SOUTH);
        downArrow.setBounds(0, 0, 30, 30);
        downArrow.setIcon(resizeIcon(new ImageIcon("images" + File.separator +"downArrow.png"),downArrow.getWidth(), downArrow.getHeight()));
        arrowPanel.add(downArrow);
        downArrow.addActionListener(handler);	
        
        DirectionButton rightArrow = new DirectionButton(Direction.EAST);
        rightArrow.setBounds(0, 0, 30, 30);
        rightArrow.setIcon(resizeIcon(new ImageIcon("images" + File.separator +"rightArrow.png"),rightArrow.getWidth(), rightArrow.getHeight()));
        arrowPanel.add(rightArrow);
        rightArrow.addActionListener(handler);	
	    	
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.add(arrowPanel, BorderLayout.SOUTH);	
    	frame.add(contents, BorderLayout.CENTER);	    	   
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	    
    	frame.setVisible(true);	    	
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
		BoardGrid[column][row].setIcon(resizeIcon(new ImageIcon("images" + File.separator + iconName +".png"), 50, 50)); 
		
	}
}
