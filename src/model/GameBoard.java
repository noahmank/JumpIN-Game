package model;

import java.awt.Point;
import java.util.HashMap;

/**
* Creates and initializes the playing gameboard, and provides methods to add and move pieces
*/
public class GameBoard {
	private static final int DEFAULT_COLUMNS = 5;
	private static final int DEFAULT_ROWS = 5;
	private int numColumns;
	private int numRows;
	private Hole[][] grid;
	private HashMap<Rabbit, Point> rabbits;
	private HashMap<Fox, Point> foxes;
	private HashMap<Mushroom, Point> mushrooms;
	
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
		this.mushrooms = new HashMap<>();
	}
	
	/**
	 *  Default constructor of the GameBoard that creates a 5x5 board
	 *  @author Adela Tullio
	 */
	public GameBoard() {
		this(DEFAULT_COLUMNS, DEFAULT_ROWS);
		this.resetDefaultBoard();
	}
	
	/**
	 *  Resets the GameBoard to a default state with only special holes initialized
	 *  @author Liya Abebe
	 */
	public void resetDefaultBoard() {
		//Initializing every spot in the grid to be a hole
		for(int r = 0; r < this.numRows; r++) {
			for(int c = 0; c < this.numColumns; c++) {
				this.grid[r][c] = new Hole();
			}
		}
		this.initializeBrownHole(0, 0);
		this.initializeBrownHole(4, 0);
		this.initializeBrownHole(2, 2);
		this.initializeBrownHole(0, 4);
		this.initializeBrownHole(4, 4);
		
		this.initializeRaisedHole(2, 0);
		this.initializeRaisedHole(0, 2);
		this.initializeRaisedHole(4, 2);
		this.initializeRaisedHole(2, 4);
	}
	/**
	* Method to initialize Brown Holes that bunnies will hop into
	* @param numColumn the column you wish to enter the BrownHole
	* @param numRow the row you wish to enter the BrownHole
	* @author Adela Tullio
	*/
	public void initializeBrownHole(int numColumn, int numRow) {
		this.grid[numColumn][numRow] = new BrownHole();	
	}
	
	/**
	 * Method to initialize RaisedHoles within the board
	 * @param numColumn the column you wish to enter RaisedHole
	 * @param numRow the row you wish to enter RaisedHole
	 * @author Adela Tullio
	 */
	public void initializeRaisedHole(int numColumn, int numRow) {
		this.grid[numColumn][numRow] = new RaisedHole();
	}
	
	/**
	* Method to get the contents of a Hole
	*@param numColumn is the column you wish to check
	*@param numRow is the row you wish to check
	*@return the contents within a hole
	*@author Adela Tullio
	*/
	public Hole getHole(int numColumn, int numRow) {
		return grid[numColumn][numRow];	
	}
	
	/**
	* A method to add a piece to the board
	* @param piece is the piece to add to the board
	* @param column is the column to add the piece to
	* @param row is the row to add the piece to
	* @author Kelly Harrison
	*/
	public void addPiece(Piece piece, int column, int row) throws IllegalArgumentException {
		checkValidSpace(column, row);
		if(piece instanceof Mushroom) {
			this.addMushroomPiece((Mushroom) piece, column, row);
		}
		else if(piece instanceof Fox) {
			this.addFoxPiece((Fox) piece, column, row);
		}
		else if(piece instanceof Rabbit) {
			this.addRabbitPiece((Rabbit) piece, column, row);
		}
	}
	
	/**
	 * A method to check if the puzzle is finished
	 * @return Boolean that shows if the gameBoard is completed (all rabbits in brown holes)
	 * @author Noah Mank
	 */
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
	
	/**
	* A method to move the fox piece on the board
	* @param name is the name of the fox piece
	* @param direction is the direction in which the fox will move
	* @author Noah Mank
	*/
	public void moveFoxPiece(Fox f, Direction direction) throws IllegalArgumentException {
		Point location;
		// Input fox is invalid
		if(!foxes.containsKey(f)) {
			throw new IllegalArgumentException("Fox is not valid, Choose another fox");
		}
		else {
			location = foxes.get(f);
		}
		// Check to see if direction is valid
		switch(direction) {
			case NORTH: case SOUTH:
				if((f.getDirection() != Direction.NORTH) && (f.getDirection() != Direction.SOUTH)) {
					throw new IllegalArgumentException("Direction is not valid, Choose either East or West");
				}
				break;
			case EAST: case WEST:
				if((f.getDirection() != Direction.EAST) && (f.getDirection() != Direction.WEST)) {
					throw new IllegalArgumentException("Direction is not valid, Choose either North or South");
				}
				break;
		}
		// Start move process by removing from initial locations (object and location are still stored locally)
		grid[location.x][location.y].removePiece(f);
		grid[location.x + f.getDirection().getX()][location.y + f.getDirection().getY()].removePiece(f);
		try {
			this.addFoxPiece(f, location.x + direction.getX(), location.y + direction.getY());
		}
		catch(IllegalArgumentException e) {
			grid[location.x][location.y].setPiece(f);
			grid[location.x + f.getDirection().getX()][location.y + f.getDirection().getY()].setPiece(f);
			throw new IllegalArgumentException("Cannot move the fox this way!");
		}
	}
	
	/**
	* A method to move the rabbit on the board
	* @param name the name of the rabbit to move
	* @param direction the direction in which the rabbit will move
	* @author Noah Mank
	*/
	public void moveRabbitPiece(Rabbit r, Direction direction) throws IllegalArgumentException {
		Point location = new Point();
		Point newLocation = new Point();
		if(!rabbits.containsKey(r)) {
			throw new IllegalArgumentException("Name is not valid, Choose another rabbit");
		}
		else {
			location.x = rabbits.get(r).x;
			location.y = rabbits.get(r).y;
			newLocation.x = rabbits.get(r).x;
			newLocation.y = rabbits.get(r).y;
		}
		if((location.x + direction.getX() >= this.numColumns) || (location.x + direction.getX() < 0) || (location.y + direction.getY() >= this.numRows) || (location.y + direction.getY() < 0)) {
			throw new IllegalArgumentException("Cannot move rabbit out of bounds");
		}
		// If heading directly into an empty space, invalid
		if(!grid[location.x + direction.getX()][location.y + direction.getY()].getIsOccupied()) {
			throw new IllegalArgumentException("Direction invalid, choose another");
		}
		else {
			// Until next empty hole is found
			while(grid[newLocation.x + direction.getX()][newLocation.y + direction.getY()].getIsOccupied()) {
				//check out of bound
				newLocation.x += direction.getX();
				newLocation.y += direction.getY();
			}
			if(newLocation.x > this.numColumns | newLocation.y> this.numRows){
				throw new IllegalArgumentException("Move is out of bounds");
			}
			addRabbitPiece(r, newLocation.x + direction.getX(), newLocation.y + direction.getY());
			grid[location.x][location.y].removePiece(r);
		}
	}
	
	/**
	* A method to add a rabbit to the board
	* @param piece the rabbit piece to add to the board
	* @param column is the column to add the rabbit piece to
	* @param row is the row to add the rabbit piece to
	* @throws IllegalArgumentException if a rabbit is placed within a brown hole to start
	* @author Kelly Harrison
	*/
	private void addRabbitPiece(Rabbit r, int column, int row) {
		grid[column][row].setPiece(r);
		this.rabbits.put(r, new Point(column, row));
	}
	
	/**
	* A method to add a fox piece to the board
	* @param f is the fox piece to add to the board
	* @param column is the column to add the fox piece to
	* @param row is the row to add the fox piece to
	* @throws IllegalArgumentException
	* @author Kelly Harrison
	*/
	private void addFoxPiece(Fox f, int column, int row) throws IllegalArgumentException {	
		Direction direction = f.getDirection();
		// Check we are within board bounds
		checkValidSpace(column + direction.getX(), row + direction.getX());
		if(grid[column][row] instanceof RaisedHole) {
			throw new IllegalArgumentException("Cannot place a Fox on a RaisedHole");
		}
		// checkValidSpace has already occurred for tail part, check head
		checkValidSpace(column + direction.getX(), row + direction.getY());
		// Check if tail or head holes are hills -> they shouldn't be
		if((grid[column][row] instanceof RaisedHole) || (grid[column + direction.getX()][row + direction.getY()] instanceof RaisedHole)) {
			throw new IllegalArgumentException("Foxes cannot be placed on raised holes, choose new location");
		}
		grid[column + direction.getX()][row + direction.getY()].setPiece(f);
		grid[column][row].setPiece(f);
		this.foxes.put(f, new Point(column, row));
	}
	
	/**
	* A method to add a mushroom piece to the board
	* @param piece is the mushroom piece to add to the board
	* @param column is the column to add the mushroom piece to
	* @param row is the row to add the mushroom piece to
	* @throws IllegalArgumentException if a mushroom is placed off the board or if
	* the space is not occupied and therefore not valid
	* @author Kelly Harrison
	*/
	private void addMushroomPiece(Mushroom piece, int column, int row) {
		grid[column][row].setPiece(piece);
		this.mushrooms.put(piece, new Point(column, row));
	}
	
	/**
	 * Getter for mushrooms HashMap
	 * @return HashMap containing all the mushroom pieces and respective Point locations
	 */
	public HashMap<Mushroom, Point> getMushrooms() {
		return this.mushrooms;
	}
	
	/**
	 * Getter for foxes HashMap
	 * @return HashMap containing all the fox pieces and respective Point locations
	 */
	public HashMap<Fox, Point> getFoxes() {
		return this.foxes;
	}
	
	/**
	 * Getter for rabbits HashMap
	 * @return HashMap containing all the rabbit pieces and respective Point locations
	 */
	public HashMap<Rabbit, Point> getRabbits() {
		return this.rabbits;
	}
	
	/**
	 * A method that throws IllegalArgumentException for checked space that is invalid
	 * @param column of space being checked
	 * @param row of space being checked
	 * @throws IllegalArgumentException if the space is off of the board or already occupied
	 * @author Noah Mank
	 */
	private void checkValidSpace(int column, int row) throws IllegalArgumentException {
		if(column >= numColumns || row >= numRows || column < 0 || row < 0 || grid[column][row].getIsOccupied()) {
			throw new IllegalArgumentException("Space is not valid, Choose another square");
		}
	}
}
