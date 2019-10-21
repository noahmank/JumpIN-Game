package model;

import java.util.Scanner;

/**
 * 
 * @author
 *
 */
public class JumpInGame {
	private GameBoard gameBoard;
	private GameStatus gameStatus;
	private Scanner scanner;
	
	/**
	 * the JumpInGame constructor builds the default game board
	 */
	public JumpInGame() {
		gameBoard = new GameBoard();
		gameStatus = GameStatus.READY_TO_PLAY;
	}
	
	
	/**
	 * the getGameStatus method retrieves the status of the game
	 * @return READY_TO_PLAY, IN_PROGRESS or FINISHED
	 */
	public GameStatus getGameStatus() {
		return gameStatus;
	}

	/**
	 * the start method verifies if the game is ready to play
	 */
	public void start() {
		// Will always be true for now
		if(gameStatus == GameStatus.READY_TO_PLAY) {
			gameStatus = GameStatus.IN_PROGRESS;
		}
		else {
			System.out.println("Your game is not ready to play");
		}
		
		System.out.println("			Welcome to The JumpIn Game.");
		System.out.println("GAME RULES\n 1) Select a challenge (Numbers between 1 and 1).\n "
				+ "2) The Objective of the game is to move the rabbits and foxes around the gameboard until all of the rabbits are safe in brown holes.\n"
				+ " 3) You have found a solution when all of the rabbits are inside brown holes!\n");
		
		System.out.println("Enter which level you would like to play (Starting at 1, only 1 is available for now): ");
		
		scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		
		System.out.println("\n");
		
		this.challenge(input);
		
		do {
			
			System.out.println("Select a moveable piece from the list above that you would like to move (Use Legend title e.g F1 or WR): ");
			
			String piece = scanner.next();
			
			if(piece.equals("WR") | piece.equals("GR") | piece.equals("BR")) {
			
				System.out.println("");
				System.out.println("You can move the Rabbit EAST, WEST, NORTH or SOUTH.\n Enter the direction in which you would like to move the rabbit: ");
				
				String directionInput = scanner.next();
				
				Direction Rdirection = (directionInput.toUpperCase().equals("EAST"))? Direction.EAST : (directionInput.toUpperCase().equals("WEST"))? Direction.WEST :(directionInput.toUpperCase().equals("NORTH"))? Direction.NORTH : (directionInput.toUpperCase().equals("SOUTH"))? Direction.SOUTH : null;
				
				try{
					this.jumpRabbit(piece, Rdirection);
				}
				catch(Exception e) {
					System.out.println("Direction invalid, choose another.\n");
					System.out.println("\n");
				}

			}
			
			if(piece.equals("F1") | piece.equals("F2")) {
				
				System.out.println("");
				System.out.println("You can slide the fox parallel to its current position.\n"
						+ "Enter the direction in which you would like to slide the fox: ");
				
				String directionInput = scanner.next();
				
				Direction Fdirection = (directionInput.toUpperCase().equals("EAST"))? Direction.EAST : (directionInput.toUpperCase().equals("WEST"))? Direction.WEST :(directionInput.toUpperCase().equals("NORTH"))? Direction.NORTH : (directionInput.toUpperCase().equals("SOUTH"))? Direction.SOUTH : null;
				
				try{
					this.slideFox(piece, Fdirection);
				}
				catch(Exception e) {
					System.out.println("Direction invalid, choose another.\n");
				}
			}
			
		}while(this.getGameStatus() == GameStatus.IN_PROGRESS);
		
		gameStatus = (this.gameBoard.isFinished())? GameStatus.FINISHED: GameStatus.IN_PROGRESS;
		
	}
	
	/**
	 * the slideFox method performs the movement of the fox (sliding parallel to its location)
	 * @param name is the identity of the fox e.g F1
	 * @param direction is the desired direction that the fox is being moved to
	 */
	public void slideFox(String name, Direction direction) {
		gameBoard.moveFoxPiece(name, direction);
		System.out.println("");
		displayBoard();
	}
	
	/**
	 * the jumpRabbit method performs the movement of the rabbit (jumping over obstacles)
	 * @param name is the identity of the rabbit e.g Black
	 * @param direction is the desired direction that the rabbit is being moved to
	 */
	public void jumpRabbit(String name, Direction direction) {
		gameBoard.moveRabbitPiece(name, direction);
		System.out.println("");
		displayBoard();
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
			this.addPieceToBoard(new Rabbit("Grey"), 3, 0);
			this.addPieceToBoard(new Rabbit("White"), 4, 2);
			this.addPieceToBoard(new Rabbit("Brown"), 1, 4);
			this.addPieceToBoard(new Fox(Direction.SOUTH, 1), 1, 0);
			this.addPieceToBoard(new Fox(Direction.EAST, 2), 3, 3);
			this.addPieceToBoard(new Mushroom(), 3, 1);
			this.addPieceToBoard(new Mushroom(), 2, 4);
			displayBoard();
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		JumpInGame game = new JumpInGame();
		game.start();
	}
}
