package model;

public class Fox extends MoveablePiece {
	private Direction direction;
	
	public Fox(Direction direction, String name) {
		super(name);
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
}
