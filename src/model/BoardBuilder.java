package model;

public class BoardBuilder {
	private int column;
	private int row;
	private Piece selectedPiece;
	private GameBoard boardToBuild;
	
	public BoardBuilder(GameBoard b) {
		column = -1;
		row = -1;
		this.boardToBuild = b;
		selectedPiece = null;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	public void setSelectedPiece() {
		//TODO
	}
	
	public void addPieceToBoard() {
		if(column != -1 && row != -1 && selectedPiece != null) {
			this.boardToBuild.addPiece(selectedPiece, column, row);
			column = -1;
			row = -1;
			selectedPiece = null;
		}
	}

	
	
}
