package model;

public abstract class MoveablePiece implements Piece {
	private String name;
	
	public MoveablePiece(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
