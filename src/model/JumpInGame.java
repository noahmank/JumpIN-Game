package model;

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
		if(gameStatus == GameStatus.READY_TO_PLAY) {
			gameStatus = GameStatus.IN_PROGRESS;
		}
		else {
			System.out.println("Your game is not ready to play");
		}
		
	}
	
	public void slideFox(String name, Direction direction) {
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
	}
}
