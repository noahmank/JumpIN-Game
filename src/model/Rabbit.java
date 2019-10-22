package model;

public class Rabbit implements Piece{
	private String color;
	/**
	 * The Rabbit constructor constructs a new Rabbit constructor
	 * @param color identifies the color of the Rabbit
	 * @param row the X coordinate of the Rabbit
	 * @param column the Y coordinate of the Rabbit
	 * @author Aubin Musingya
	 */
	public Rabbit(String color) {
		this.color = color;
	}
	
	/**
	 * Returns the color of the rabbit
	 * @return String representing the color
	 */
	private String getColor() {
		return this.color;
	}
	
	/**
	 * A text representation of the Rabbit
	 * @return String representing the rabbit
	 */
	public String toString() {
		if(this.getColor().toUpperCase().equals("GREY")) {
			return "GR";
		}
		else if(this.getColor().toUpperCase().equals("BROWN")) {
			return "BR";
		}
		else return "WR";
	}
}
