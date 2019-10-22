package model;
/**
* An enumeration class for the directions
*/
public enum Direction {
	NORTH(0,-1),
	EAST(1,0),
	SOUTH(0,1),
	WEST(-1,0);
	
	private int x;
	private int y;
	
	/**
	* Constructor to initialize arguments
	* @param x the x co-ordinate of the direction
	* @param y the y co-ordinate of the direction
	*/
	private Direction(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	* @return the x co-ordinate of the direction
	*/
	public int getX() {
		return this.x;
	}
	
	/**
	* @return the y co-ordinate of the direction
	*/
	public int getY() {
		return this.y;
	}
}
