package model;

public class MoveAction {
	private Piece piece;
	private Direction direction;
	
	public MoveAction(Piece piece, Direction direction) {
		this.piece = piece;
		this.direction = direction;
	}
}
