package view;

import java.awt.Color;
import javax.swing.JButton;


/*
 * This Class represents a Button on the BoardGrid of the view 
 */
public class BoardButton extends JButton {
	
	private int row;
	private int column;
	private Color color;
	
	/** Constructor of a BoardButton
	 * @param column -> column number of button
	 * @param row -> run number of button
	 * @param color -> color of button
	 */
	public BoardButton(int column, int row, Color color) {
		this.column = column;
		this.row = row;
		this.color = color;
		this.setBackground(color);
	}

	// Returns Row number of button
	public int getRow() {
		return this.row;
	}

	//Sets Column number of button
	public void setRow(int row) {
		this.row = row;
	}

	//
	public int getColumn() {
		return this.column;
	}
	
	//
	public void setColumn(int column) {
		this.column = column;
	}

	//
	public Color getColor() {
		return color;
	}

	//
	public void setColor(Color color) {
		this.color = color;
	}
	
	//
	@Override
	public String toString() {
		return "(" + this.getColumn() + ", " + this.getRow() + ", " + this.getColor() + ")";
	}

	//
	@Override 
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		
		if(o == null) {
			return false;
		}
		
		if(this.getClass() != o.getClass()) {
			return false;
		}
		
		BoardButton buttonBoard = (BoardButton) o;
		return (this == buttonBoard);
	}

}
