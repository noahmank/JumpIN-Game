package model;

public class JumpInGame {
	private GameBoard gameBoard;
	private GameStatus gameStatus;
	
	public JumpInGame() {
		gameBoard = new GameBoard();
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
	}
	
	public void jumpRabbit(String name, Direction direction) {
		gameBoard.moveRabbitPiece(name, direction);
	}
}
