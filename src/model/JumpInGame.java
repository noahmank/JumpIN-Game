package model;

import java.util.Scanner;

public class JumpInGame {
	private GameBoard gameBoard;
	private GameStatus gameStatus;
	
	public JumpInGame() {
		gameBoard = new GameBoard();
		displayBoard();
		gameStatus = GameStatus.READY_TO_PLAY;
	}
	
	// Needs to check if game is ready to play
	public void start() {
		String name;
		Direction direction;
		if(gameStatus == GameStatus.READY_TO_PLAY) {
			gameStatus = GameStatus.IN_PROGRESS;
			while(!gameBoard.isFinished()) {
				Scanner sc = new Scanner(System.in);
				try {
					System.out.println("Enter a label:");
					name = sc.next();
					System.out.println("Enter a direction:");
					direction = Direction.valueOf(sc.next());
				}
				catch(Exception e) {
					System.out.println("Please input a valid label and direction");
				}
			}
		}
		else {
			System.out.println("Your game is not ready to play");
		}
		
	}
	
	public void slideFox(String name, Direction direction) throws IllegalArgumentException{
		gameBoard.moveFoxPiece(name, direction);
		displayBoard();
	}
	
	public void jumpRabbit(String name, Direction direction) {
		gameBoard.moveRabbitPiece(name, direction);
		displayBoard();
	}
	
	public void displayBoard() {
		System.out.println(gameBoard.toString());
		System.out.println(gameBoard.getLegend());
	}
	public void addPieceToBoard(Piece piece, int column, int row) {
		gameBoard.addPiece(piece, column, row);
		displayBoard();
	}
	
	public static void main(String[] args) {
		System.out.println("Test");
		JumpInGame game = new JumpInGame();
		game.addPieceToBoard(new Rabbit("Brown"), 3, 3);
		game.start();
	}
}
