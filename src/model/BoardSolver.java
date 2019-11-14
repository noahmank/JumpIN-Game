package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class BoardSolver {
	GameBoard initialBoard;
	BoardTree boardTree;
	ArrayList<MoveAction> solution;
	LinkedList<BoardTreeNode> checkNodes;
	
	public BoardSolver(GameBoard board) {
		this.initialBoard = board;
		BoardTreeNode root = new BoardTreeNode(board, null);
		checkNodes = new LinkedList<>();
		solution = new ArrayList<>();
	}
	
	public ArrayList<MoveAction> solveBoard() {
		checkNodes.add(boardTree.getRoot());
		BoardTreeNode checkNode = checkNodes.pop();
		if(checkNode.getBoard().isFinished()) {
			return solution;
		}
		else {
			
		}
		
		return null;
	}
	
	public GameBoard getSolvedBoard() {
		return null;
	}
	
	private void populateBoardTree(GameBoard board) {
		for(Rabbit r : board.getRabbits().keySet()) {
			
		}
		for(Fox f : board.getFoxes().keySet()) {
			
		}
	}
}
