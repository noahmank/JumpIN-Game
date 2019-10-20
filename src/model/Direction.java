package model;

public enum Direction {
	NORTH(0,-1),
	EAST(-1,0),
	SOUTH(0,1),
	WEST(1,0);
	
	private int x;
	private int y;
	
	Direction(final int x, final int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
}
