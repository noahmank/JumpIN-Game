package model;

public abstract class MoveablePiece implements Piece {
	private String name;
	
	public MoveablePiece(int column, int row) {
		//location = new Point(column,row);
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
