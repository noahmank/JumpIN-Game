package model;
/**
* An enumeration class for the directions
* @author Noah Mank
*/
public enum Direction {
	NORTH(0,-1),
	EAST(1,0),
	SOUTH(0,1),
	WEST(-1,0);
	
	private final int x;
	private final int y;
	
	/**
	* Constructor to initialize arguments
	* @param x the x coordinate of the direction
	* @param y the y coordinate of the direction
	*/
	private Direction(int x, int y) {
		this.x = x;
		this.y = y;
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
