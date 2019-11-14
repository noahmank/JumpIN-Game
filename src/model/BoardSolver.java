package model;

import java.util.ArrayList;
import java.util.LinkedList;

public class BoardSolver {
	GameBoard initialBoard;
	BoardTree boardTree;
	LinkedList<BoardTreeNode> checkNodes;
	
	public BoardSolver(GameBoard board) {
		this.initialBoard = board;
		BoardTreeNode root = new BoardTreeNode(board, null);
		checkNodes = new LinkedList<>();
	}
	
	public ArrayList<MoveAction> solveBoard() {
		checkNodes.add(boardTree.getRoot());
		return null;
	}
	
	
}
