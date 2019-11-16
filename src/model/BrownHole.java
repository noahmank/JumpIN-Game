package model;

/**
* This class represents the BrownHoles the rabbits will jump into
* @author Adela Tullio
*/
public class BrownHole extends RaisedHole {
	/**
	* Constructor calls the constructor
	* of the superclass
	*/
	public BrownHole() {
		super();
	}
	
	/**
	* If there is a piece in that hole, print it out as a string
	* otherwise represents the BrownHole as a string
	* @returns BrownHole string value
	*/
	@Override
	public String toString() {
		if(this.isOccupied()) return this.getPiece().toString();
		else return "BH";
	}
}
