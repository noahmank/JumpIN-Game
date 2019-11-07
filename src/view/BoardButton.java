package view;

import java.awt.Color;
import javax.swing.JButton;

import controller.JumpInController;


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

	/**
	* Returns Row number of button
	*/
	public int getRow() {
		return this.row;
	}

	/**
	* Sets Row number of button
	*/
	public void setRow(int row) {
		this.row = row;
	}

	/**
	* Gets Column number of button
	*/
	public int getColumn() {
		return this.column;
	}
	
	/**
	* Sets Column number of button
	*/
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	* Returns the color
	*/
	public Color getColor() {
		return color;
	}

	/**
	* Sets the color
	*/
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	* Overrides and implements the toString method
	*/
	@Override
	public String toString() {
		return "(" + this.getColumn() + ", " + this.getRow() + ", " + this.getColor() + ")";
	}

	/**
	* Equals method to check if objects are equal to one another
	* @returns a boolean value whether the objects are equal(true) or not (false)
	*/
	@Override 
	public boolean equals(Object o) {
		if(o == this) return true;
		if(o == null || this.getClass() != o.getClass()) return false;
		BoardButton b = (BoardButton) o;
		return ((this.getRow() == b.getRow()) && (this.getColumn() == b.getColumn()) && (this.getColor() == b.getColor()));
	}

}
