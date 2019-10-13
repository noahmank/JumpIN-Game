package model;

import java.util.List;

public class GameBoard {
	private static final int DEFAULT_COLUMNS = 5;
	private static final int DEFAULT_ROWS = 5;
	
	private Hole[][] grid;
	private List<MoveablePiece> moveablePieces;
	
	public GameBoard(int numColumns, int numRows) {
		
	}
	
	public GameBoard() {
		this(DEFAULT_COLUMNS, DEFAULT_ROWS);
	}
	
	public void resetGame() {
		
	}
	
	public Boolean isFinished() {
		return false;
	}
	
	public String toString() {
		return "FIX ME!!";
	}
}
