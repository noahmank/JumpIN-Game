package model;

import java.util.LinkedList;

public class BoardSolver {
	GameBoard initialBoard;
	BoardTree boardTree;
	LinkedList<BoardTreeNode> checkNodes;
	
	BoardSolver(GameBoard board) {
		this.initialBoard = board;
		BoardTreeNode root = new BoardTreeNode(board, null);
		checkNodes = new LinkedList<>();
	}
	
	
}
