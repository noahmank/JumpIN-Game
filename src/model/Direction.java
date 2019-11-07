package model;
/**
* An enumeration class for the directions
* @author Noah Mank
*/
public enum Direction {
	NORTH(0, -1, "upArrow.png"),
	EAST(1, 0, "rightArrow.png"),
	SOUTH(0, 1, "downArrow.png"),
	WEST(-1, 0, "leftArrow.png");
	
	private final int x;
	private final int y;
	private final String src;
	
	/**
	* Constructor to initialize arguments
	* @param x the x coordinate of the direction
	* @param y the y coordinate of the direction
	*/
	private Direction(int x, int y, String src) {
		this.x = x;
		this.y = y;
		this.src = src;
	}
	
	/**
	* @return the x coordinate of the direction
	*/
	public int getX() {
		return this.x;
	}
	
	/**
	* @return the y coordinate of the direction
	*/
	public int getY() {
		return this.y;
	}
	
	public String getSrc() {
		return this.src;
	}
	
	public Direction getOpposite() {
		switch(this) {
			case NORTH: return SOUTH;
			case SOUTH: return NORTH;
			case EAST: return WEST;
			case WEST: return EAST;
			default: return null;
		}
	}
	
	@Override
	public String toString() {
		return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
	}
}
