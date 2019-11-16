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
	Stack<MoveAction> solution;
	LinkedList<BoardTreeNode> checkNodes;
	
	/**
	 * Constructs the Board solver with the given board game
	 * @param board GameBoard object 
	 */
	public BoardSolver(GameBoard board) {
		this.initialBoard = board;
		// Root node has no action and no parent
		boardTree = new BoardTree(new BoardTreeNode(board, null, null));
		checkNodes = new LinkedList<>();
		solution = new Stack<>();
	}
	
	/**
	 * Begins to solve the board by iterating through possible solutions
	 * @return the solution, containing all the actions performed to solve challenge
	 */
	public Stack<MoveAction> solveBoard() {
		BoardTreeNode checkNode;
		checkNodes.add(boardTree.getRoot());
		
		while(!checkNodes.isEmpty()) {
			checkNode = checkNodes.pop();
			if(checkNode.getBoard().isFinished()) {
				// Need to go up through tree from node, adding the actions that have happened to stack
				while(!checkNode.isRoot()) {
					solution.add(checkNode.getAction());
					checkNode = checkNode.getParent();
				}
				return solution;
			}
			else {
				checkNode.populateChildren();
				checkNodes.addAll(checkNode.getChildren());
			}
		}
		// No possible solution
		return null;
	}
	
	/**
	 * Gets the solved board with the actions performed
	 * @return GameBoard Object
	 */
	public GameBoard getSolvedBoard() {
		return null;
	}
}
