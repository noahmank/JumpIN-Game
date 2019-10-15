package model;

import java.awt.Point;
import java.util.HashMap;

public class GameBoard {
	private static final int DEFAULT_COLUMNS = 5;
	private static final int DEFAULT_ROWS = 5;
	
	private Hole[][] grid;
	private HashMap<MoveablePiece, Point> moveablePieces;
	
	public GameBoard(int numColumns, int numRows) {
		
	}
	
	public GameBoard() {
		this(DEFAULT_COLUMNS, DEFAULT_ROWS);
	}
	
	public void resetGame() {
		
	}
	
	public void addPiece(Piece piece, int column, int row) {
		
	}
	
	public Boolean isFinished() {
		return false;
	}
	
	public String toString() {
		return "FIX ME!!";
	}
	
	private void addMoveablePiece(MoveablePiece piece, int column, int row) {
		
	}
	
	private void addMushroomPiece(Mushroom piece, int column, int row) {
		
	}
}
