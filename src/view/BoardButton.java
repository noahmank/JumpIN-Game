package view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/*
 * This Class represents a Button on the BoardGrid of the view 
 */
public class BoardButton extends JButton {
	private int row;
	private int column;
	
	/** Constructor of a BoardButton
	 * @param column -> column number of button
	 * @param row -> run number of button
	 * @param color -> color of button
	 */
	public BoardButton(int column, int row, Color color) {
		this.column = column;
		this.row = row;
		this.setBackground(color);
	}
	
	public void updateButtonIcon(String iconName) {
		this.setIcon(ImageHandler.resizeIcon(new ImageIcon(ImageHandler.getImageURL(iconName)), 50, 50)); 
	}

	/**
	* Returns Row number of button
	*/
	public int getRow() {
		return this.row;
	}

	/**
	* Gets Column number of button
	*/
	public int getColumn() {
		return this.column;
	}
}
