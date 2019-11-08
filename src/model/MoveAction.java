package model;

public class MoveAction {
	private MoveablePiece piece;
	private Direction direction;
	
	public MoveAction(MoveablePiece piece, Direction direction) {
		this.piece = piece;
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public MoveablePiece getPiece() {
		return this.piece;
	}
}
