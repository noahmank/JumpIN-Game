package model;

public class Rabbit implements Piece{
	private String color;
	/**
	 * The Rabbit constructor constructs a new Rabbit constructor
	 * @param color identifies the color of the Rabbit
	 * @param row the X coordinate of the Rabbit
	 * @param column the Y coordinate of the Rabbit
	 */
	public Rabbit(String color) {
		this.color = color;
	}
	
	/**
	 * A text representation of the Rabbit
	 */
	private String getColor() {
		return this.color;
	}
	
	public String toString() {
		if(this.getColor().toUpperCase().equals("GREY")) {
			return "GR";
		}
		else if(this.getColor().toUpperCase().equals("BLACK")) {
			return "BR";
		}
		else return "WR";
	}
}
