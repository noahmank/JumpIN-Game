package model;

import java.awt.Point;
import java.util.HashMap;

public class GameBoard {
	private static final int DEFAULT_COLUMNS = 5;
	private static final int DEFAULT_ROWS = 5;
	private int numColumns;
	private int numRows;
	private Hole[][] grid;
	private HashMap<Rabbit, Point> rabbits;
	private HashMap<Fox, Point> foxes;
	
	/**
	* Creates a new GameBoard with the specified number of
	* columns and number of rows.
	* @param numColumns the number of columns to initialize the board to.
	* @param numRows the number of rows to initialize the board to.
	* @author Adela Tullio
	*/
	public GameBoard(int numColumns, int numRows) {
		//If the user enters a negative number or zero, throw illegal argument exception
		if(numColumns <= 0 || numRows <= 0) {
			throw new IllegalArgumentException("Grid must be a positive size.");
		}
		this.numColumns = numColumns;
		this.numRows = numRows;
		this.grid = new Hole[numRows][numColumns];
		this.foxes = new HashMap<>();
		this.rabbits = new HashMap<>();
		
		//Initializing every spot in the grid to be a hole
		for(int r = 0; r < this.numRows; r++) {
			for(int c = 0; c < this.numColumns; c++) {
				this.grid[r][c] = new Hole();
			}
		}
	}
	
	public GameBoard() {
		this(DEFAULT_COLUMNS, DEFAULT_ROWS);
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
	
	public void resetGame() {
		
	}
	
	public void addPiece(Piece piece, int column, int row) {
		try {
			checkValidSpace(column, row);
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		if(piece instanceof Mushroom) {
			this.addMushroomPiece((Mushroom) piece, column, row);
		}
		else if(piece instanceof Fox) {
			this.addFoxPiece((Fox) piece, column, row);
		}
		else {
			this.addRabbitPiece((Rabbit) piece, column, row);
		}
	}
	
	public Boolean isFinished() {
		for(Point point : rabbits.values()) {
			if(!(grid[point.x][point.y] instanceof BrownHole)) {
				return false;
			}
		}
		return true;
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
	
	public void moveFoxPiece(String name, Direction direction) {
		// Check to see if input name exists in foxes
		Fox foxPiece = null;
		Point location;
		for(Fox fox : foxes.keySet()) {
			if(fox.toString().equals(name)) {
				foxPiece = fox;
			}
		}
		// Input name is invalid
		if(foxPiece == null) {
			throw new IllegalArgumentException("Name is not valid, Choose another fox");
		}
		else {
			location = foxes.get(foxPiece);
		}
		// Check to see if direction is valid
		switch(direction) {
			case NORTH: case SOUTH:
				if((foxPiece.getDirection() != Direction.NORTH) || (foxPiece.getDirection() != Direction.SOUTH)) {
					throw new IllegalArgumentException("Direction is not valid, Choose either EAST or WEST");
				}
				break;
			case EAST: case WEST:
				if((foxPiece.getDirection() != Direction.EAST) || (foxPiece.getDirection() != Direction.WEST)) {
					throw new IllegalArgumentException("Direction is not valid, Choose either NORTH or SOUTH");
				}
				break;
		}
		// This does not yet account for hills -> need to think about that in addFoxPiece
		// Start move process by removing from initial locations (object and location are still stored locally)
		grid[location.x][location.y].removePiece(foxPiece);
		grid[location.x + foxPiece.getDirection().getX()][location.y + foxPiece.getDirection().getY()].removePiece(foxPiece);
		try {
			this.addFoxPiece(foxPiece, location.x + direction.getX(), location.y + direction.getY());
		}
		catch(IllegalArgumentException e) {
			grid[location.x][location.y].setPiece(foxPiece);
			grid[location.x + foxPiece.getDirection().getX()][location.y + foxPiece.getDirection().getY()].setPiece(foxPiece);
			System.out.println(e);
		}
	}
	
	public void moveRabbitPiece(String name, Direction direction) {
		
	}

	private void addRabbitPiece(Rabbit piece, int column, int row) {
		grid[column][row].setPiece(piece);
		this.rabbits.put(piece, new Point(column, row));
	}
	
	private void addFoxPiece(Fox piece, int column, int row) throws IllegalArgumentException {
		Direction direction = piece.getDirection();
		// Need to add try - catch, or maybe throw, or maybe up-stream handle, or all of the above
		try {
			checkValidSpace(column + direction.getX(), row + direction.getY());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		grid[column + direction.getX()][row + direction.getY()].setPiece(piece);
		grid[column][row].setPiece(piece);
		this.foxes.put(piece, new Point(column, row));
	}
	
	private void addMushroomPiece(Mushroom piece, int column, int row) {
		grid[column][row].setPiece(piece);
	}
	
	// Needs to throw exception, check if off grid
	private void checkValidSpace(int column, int row) throws IllegalArgumentException {
		if(grid[column][row].getIsOccupied()){ // checks to see if hole is empty
            throw new IllegalArgumentException("Space is not valid, Choose another square");
        }
	}
}
