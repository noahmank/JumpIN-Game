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
	private LinkedList<BoardTreeNode> checkNodes;
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
		checkNodes = new LinkedList<>();
		checkedNodes = new ArrayList<>();
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
		int i = 0;
		while((!checkNodes.isEmpty()) && (i <= 10000000)) {
			checkNode = checkNodes.pop();
			if(checkNode.getBoard().isFinished()) {
				solvedNode = checkNode;
				calculateActionsToSolve();
				break;
			}
			else {
				if(!checkedNodes.contains(checkNode)) {
					checkNode.populateChildren();
					checkedNodes.add(checkNode);
					checkNodes.addAll(checkNode.getChildren());
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
		return solution.pop();
	}
	
	public Stack<MoveAction> getSolution() {
		return this.solution;
	}
}
