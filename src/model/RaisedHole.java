package model;

import java.io.Serializable;

/**
* Represents RaisedHoles on the GameBoard
* @author Adela Tullio
*/
public class RaisedHole extends Hole implements Serializable {
	
	/**
	* RaisedHole constructor calls the
	* constructor of it's superclass
	*/
	public RaisedHole() {
		super();
	}
	
	/**
	* Represents RaisedHole as a string
	* @returns RaisedHole string
	*/
	@Override
	public String toString() {
		if(this.isOccupied()) return this.getPiece().toString();
		else return "RH";
	}
}
