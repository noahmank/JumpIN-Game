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
	private ArrayList<View> views;
	private Stack<MoveAction> undoableMoveActions;
	private Stack<MoveAction> redoableMoveActions;
	private MoveablePiece piece;
	private Direction direction;
	private String consoleOutput;

	/**
	 * the JumpInGame constructor builds the default game board
	 */
	public JumpInGame() {
		gameBoard = new GameBoard();
		views = new ArrayList<>();
		undoableMoveActions = new Stack<>();
		redoableMoveActions = new Stack<>();
		gameStatus = GameStatus.READY_TO_PLAY;
		piece = null;
		direction = null;
		consoleOutput = null;
	}
	
	public void movePiece(MoveAction move) {
		movePiece(move.getPiece(), move.getDirection());
	}
	
	public void movePiece(MoveablePiece p, Direction direction) {
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
	}
	
	/**
	 * The challenge method constructs the board for the specified challenge
	 * @param challenge is the number that identifies the challenge
	 */
	public void challenge(int challenge) {
		
		if(challenge == 1) {
			System.out.println("Challenge 1 started.");
			this.addPieceToBoard(new Rabbit(RabbitColor.GREY), 3, 0);
			this.addPieceToBoard(new Rabbit(RabbitColor.WHITE), 4, 2);
			this.addPieceToBoard(new Rabbit(RabbitColor.BROWN), 1, 4);
			this.addPieceToBoard(new Fox(Direction.SOUTH, 1), 1, 0);
			this.addPieceToBoard(new Fox(Direction.EAST, 2), 3, 3);
			this.addPieceToBoard(new Mushroom(), 3, 1);
			this.addPieceToBoard(new Mushroom(), 2, 4);
			this.consoleOutput = "Challenge 1: Started";
			this.gameStatus = GameStatus.IN_PROGRESS;
			notifyViews();
		}
		else if(challenge ==  2) {
			System.out.println("Challenge 2 started.");
			this.addPieceToBoard(new Mushroom(), 0, 1);
			this.addPieceToBoard(new Mushroom(), 0, 2);
			this.addPieceToBoard(new Mushroom(), 0, 4);
			this.addPieceToBoard(new Rabbit(RabbitColor.GREY), 1, 0);
			this.addPieceToBoard(new Rabbit(RabbitColor.BROWN), 3, 0);
			this.addPieceToBoard(new Rabbit(RabbitColor.WHITE), 4, 1);
			this.addPieceToBoard(new Fox(Direction.NORTH, 1), 1, 2);
			this.addPieceToBoard(new Fox(Direction.WEST, 2), 2, 3);
			this.consoleOutput = "Challenge 2: Started";
			this.gameStatus = GameStatus.IN_PROGRESS;
			notifyViews();
		}
		else if(challenge == 3) {
			System.out.println("Challenge 3 started.");
			this.addPieceToBoard(new Rabbit(RabbitColor.GREY), 0, 3);
			this.addPieceToBoard(new Rabbit(RabbitColor.WHITE), 3, 1);
			this.addPieceToBoard(new Rabbit(RabbitColor.BROWN), 4, 2);
			this.addPieceToBoard(new Mushroom(), 3, 0);
			this.addPieceToBoard(new Mushroom(), 2, 2);
			this.addPieceToBoard(new Mushroom(), 4, 4);
			this.addPieceToBoard(new Fox(Direction.EAST, 1), 0, 1);
			this.addPieceToBoard(new Fox(Direction.WEST, 2), 3, 3);
			this.consoleOutput = "Challenge 3: Begun";
			this.gameStatus = GameStatus.IN_PROGRESS;
			notifyViews();
		}
	}
	
	/**
	 * undo the last action recorded in the undoableMoveActions stack and store in redoableMoveActions stack
	 * @throws EmptyStackException
	 */
	public void undoMoveAction() throws EmptyStackException {
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
	public void addView(View v) {
		this.views.add(v);
	}
	
	/**
	 * Remove a view from those watching the game
	 * @param v is the view to be removed from the views collection
	 */
	public void removeView(View v) {
		this.views.remove(v);
	}
	
	/**
	 * Tell any views that a change has been made in the game
	 * @param s is a message describing the change
	 */
	public void notifyViews() {
		for(View v : views) {
			v.updateView();
		}
	}
	
	public void setPiece(MoveablePiece piece) {
		this.piece = piece;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public MoveablePiece getPiece() {
		return this.piece;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public String getConsoleOutput() {
		return consoleOutput;
	}
	
	public void setConsoleOutput(String s) {
		this.consoleOutput = s;
	}

}
