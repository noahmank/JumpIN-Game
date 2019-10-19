package model;

public class Rabbit extends MoveablePiece{
	
	/**
	 * The Rabbit constructor constructs a new Rabbit constructor
	 * @param color identifies the color of the Rabbit
	 * @param row the X coordinate of the Rabbit
	 * @param column the Y coordinate of the Rabbit
	 */
	public Rabbit(String color, int row, int column) {
		super(color, row, column);
	}
	
	/**
	 * A text representation of the Rabbit
	 */
	public String toString() {
		if(this.getName().toUpperCase() == "BROW") {
			return "RR";
		}
		else if(this.getName().toUpperCase() == "BLACK") {
			return "BR";
		}
		else return "WR";
	}
}
