package model;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author noahmank with contributions from Aubin and kelly
 *
 */
public class BoardSolver {
	GameBoard initialBoard;
	BoardTree boardTree;
	LinkedList<BoardTreeNode> checkNodes;
	BoardTreeNode solvedNode;
	Stack<MoveAction> solution;
	
	/**
	 * Constructs the Board solver with the given board game
	 * @param board GameBoard object 
	 */
	public BoardSolver(GameBoard board) {
		this.initialBoard = board;
		// Root node has no action and no parent
		boardTree = new BoardTree(new BoardTreeNode(board, null, null));
		checkNodes = new LinkedList<>();
		solvedNode = null;
		solution = new Stack<>();
	}
	
	/**
	 * Begins to solve the board by iterating through possible solutions
	 * @return the solution, containing all the actions performed to solve challenge
	 */
	public void solveBoard() {
		BoardTreeNode checkNode;
		checkNodes.add(boardTree.getRoot());
		
		while(!checkNodes.isEmpty()) {
			checkNode = checkNodes.pop();
			if(checkNode.getBoard().isFinished()) {
				solvedNode = checkNode;
				calculateActionsToSolve();
			}
			else {
				checkNode.populateChildren();
				checkNodes.addAll(checkNode.getChildren());
			}
		}
		// solvedNode will be null if no solution
	}
	
	/**
	 * Gets the solved board with the actions performed
	 * @return GameBoard Object
	 */
	public GameBoard getSolvedBoard() {
		return solvedNode.getBoard();
	}
	
	private void calculateActionsToSolve() {
		BoardTreeNode currentNode = solvedNode;
		
		// Need to go up through tree from node, adding the actions that have happened to stack
		while(!currentNode.isRoot()) {
			solution.add(currentNode.getAction());
			currentNode = currentNode.getParent();
		}
	}
	
	public MoveAction getNextActionToSolve() {
		return solution.pop();
	}
}
