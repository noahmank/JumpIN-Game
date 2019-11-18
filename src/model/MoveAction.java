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
	
	public MoveAction getOppositeMove() {
		return new MoveAction(piece, direction.getOpposite());
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public MoveablePiece getPiece() {
		return this.piece;
	}
	
	@Override
	public String toString() {
		return "(" + this.piece.toString() + ", " + this.direction.toString() + ")";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		MoveAction moveAction = (MoveAction) obj;
		return (moveAction.getPiece().equals(this.piece)) && (moveAction.getDirection().equals(this.direction)); 
	}
}
