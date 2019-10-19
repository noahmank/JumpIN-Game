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
		if(grid[column][row].getIsOccupied()){ // checks to see if hole is empty
            		throw new IllegalArgumentException("Space is not valid, Choose another square");
        	}else{
            		grid[column][row].addPiece(piece);
        	}
	}
	
	public Boolean isFinished() {
		return false;
	}
	
	public String toString() {
		return "FIX ME!!";
	}
	
	private void addMoveablePiece(MoveablePiece piece, int column, int row) {
		if((grid[column][row].getIsOccupied() && grid[column+1][row].getIsOccupied()) || 
        	(grid[column+1][row].getIsOccupied() && grid[column][row + 1].getIsOccupied())){
            		throw new IllegalArgumentException("Space is not valid, Choose another square");
        	}
        	else{
            		//if(Direction == North){//head is facing north
            		grid[column][row].addPiece(piece);
            		grid[column + 1][row].addPiece(piece);
		}
	}
	
	private void addMushroomPiece(Mushroom piece, int column, int row) {
		if(!(grid[column][row].getIsOccupied())){ // checks to see if hole is empty
            		throw new IllegalArgumentException("Space is not valid, Choose another square");
        	}else{
             		grid[column][row].addPiece(piece);
        	}
	}
}
