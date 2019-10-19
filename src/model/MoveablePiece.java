package model;

import java.awt.Point;

public abstract class MoveablePiece implements Piece {
	private String name;
	private Point location;
	
	/**
	 * instantiate the name and the location of the MoveablePiece
	 * @param name the instance name given to the MoveablePiece
	 * @param column the Y coordinate location of the MoveablePiece
	 * @param row the X coordinate location of the MoveablePiece
	 */
	public MoveablePiece(String name, int row, int column) {
		this.name = name;
		this.location = new Point(row,column);
	}
	
	/**
	 * getName retrieves the name of the specified MoveablePiece
	 * @return the name of the MoveablePiece
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * getLocation() retrieves the x and y coordinates of the desired MoveablePiece
	 * @return the x and y location of MoveablePiece
	 */
	public Point getLocation() {
		return this.location;
	}
	
	/**
	 * A text representation of the MoveablePiece
	 */
	@Override
	public String toString() {
		return "Piece Name: " + this.name + "\n Location: " + this.location;
	}
}
