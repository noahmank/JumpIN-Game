package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * @author noahmank with contributions from Aubin and kelly
 *
 */
public class BoardSolver {
	GameBoard initialBoard;
	BoardTree boardTree;
	ArrayList<MoveAction> solution;
	LinkedList<BoardTreeNode> checkNodes;
	
	/**
	 * Constructs the Board solver with the given board game
	 * @param board GameBoard object 
	 */
	public BoardSolver(GameBoard board) {
		this.initialBoard = board;
		BoardTreeNode root = new BoardTreeNode(board, null);
		checkNodes = new LinkedList<>();
		solution = new ArrayList<>();
	}
	
	/**
	 * Begins to solve the board by iterating through possible solutions
	 * @return the solution, containing all the actions performed to solve challenge
	 */
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
	
	/**
	 * Gets the solved board with the actions performed
	 * @return GameBoard Object
	 */
	public GameBoard getSolvedBoard() {
		return null;
	}
	
	/**
	 * Populates the next level of child nodes if the board is still not solved
	 * @param board the game board from the parent node
	 */
	private void populateBoardTreeChildren(BoardTreeNode node) {
		GameBoard parentBoard = node.getBoard();
		GameBoard childBoard;
		HashMap<MoveablePiece, Point> moveablePieces = new HashMap<>();
		moveablePieces.putAll(parentBoard.getRabbits());
		moveablePieces.putAll(parentBoard.getFoxes());
		
		for(MoveablePiece p : moveablePieces.keySet()) {
			for(Direction d : Direction.values()) {
				if(parentBoard.canMovePiece(p, d)) {
					childBoard = parentBoard.applyActionToBoard(p, d);
					node.addChild(childBoard);
				}
			}
		}
	}
}
