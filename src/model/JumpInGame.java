package model;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Scanner;
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
	private ArrayList<JumpInView> views;
	private Stack<MoveAction> undoableMoveActions;
	private Stack<MoveAction> redoableMoveActions;
	/**
	 * the JumpInGame constructor builds the default game board
	 */
	public JumpInGame() {
		gameBoard = new GameBoard();
		views = new ArrayList<>();
		undoableMoveActions = new Stack<>();
		redoableMoveActions = new Stack<>();
		gameStatus = GameStatus.READY_TO_PLAY;
	}
	
	
	/**
	 * the start method verifies if the game is ready to play and initializes the JumpIn game
	 */
	/*
	public void start() {
		Scanner scanner;
		// Will always be true for now
		if(gameStatus == GameStatus.READY_TO_PLAY) {
			gameStatus = GameStatus.IN_PROGRESS;
		}
		else {
			System.out.println("Your game is not ready to play");
			return;
		}
		
		System.out.println("\t\t\tWelcome to The JumpIn Game.");
		System.out.println("GAME RULES\n 1) Select a challenge (Numbers between 1 and 1).\n "
				+ "2) The Objective of the game is to move the rabbits and foxes around the gameboard until all of the rabbits are safe in brown holes.\n"
				+ " 3) You have found a solution when all of the rabbits are inside brown holes!\n");
		
		System.out.println("Enter which level you would like to play (Starting at 1, only 1 is available for now): ");
		
		scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		System.out.println("\n");
		
		this.challenge(input);
		
		while(!this.gameBoard.isFinished()) {
			System.out.println("Select a moveable piece from the list above that you would like to move (Use Legend title e.g F1 or WR): ");
			
			String piece = scanner.next().toUpperCase();
			
			if(piece.equals("WR") | piece.equals("GR") | piece.equals("BR")) {
				System.out.println("\nYou can move the Rabbit EAST, WEST, NORTH or SOUTH.\n Enter the direction in which you would like to move the rabbit: ");
				
				String directionInput = scanner.next();
				Direction Rdirection = Direction.valueOf(directionInput.toUpperCase());
				
				try{
					this.jumpRabbit(piece, Rdirection);
				}
				catch(Exception e) {
					System.out.println("Direction invalid, choose another.\n");
				}
			}
			
			if(piece.equals("F1") | piece.equals("F2")) {
				System.out.println("\nYou can slide the fox parallel to its current position.\n"
						+ "Enter the direction in which you would like to slide the fox: ");
				
				String directionInput = scanner.next();
				Direction Fdirection = Direction.valueOf(directionInput.toUpperCase());
				
				try{
					this.slideFox(piece, Fdirection);
				}
				catch(Exception e) {
					System.out.println("Direction invalid, choose another.\n");
				}
			}
			
		}
		scanner.close();
		gameStatus = GameStatus.FINISHED;
		System.out.println("Congratulations! You have beat this level!");
	}
	*/
	
	
	public void movePiece(MoveablePiece p, Direction direction) {
		if(!gameBoard.isFinished()) {
			if(p instanceof Fox) gameBoard.moveFoxPiece((Fox) p, direction);
			if(p instanceof Rabbit) gameBoard.moveRabbitPiece((Rabbit) p, direction);
			notifyViews(p.toString() + " was moved " + direction.toString());
			undoableMoveActions.push(new MoveAction(p, direction));
			redoableMoveActions.clear();
			if(this.gameBoard.isFinished()) notifyViews("Congratulations, you completed the game!.");
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
			notifyViews("Challenge 1: Begun");
		}
	}
	
	/**
	 * undo the last action recorded in the undoableMoveActions stack and store in redoableMoveActions stack
	 * @throws EmptyStackException
	 */
	public void undoMoveAction() throws EmptyStackException {
		MoveAction move = undoableMoveActions.pop();
		// Do the opposite with the piece
		movePiece(move.getPiece(), move.getDirection().getOpposite());
		MoveAction newMove = undoableMoveActions.pop();
		redoableMoveActions.push(newMove);
	}
	
	/**
	 * redo the last action recorded in the redoableMoveActions stack and restore in undoableMoveActions stack
	 * @throws EmptyStackException
	 */
	public void redoMoveAction() throws EmptyStackException {
		MoveAction move = redoableMoveActions.pop();
		movePiece(move.getPiece(), move.getDirection());
		undoableMoveActions.push(move);
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
	public void addView(JumpInView v) {
		this.views.add(v);
	}
	
	/**
	 * Remove a view from those watching the game
	 * @param v is the view to be removed from the views collection
	 */
	public void removeView(JumpInView v) {
		this.views.remove(v);
	}
	
	/**
	 * Tell any views that a change has been made in the game
	 * @param s is a message describing the change
	 */
	public void notifyViews(String s) {
		for(JumpInView v : views) {
			v.updateView(s);
		}
	}
}
