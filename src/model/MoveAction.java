package model;

public class MoveAction {
	private Piece piece;
	private Direction direction;
	
	public MoveAction(Piece piece, Direction direction) {
		this.piece = piece;
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
}
