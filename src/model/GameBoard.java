package model;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
* Creates and initializes the playing gameboard, and provides methods to add and move pieces
*/
public class GameBoard {
	private static final int DEFAULT_COLUMNS = 5;
	private static final int DEFAULT_ROWS = 5;
	private int numColumns;
	private int numRows;
	private Hole[][] grid;
	private LinkedHashMap<Rabbit, Point> rabbits;
	private LinkedHashMap<Fox, Point> foxes;
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
		this.foxes = new LinkedHashMap<>();
		this.rabbits = new LinkedHashMap<>();
		this.mushrooms = new HashMap<>();
	}
	
	/**
	* Constructor to initialize a gameboard by calling the default constructor
	* and initializing the variables
	* @param board is the gameboard
	*/
	public GameBoard(GameBoard board) {
		this();
		this.foxes = new LinkedHashMap<>(board.getFoxes());
		this.rabbits = new LinkedHashMap<>(board.getRabbits());
		this.mushrooms = new HashMap<>(board.getMushrooms());
		HashMap<Piece, Point> pieces = new HashMap<>();
		pieces.putAll(this.mushrooms);
		pieces.putAll(this.foxes);
		pieces.putAll(this.rabbits);
		for(Piece p : pieces.keySet()) {
			Point point = pieces.get(p);
			this.addPiece(p, point.x, point.y);
		}
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
	* A method to apply an action to the board
	* @param p is the moveable piece you wish to apply an action to
	* @param d is the direction you wish to move this moveable piece to
	* @return new GameBoard with the moved pieces on it
	*/
	public GameBoard applyActionToBoard(MoveablePiece p, Direction d) {
		GameBoard b = new GameBoard(this);
		if(p instanceof Rabbit) b.moveRabbitPiece((Rabbit) p, d);
		if(p instanceof Fox) b.moveFoxPiece((Fox) p, d);
		return b;
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
	* Resets all the pieces on the board
	*/
	public void resetAllPieces() {
		resetDefaultBoard();
		this.foxes.clear();
		this.rabbits.clear();
		this.mushrooms.clear();
	}
	
	/**
	* gets the number of columns within the board
	* @return integer number of columns on the gameboard
	*/
	public int getNumColumns() {
		return numColumns;
	}
	
	/**
	* gets the number of rows within the board
	* @return integer number of rows on the gameboard
	*/
	public int getNumRows() {
		return numRows;
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
	public void addPiece(Piece piece, int column, int row) {
		spaceIsEmpty(column, row);
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
	* gets the gameboard grid of holes
	* @return grid of holes
	*/
	public Hole[][] getGrid() {
		return grid;
	}
	
	/**
	* sets the grid 
	* @param grid is a grid of holes to set it to
	*/
	public void setGrid(Hole[][] grid) {
		this.grid = grid;
	}
	
	/**
	* sets the rabbits
	* @param rabbits is a linkedhashmap of the rabbits and locations you wish to set it to
	*/
	public void setRabbits(LinkedHashMap<Rabbit, Point> rabbits) {
		this.rabbits = rabbits;
	}
	
	/**
	* sets the foxes
	* @param foxes is the linkedhashmap of foxes and locations you wish to set it to
	*/
	public void setFoxes(LinkedHashMap<Fox, Point> foxes) {
		this.foxes = foxes;
	}
	
	/**
	* sets the mushrooms
	* @param mushrooms is the hashmap of mushrooms and locations you wish to set it to
	*/
	public void setMushrooms(HashMap<Mushroom, Point> mushrooms) {
		this.mushrooms = mushrooms;
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
	* method to determine if the user is able to move a fox
	* @param f is the fox that is being determined if it can move
	* @direction is the direction the user is seeing if it can move
	* @return true or false whether the fox can move or not
	*/
	public boolean canMoveFox(Fox f, Direction direction) {
		Point tailLocation;
		Point headLocation;
		// Input fox is invalid
		if(!foxes.containsKey(f)) return false;
		else tailLocation = foxes.get(f);
		
		tailLocation = new Point(tailLocation.x + direction.getX(), tailLocation.y + direction.getY());
		headLocation = new Point(tailLocation.x + f.getDirection().getX(), tailLocation.y + f.getDirection().getY());
		
		// Check to see if move direction is on same axis as fox
		if(!(f.getDirection() == direction || f.getDirection() == direction.getOpposite())) return false;
		// Check to see if fox is being moved into a hole on the board
		if(!(spaceIsOnBoard(tailLocation.x, tailLocation.y) && spaceIsOnBoard(tailLocation.x + f.getDirection().getX(), tailLocation.y + f.getDirection().getY()))) return false;
		// Check to see if fox tail is being moved to a space not occupied by itself
		if(!spaceIsEmpty(tailLocation.x, tailLocation.y)) {
			if(!grid[tailLocation.x][tailLocation.y].getPiece().equals(f)) return false;
		}
		// Check to see if fox head is being moved to a space not occupied by itself
		if(!spaceIsEmpty(headLocation.x, headLocation.y)) {
			if(!grid[headLocation.x][headLocation.y].getPiece().equals(f)) return false;
		}
		return true;
	}
	
	/**
	* method to determine if the user is able to move a rabbit
	* @param r is the rabbit that is being determined if it can move
	* @direction is the direction the user is seeing if it can move
	* @return true or false whether the rabbit can move or not
	*/
	public boolean canMoveRabbit(Rabbit r, Direction direction) {
		Point currentLocation;
		if(!rabbits.containsKey(r)) return false;
		else currentLocation = rabbits.get(r);
		
		currentLocation = new Point(currentLocation.x + direction.getX(), currentLocation.y + direction.getY());
		// Check to see that it is not trying to jump out of grid
		if(!spaceIsOnBoard(currentLocation.x, currentLocation.y)) return false;
		// Check to see if there is at least one valid object to jump over in that direction
		if(grid[currentLocation.x][currentLocation.y].isOccupied()) {
			// Keep moving along the same direction until either an empty hole or off the board
			while(spaceIsOnBoard(currentLocation.x, currentLocation.y)) {
				if(!grid[currentLocation.x][currentLocation.y].isOccupied()) return true;
				currentLocation = new Point(currentLocation.x + direction.getX(), currentLocation.y + direction.getY());
			}
		}
		return false;
	}
	
	/**
	* method to determine if a moveable piece can be moved
	* @param p is the piece to determine if it can move
	* @param direction is the direction the user wishes to see if it can move
	* @return true or false if the moveable piece can move or not
	*/
	public boolean canMovePiece(MoveablePiece p, Direction direction) {
		if(p instanceof Fox) return canMoveFox((Fox) p, direction);
		if(p instanceof Rabbit) return canMoveRabbit((Rabbit) p, direction);
		return false;
	}
	
	/**
	* A method to move the fox piece on the board
	* @param name is the name of the fox piece
	* @param moveDirection is the direction in which the fox will move
	* @author Noah Mank
	*/
	public void moveFoxPiece(Fox f, Direction moveDirection) {
		if(canMoveFox(f, moveDirection)) {
			Point location = foxes.get(f);
			// Remove from previous location
			grid[location.x][location.y].removePiece(f);
			grid[location.x + f.getDirection().getX()][location.y + f.getDirection().getY()].removePiece(f);
			// Add to new location
			location = new Point(location.x + moveDirection.getX(), location.y + moveDirection.getY());
			grid[location.x][location.y].setPiece(f);
			grid[location.x + f.getDirection().getX()][location.y + f.getDirection().getY()].setPiece(f);
			// Update in HashMap
			this.foxes.put(f, location);
		}
	}
	
	/**
	* A method to move the rabbit on the board
	* @param name the name of the rabbit to move
	* @param direction the direction in which the rabbit will move
	* @author Noah Mank
	*/
	public void moveRabbitPiece(Rabbit r, Direction direction) {
		if(canMoveRabbit(r, direction)) {
			Point currentLocation = rabbits.get(r);
			grid[currentLocation.x][currentLocation.y].removePiece(r);
			currentLocation = new Point(currentLocation.x + direction.getX(), currentLocation.y + direction.getY());
			while(grid[currentLocation.x][currentLocation.y].isOccupied()) {
				currentLocation = new Point(currentLocation.x + direction.getX(), currentLocation.y + direction.getY());
			}
			addRabbitPiece(r, currentLocation.x, currentLocation.y);		
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
	private void addFoxPiece(Fox f, int column, int row) {	
		Direction d = f.getDirection();
		if(canAddFox(f, column, row)) {
			grid[column + d.getX()][row + d.getY()].setPiece(f);
			grid[column][row].setPiece(f);
			this.foxes.put(f, new Point(column, row));
		}
	}
	
	/**
	* method to determine if a fox can be added to a certain hole
	* @param f is the fox to be added
	* @param column is the column the user wishes to add it to
	* @param row is the row the user wishes to add it to
	* @return true or false whether the fox can be added to that location
	*/
	public boolean canAddFox(Fox f, int column, int row) {
		Direction direction = f.getDirection();
		// Check that Fox is within board bounds and on empty hole, tail has already been checked
		if(spaceIsEmpty(column + direction.getX(), row + direction.getY())) {
			// Check that Fox is not being placed on a RaisedHole
			if((grid[column][row] instanceof RaisedHole) || (grid[column + direction.getX()][row + direction.getY()] instanceof RaisedHole)) {
				return false;
			}
			return true;
		}
		else return false;
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
	public LinkedHashMap<Fox, Point> getFoxes() {
		return this.foxes;
	}
	
	/**
	 * Getter for rabbits HashMap
	 * @return HashMap containing all the rabbit pieces and respective Point locations
	 */
	public LinkedHashMap<Rabbit, Point> getRabbits() {
		return this.rabbits;
	}
	
	/**
	 * A method that throws IllegalArgumentException for checked space that is invalid
	 * @param column of space being checked
	 * @param row of space being checked
	 * @throws IllegalArgumentException if the space is off of the board or already occupied
	 * @author Noah Mank
	 */
	private boolean spaceIsEmpty(int column, int row) {
		return (spaceIsOnBoard(column, row) && !grid[column][row].isOccupied());
	}
	
	/**
	* method to determine if a certain point is on the board
	* @param column is the specified column you wish to check
	* @param row is the specified row you wish to check
	* @return true or false if the point is on the board or not
	*/
	private boolean spaceIsOnBoard(int column, int row) {
		return !(column >= numColumns || row >= numRows || column < 0 || row < 0);
	}
	
	/**
	* equals method to compare two objects of gameboard
	* @param obj is the object to be comapred
	* @return true or false if the objects are equals or not
	*/
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		GameBoard b = (GameBoard) obj;
		return b.toString().equals(this.toString());
	}
}
