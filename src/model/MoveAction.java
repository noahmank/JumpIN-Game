package model;

public class MoveAction {
	private MoveablePiece piece;
	private Direction direction;
	
	public MoveAction(MoveablePiece piece, Direction direction) {
		this.piece = piece;
		this.direction = direction;
	}
	
	public MoveAction(MoveAction move) {
		this.piece = move.getPiece();
		this.direction = move.getDirection();
	}
	
	public MoveAction getOppositeMove(MoveAction move) {
		return new MoveAction(move.getPiece(), move.getOppositeDirection());
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public Direction getOppositeDirection() {
		return this.direction.getOpposite();
	}
	
	public MoveablePiece getPiece() {
		return this.piece;
	}
}
