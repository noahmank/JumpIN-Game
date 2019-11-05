package model;

import java.util.ArrayList;
import java.util.Scanner;

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
	
	/**
	 * the JumpInGame constructor builds the default game board
	 */
	public JumpInGame() {
		gameBoard = new GameBoard();
		views = new ArrayList<>();
		gameStatus = GameStatus.READY_TO_PLAY;
	}
	
	/**
	 * the start method verifies if the game is ready to play and initializes the JumpIn game
	 */
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
			displayBoard();
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
	
	/**
	 * the slideFox method performs the movement of the fox (sliding parallel to its location)
	 * @param name is the identity of the fox e.g F1
	 * @param direction is the desired direction that the fox is being moved to
	 */
	public void slideFox(String name, Direction direction) {
		if(!gameBoard.isFinished()) {
			try {
				gameBoard.moveFoxPiece(name, direction);
				notifyViews(name + " was moved " + direction.toString());
			}
			catch(IllegalArgumentException e) {
				notifyViews(e.getMessage());
			}
			if(this.gameBoard.isFinished()) notifyViews("Congratulations, you completed the game!.");
		}
	}
	
	/**
	 * the jumpRabbit method performs the movement of the rabbit (jumping over obstacles)
	 * @param name is the identity of the rabbit e.g Black
	 * @param direction is the desired direction that the rabbit is being moved to
	 */
	public void jumpRabbit(String name, Direction direction) {
		if(!gameBoard.isFinished()) {
			try {
				gameBoard.moveRabbitPiece(name, direction);
				notifyViews(name + " was moved " + direction.toString());
			}
			catch(IllegalArgumentException e) {
				notifyViews(e.getMessage());
			}
			if(this.gameBoard.isFinished()) notifyViews("Congratulations, you completed the game!.");
		}
	}
	
	/**
	 * the displayBoard method reflects the appearance of the board
	 */
	public void displayBoard() {
		System.out.println(gameBoard.toString());
		System.out.println(gameBoard.getLegend());
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
			this.addPieceToBoard(new Rabbit("Grey"), 3, 0);
			this.addPieceToBoard(new Rabbit("White"), 4, 2);
			this.addPieceToBoard(new Rabbit("Brown"), 1, 4);
			this.addPieceToBoard(new Fox(Direction.SOUTH, 1), 1, 0);
			this.addPieceToBoard(new Fox(Direction.EAST, 2), 3, 3);
			this.addPieceToBoard(new Mushroom(), 3, 1);
			this.addPieceToBoard(new Mushroom(), 2, 4);
			notifyViews("Challenge 1: Begun");
		}
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
