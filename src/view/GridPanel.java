package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import controller.BoardButtonController;
import model.JumpInGame;

public class GridPanel extends JPanel {
	private BoardButton[][] boardGrid;
	private BoardButtonController controller;
	private JumpInGame g;
	
	public GridPanel(JumpInGame g) {
		super();
		this.boardGrid = new BoardButton[5][5];
		this.g = g;
		this.controller = new BoardButtonController(this.g);
		this.setLayout(new GridLayout(5, 5));	
		//Setting grid color
    	for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {	
            	Color green = new Color(34, 139, 34);
            	boardGrid[j][i] = new BoardButton(j, i, green);
            	this.add(boardGrid[j][i]);
            	boardGrid[j][i].addActionListener(controller);	                	            	            	
            }
        }
    	
    	Color brown = new Color(51, 24, 0);
    	Color darkgreen = new Color(7, 36, 0);
    	boardGrid[0][0].setBackground(brown);
    	boardGrid[0][4].setBackground(brown);
    	boardGrid[4][0].setBackground(brown);
    	boardGrid[4][4].setBackground(brown);
    	boardGrid[2][2].setBackground(brown);
    	boardGrid[0][2].setBackground(darkgreen);
    	boardGrid[2][0].setBackground(darkgreen);
    	boardGrid[4][2].setBackground(darkgreen);
    	boardGrid[2][4].setBackground(darkgreen);
	}
}
