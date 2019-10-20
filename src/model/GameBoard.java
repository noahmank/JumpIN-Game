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
		this.resetGame();
		
	}
	
	/**
	 *  Default constructor of the GameBoard
	 */
	public GameBoard() {
		this(DEFAULT_COLUMNS, DEFAULT_ROWS);
	}
	
	/**
	 *  Resets the GameBoard
	 */
	public void resetGame() {
		
		this.foxes = new HashMap<>();
		this.rabbits = new HashMap<>();
		
		//Initializing every spot in the grid to be a hole
		for(int r = 0; r < this.numRows; r++) {
			for(int c = 0; c < this.numColumns; c++) {
				this.grid[r][c] = new Hole();
			}
		}
		this.initializeBrownHoles(0, 0);
		this.initializeBrownHoles(4, 0);
		this.initializeBrownHoles(2, 2);
		this.initializeBrownHoles(0, 4);
		this.initializeBrownHoles(4, 4);
		
		this.initializeRaisedHoles(2, 0);
		this.initializeRaisedHoles(0, 2);
		this.initializeRaisedHoles(4, 2);
		this.initializeRaisedHoles(2, 4);
	}
	
	/**
	* Method to initialize Brown Holes that bunnies will hop into
	* @param numColumn the column you wish to enter the BrownHole
	* @param numRow the row you wish to enter the BrownHole
	* @author Adela Tullio
	*/
	public void initializeBrownHoles(int numColumn, int numRow) {
		this.grid[numColumn][numRow] = new BrownHole();	
	}
	
	/**
	 * Method to initialize RaisedHoles within the board
	 * @param numColumn the column you wish to enter RaisedHole
	 * @param numRow the row you wish to enter RaisedHole
	 * @author Adela Tullio
	 */
	public void initializeRaisedHoles(int numColumn, int numRow) {
		this.grid[numColumn][numRow] = new RaisedHole();
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
	
	public String getLegend() {
		String s = "\n";
		s += "BH = Brown Hole\n";
		s += "EH = Empty Hole\n";
		s += "RH = Raised Hole\n";
		s += "GR = Grey Rabbit\n";
		s += "BR = Brown Rabbit\n";
		s += "WR = White Rabbit\n";
		s += "MS = Mushroom\n";
		return s;
	}
	
	/**
	* Changes the grid gameboard to a visual representation the user 
	* is able to see
	* @return the grid gameboard as a string
	* @author Adela Tullio
	*/	
	public String toString() {
		String s = "  |  ";
		for(int i = 0; i < this.numColumns; i++) {
			s += i + " |  ";
		}
		s += "\n";
		for(int r = 0; r < this.numRows; r++) {
			s += r + " | ";
			for(int c = 0; c < this.numColumns; c++) {
				s += grid[c][r].toString() + " | ";
			}
			s += "\n";
		}
		return s;
	}
	
	public void moveFoxPiece(String name, Direction direction) throws IllegalArgumentException {
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
		Rabbit rabbitPiece = null;
		Point location;
		Point newLocation;
		for(Rabbit rabbit : rabbits.keySet()) {
			if(rabbit.toString().equals(name)) {
				rabbitPiece = rabbit;
			}
		}
		if(rabbitPiece == null) {
			throw new IllegalArgumentException("Name is not valid, Choose another rabbit");
		}
		else {
			location = rabbits.get(rabbitPiece);
			newLocation = rabbits.get(rabbitPiece);
		}
		// If heading directly into an empty space, invalid
		if(!grid[location.x + direction.getX()][location.y + direction.getY()].getIsOccupied()) {
			throw new IllegalArgumentException("Direction invalid, choose another");
		}
		else {
			// Until next empty hole is found
			while(grid[newLocation.x + direction.getX()][newLocation.y + direction.getY()].getIsOccupied()) {
				newLocation.x += direction.getX();
				newLocation.y += direction.getY();
			}
			addRabbitPiece(rabbitPiece, newLocation.x + direction.getX(), newLocation.y + direction.getY());
			grid[location.x][location.y].removePiece(rabbitPiece);
		}
	}

	private void addRabbitPiece(Rabbit piece, int column, int row) {
		grid[column][row].setPiece(piece);
		this.rabbits.put(piece, new Point(column, row));
	}
	
	private void addFoxPiece(Fox piece, int column, int row) throws IllegalArgumentException {
		Direction direction = piece.getDirection();
		// checkValidSpace has already occurred for tail part, check head
		try {
			checkValidSpace(column + direction.getX(), row + direction.getY());
		}
		catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		// Check if tail or head holes are hills -> they shouldn't be
		if((grid[column][row] instanceof RaisedHole) || (grid[column + direction.getX()][row + direction.getY()] instanceof RaisedHole)) {
			throw new IllegalArgumentException("Foxes cannot be placed on raised holes, choose a new location");
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
		if(column >= numColumns || row >= numRows) {
			throw new IllegalArgumentException("Space is not valid, Choose another square");
		}
		if(grid[column][row].getIsOccupied()){ // checks to see if hole is empty
            throw new IllegalArgumentException("Space is not valid, Choose another square");
        }
	}
}
