package model;

import java.awt.Point;
import java.util.HashMap;

public class GameBoard {
	private static final int DEFAULT_COLUMNS = 5;
	private static final int DEFAULT_ROWS = 5;
	private int numColumns;
	private int numRows;
	private Hole[][] grid;
	private HashMap<MoveablePiece, Point> moveablePieces;
	
	/**
	* Creates a new GameBoard with the specified number of
	* columns and number of rows.
	* @param numColumns the number of columns to initialize the board to.
	* @param numRows the number of rows to initialize the board to.
	* @author Adela Tullio
	*/
	public GameBoard(int numColumns, int numRows) {
		//If the user enters a negative number, throw illegal argument exception
		if(numColumns < 0 || numRows < 0) {
			throw new IllegalArgumentException("Grid must be a positive size.");
		}
		this.numColumns = numColumns;
		this.numRows = numRows;
		this.grid = new Hole[numRows][numColumns];
		this.moveablePieces = new HashMap<>();
		
		//Initializing every spot in the grid to be a hole
		for(int r = 0; r < this.numRows; r++) {
			for(int c = 0; c < this.numColumns; c++) {
				this.grid[r][c] = new Hole();
			}
		}
	
		//Initializing the BrownHoles that bunnies will hop into
		this.grid[0][0] = new BrownHole(); //brown hole at row 1, column 1
		this.grid[0][4] = new BrownHole(); //brown hole at row 1, column 5
		this.grid[2][2] = new BrownHole(); //brown hole at row 3, column 3
		this.grid[4][0] = new BrownHole(); //brown hole at row 5, column 1
		this.grid[4][4] = new BrownHole(); //brown hole at row 5, column 5
	
		//Initializing the RaisedHoles in the grid
		this.grid[0][2] = new RaisedHole(); //raised hole at row 1, column 3
		this.grid[2][0] = new RaisedHole(); //raised hole at row 3, column 1
		this.grid[2][4] = new RaisedHole(); //raised hole at row 3, column 5
		this.grid[4][2] = new RaisedHole(); //raised hole at row 5, column 3
	
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
	
	/**
	* Changes the grid gameboard to a visual representation the user 
	* is able to see
	* @return the grid gameboard as a string
	* @author Adela Tullio
	*/
	public String toString() {
		String s = "";
		for(int r = 0; r < this.numRows; r++) {
			for(int c = 0; c < this.numColumns; c++) {
				s += grid[r][c] + " | ";
			}
			s += "\n";
		}
		return s;
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
