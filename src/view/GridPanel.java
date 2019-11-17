package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JPanel;
import controller.BoardButtonController;
import model.Fox;
import model.JumpInGame;
import model.Mushroom;
import model.Rabbit;

public class GridPanel extends JPanel implements View {
	private BoardButton[][] boardGrid;
	private BoardButtonController controller;
	private JumpInGame g;
	private int columns;
	private int rows;
	
	public GridPanel(JumpInGame g) {
		super();
		this.columns = 5;
		this.rows = 5;
		this.boardGrid = new BoardButton[columns][rows];
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
    	subscribeToModel();
	}
	
	public void subscribeToModel() {
		this.g.addView(this);
	}
	
	public void updateView(String s) {
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				boardGrid[i][j].setIcon(null);
			}
		}
    	// Assign all Fox icons
		for(Fox f : g.getBoard().getFoxes().keySet()) {
			Point tail = g.getBoard().getFoxes().get(f);
			boardGrid[tail.x][tail.y].updateButtonIcon(f.getSrc());
			boardGrid[tail.x + f.getDirection().getX()][tail.y + f.getDirection().getY()].updateButtonIcon(f.getSrc());
		}
		// Assign all Rabbit icons
		String rabbit = null;
		for(Rabbit r : g.getBoard().getRabbits().keySet()) {
			Point p = g.getBoard().getRabbits().get(r);
			rabbit = r.getColor().getSrc();
			boardGrid[p.x][p.y].updateButtonIcon(rabbit);
		}
		// Assign all Mushroom icons
		for(Point m : g.getBoard().getMushrooms().values()) {
			boardGrid[m.x][m.y].updateButtonIcon(Mushroom.getSrc());
		}
	}
}
