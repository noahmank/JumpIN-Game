package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 
 * @author noahmank with contributions from Aubin and kelly
 *
 */
public class BoardSolver {
	private GameBoard initialBoard;
	private BoardTree boardTree;
	private LinkedList<BoardTreeNode> nodesToCheck;
	private BoardTreeNode solvedNode;
	private Stack<MoveAction> solution;
	private ArrayList<BoardTreeNode> checkedNodes;
	
	/**
	 * Constructs the Board solver with the given board game
	 * @param board GameBoard object 
	 */
	public BoardSolver(GameBoard board) {
		this.initialBoard = new GameBoard(board);
		// Root node has no action and no parent
		boardTree = new BoardTree(new BoardTreeNode(this.initialBoard, null, null));
		nodesToCheck = new LinkedList<>();
		checkedNodes = new ArrayList<>();
		solvedNode = null;
		solution = new Stack<>();
	}
	
	/**
	 * Begins to solve the board by iterating through possible solutions
	 * @return the solution, containing all the actions performed to solve challenge
	 */
	public void solveBoard() {
		BoardTreeNode currentNode;
		nodesToCheck.add(boardTree.getRoot());
		int i = 0;
		while((!nodesToCheck.isEmpty()) && (i <= 1000000)) {
			currentNode = nodesToCheck.pop();
			if(currentNode.getBoard().isFinished()) {
				solvedNode = currentNode;
				calculateActionsToSolve();
				break;
			}
			else {
				if(!checkedNodes.contains(currentNode)) {
					currentNode.populateChildren();
					checkedNodes.add(currentNode);
					nodesToCheck.addAll(currentNode.getChildren());
				}
			}
			i++;
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
		if(!solution.isEmpty()) return solution.pop();
		else return null;
	}
	
	public Stack<MoveAction> getSolution() {
		return this.solution;
	}
}
