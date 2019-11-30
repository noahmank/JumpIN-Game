package model;
/**
 * 
 * @author noahmank and help from adelatullio
 *
 */
public class BoardBuilder {
	private int column;
	private int row;
	private String pieceName;
	private String pieceAttribute;
	private Piece selectedPiece;
	private GameBoard boardToBuild;
	
	/**
	 * constructor for boardbuilder
	 * @param b is the gameboard to build
	 */
	public BoardBuilder(GameBoard b) {
		column = -1;
		row = -1;
		this.boardToBuild = b;
		selectedPiece = null;
	}
	
	/**
	 * sets the piece's name
	 * @param name the name the piece is set to
	 */
	public void setPieceName(String name) {
		this.pieceName = name;
	}
	
	/**
	 * gets the piece name
	 * @return piece name
	 */
	public String getPieceName() {
		return this.pieceName;
	}
	
	/**
	 * sets the piece's attribute
	 * @param attribute is the attribute the piece is set to
	 */
	public void setPieceAttribute(String attribute) {
		this.pieceAttribute = attribute;
	}
	
	/**
	 * gets the piece's attribute
	 * @return piece attribute
	 */
	public String getPieceAttribute() {
		return this.pieceAttribute;
	}
	
	
	/**
	 * sets the column number
	 * @param column the number you wish to set the column to
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	
	/**
	 * sets the row number
	 * @param row the number you wish to set the row to
	 */
	public void setRow(int row) {
		this.row = row;
	}
	
	/**
	 * gets the column number
	 * @return column number
	 */
	public int getColumn() {
		return this.column;
	}
	
	/**
	 * gets the row number
	 * @return row number
	 */
	public int getRow() {
		return this.row;
	}
	
	/**
	 * sets the selected piece
	 * @param piece is the piece to set the selected piece to
	 */
	public void setSelectedPiece(Piece piece) {
		this.selectedPiece = piece;
	}
	
	/**
	 * gets the selected piece
	 * @return selected piece value
	 */
	public Piece getSelectedPiece() {
		return this.selectedPiece;
	}
	
	/**
	 * getter for the board to build
	 * @return the gameboard to build
	 */
	public GameBoard getBoardToBuild() {
		return this.boardToBuild;
	}
	
	/**
	 * adds the selected piece to the board 
	 * at the specified column and row
	 */
	public void addPieceToBoard() {
		if(column != -1 && row != -1 && selectedPiece != null) {
			this.boardToBuild.addPiece(selectedPiece, column, row);
			column = -1;
			row = -1;
			selectedPiece = null;
		}
	}
	
	/**
	 * removes the selected piece from the board
	 */
	public void removePieceFromBoard() {
		if(this.column != -1 && this.row != -1 && this.selectedPiece != null) {
			this.boardToBuild.removePiece(selectedPiece);
		}
	}
}

