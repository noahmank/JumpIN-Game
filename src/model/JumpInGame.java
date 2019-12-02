package model;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

import view.*;


/**
 * Creates and starts the game, is the main interface with which the player interacts
 * @author Aubin Musingya
 *
 */
public class JumpInGame {
	private GameBoard gameBoard;
	private GameStatus gameStatus;
	private ArrayList<JumpInGameListener> views;
	private Stack<MoveAction> undoableMoveActions;
	private Stack<MoveAction> redoableMoveActions;
	private MoveablePiece selectedPiece;
	private Direction selectedDirection;
	private String consoleOutput;
	private BoardSolver solver;
	private int selectedChallenge;
	private int numChallenges;
	private BoardBuilder builder;
	/**
	 * the JumpInGame constructor builds the default game board
	 */
	public JumpInGame() {
		gameBoard = new GameBoard();
		views = new ArrayList<>();
		undoableMoveActions = new Stack<>();
		redoableMoveActions = new Stack<>();
		gameStatus = GameStatus.READY_TO_PLAY;
		selectedPiece = null;
		selectedDirection = null;
		consoleOutput = null;
		solver = null;
		selectedChallenge = 1;
		numChallenges = 3;
		builder = new BoardBuilder(gameBoard);
	}
	
	/**
	 * A method that calls movePiece function with the stored selectedPiece and selectedDirection
	 */
	public void movePiece() {
		movePiece(this.selectedPiece, this.selectedDirection);
	}
	
	/**
	* A method that calls the movePiece function with specific 
	* direction and piece used in undo and redo
	* @param move is the MoveAction 
	*/
	private void movePiece(MoveAction move) {
		movePiece(move.getPiece(), move.getDirection());
	}
	
	/**
	* movePiece method takes a moveable piece and moves it in the
	*specified direction
	* @param p is the moveable piece
	* @param direction is the direction in which you wish to move the piece
	*/
	private void movePiece(MoveablePiece p, Direction direction) {
		if(this.gameStatus == GameStatus.IN_PROGRESS) {
			if(gameBoard.canMovePiece(p, direction)) this.consoleOutput = p.toString() + " was moved " + direction.toString();
			else this.consoleOutput = p.toString() + " cannot be moved " + direction.toString();
			if(p instanceof Fox) gameBoard.moveFoxPiece((Fox) p, direction);
			if(p instanceof Rabbit) gameBoard.moveRabbitPiece((Rabbit) p, direction);
			notifyViews();
			undoableMoveActions.push(new MoveAction(p, direction));
			if(this.gameBoard.isFinished()) {
				this.consoleOutput = "Congratulations, you completed the game!";
				this.gameStatus = GameStatus.FINISHED;
				notifyViews();
			}
		}
	}
	
	/**
	 * the addPieceToBoard method adds the specified the object to the board
	 * @param piece is the object that is being added
	 * @param column is the column to which the piece is added
	 * @param row is the row in which the piece is added
	 */
	public void addPieceToBoard(Piece piece, int column, int row) {
		gameBoard.addPiece(piece, column, row);
		notifyViews();
	}

	
	/**
	* A method to reset the challenge,
	* resets all the pieces on the board
	*/
	public void resetChallenge() {
		gameBoard.resetAllPieces();
		notifyViews();
	}
	
	/**
	 * The challenge method constructs the board for the specified challenge
	 * @param challenge is the number that identifies the challenge
	 */
	public void startChallenge() {
		
		if(this.selectedChallenge == 1) {
			this.addPieceToBoard(new Rabbit(RabbitColor.GREY), 3, 0);
			this.addPieceToBoard(new Rabbit(RabbitColor.WHITE), 4, 2);
			this.addPieceToBoard(new Rabbit(RabbitColor.BROWN), 1, 4);
			this.addPieceToBoard(new Fox(Direction.SOUTH, 1), 1, 0);
			this.addPieceToBoard(new Fox(Direction.EAST, 2), 3, 3);
			this.addPieceToBoard(new Mushroom(), 3, 1);
			this.addPieceToBoard(new Mushroom(), 2, 4);
		}
		else if(this.selectedChallenge ==  2) {
			this.addPieceToBoard(new Mushroom(), 0, 1);
			this.addPieceToBoard(new Mushroom(), 0, 2);
			this.addPieceToBoard(new Mushroom(), 0, 4);
			this.addPieceToBoard(new Rabbit(RabbitColor.GREY), 1, 0);
			this.addPieceToBoard(new Rabbit(RabbitColor.BROWN), 3, 0);
			this.addPieceToBoard(new Rabbit(RabbitColor.WHITE), 4, 1);
			this.addPieceToBoard(new Fox(Direction.NORTH, 1), 1, 2);
			this.addPieceToBoard(new Fox(Direction.WEST, 2), 2, 3);
		}
		else if(this.selectedChallenge == 3) {
			this.addPieceToBoard(new Rabbit(RabbitColor.GREY), 0, 3);
			this.addPieceToBoard(new Rabbit(RabbitColor.WHITE), 3, 1);
			this.addPieceToBoard(new Rabbit(RabbitColor.BROWN), 4, 2);
			this.addPieceToBoard(new Mushroom(), 3, 0);
			this.addPieceToBoard(new Mushroom(), 2, 2);
			this.addPieceToBoard(new Mushroom(), 4, 4);
			this.addPieceToBoard(new Fox(Direction.EAST, 1), 0, 1);
			this.addPieceToBoard(new Fox(Direction.WEST, 2), 3, 3);
		}
		else {
			String c = "Challenge " + selectedChallenge;
			try {
				this.gameBoard = GameBoard.importFromXML(c);
			} catch(Exception e) {
				System.out.println("Challenge doesn't exists");
			}
		}
		this.gameStatus = GameStatus.IN_PROGRESS;
		this.consoleOutput = "Challenge " + this.selectedChallenge + ": Started";
		notifyViews();
	}
	
	/**
	 * undo the last action recorded in the undoableMoveActions stack and store in redoableMoveActions stack
	 * @throws EmptyStackException
	 */
	public void undoMoveAction() throws EmptyStackException {
		if(this.undoableMoveActions.isEmpty()) return;
		MoveAction move = undoableMoveActions.pop();
		// Do the opposite with the piece
		movePiece(move.getOppositeMove());
		// Remove MoveAction that was added to undoableMoveActions when undone
		undoableMoveActions.pop();
		redoableMoveActions.push(move);
	}
	
	/**
	 * redo the last action recorded in the redoableMoveActions stack and restore in undoableMoveActions stack
	 * @throws EmptyStackException
	 */
	public void redoMoveAction() throws EmptyStackException {
		if(this.redoableMoveActions.isEmpty()) return;
		MoveAction move = redoableMoveActions.pop();
		movePiece(move);
	}
	
	/**
	 * Getter to allow access to gameBoard
	 * @return the stored GameBoard
	 */
	public GameBoard getBoard() {
		return this.gameBoard;
	}
	
	/**
	 * Add a view to watch any changes in the game
	 * @param v is the view to be added to the views collection
	 */
	public void addView(JumpInGameListener v) {
		this.views.add(v);
	}
	
	/**
	 * Remove a view from those watching the game
	 * @param v is the view to be removed from the views collection
	 */
	public void removeView(JumpInGameListener v) {
		this.views.remove(v);
	}
	
	/**
	 * Tell any views that a change has been made in the game
	 * @param s is a message describing the change
	 */
	public void notifyViews() {
		for(JumpInGameListener v : views) {
			v.updateView();
		}
	}
	
	/**
	* a setter for the piece
	* @param piece is the piece you wish to set it to
	*/
	public void setPiece(MoveablePiece piece) {
		this.selectedPiece = piece;
	}
	
	/**
	* a setter for the direction
	* @param direction is the direction you wish to set it to
	*/
	public void setDirection(Direction direction) {
		this.selectedDirection = direction;
	}
	
	/**
	* gets the piece value
	* @return the value of the MoveablePiece object
	*/
	public Piece getPiece() {
		return this.selectedPiece;
	}
	
	/**
	* gets the direction
	* @return the specified direction
	*/
	public Direction getDirection() {
		return this.selectedDirection;
	}
	
	/**
	* getter for console ouput
	* @return the colsole output as a string
	*/
	public String getConsoleOutput() {
		return consoleOutput;
	}
	
	/**
	* a setter for the console output
	* @param s is the string value you wish to set as the console output
	*/
	public void setConsoleOutput(String s) {
		this.consoleOutput = s;
		notifyViews();
	}

	/**
	* a method that solves the game
	*/
	public void solveGame() {
		this.solver = new BoardSolver(this.gameBoard);
		solver.solveBoard();
	}
	
	public boolean gameIsSolved() {
		return (this.solver.getSolvedBoard() != null);
	}
	/**
	* a method that calculates the next move for the solution
	*/
	public void doNextMoveFromSolution() {
		MoveAction nextMove = this.solver.getNextActionToSolve();
		if(nextMove != null) this.movePiece(nextMove);
	}
	
	/**
	* a setter for the challenge of the board
	* @param i is the level number you wish to set the challenge to
	*/
	public void setSelectedChallenge(int i) {
		if(i > 0 && i <= this.numChallenges) this.selectedChallenge = i;
	}
	
	/**
	* a getter for the selected challenge
	* @return an integer of the challenge level that is 
	* the current selected challenge
	*/
	public int getSelectedChallenge() {
		return this.selectedChallenge;
	}
	
	/**
	* a getter for the number of challenges available
	* @return integer value of the number of challenges
	*/
	public int getNumChallenges() {
		return this.numChallenges;
	}
	
	/**
	* Saves the piece desired to move
	* @param column is the column the piece is located at
	* @param row is the row the piece is located at
	*/
	public void savePieceToMove(int column, int row) {
		Piece p = this.gameBoard.getPieceFromGrid(column, row);
		if(p instanceof MoveablePiece) this.selectedPiece = (MoveablePiece) p; 
	}
	
	/**
	* A getter for the board the user wishes to build
	* @return the builder
	*/
	public BoardBuilder getBuilder() {
		return this.builder;
	}
	
	public void generateNewLevel() {
		numChallenges++;
		XMLLevel levelToXML = new XMLLevel("Challenge " + numChallenges, this.gameBoard);
		levelToXML.exportBoardlevelToXML();
	}

}
