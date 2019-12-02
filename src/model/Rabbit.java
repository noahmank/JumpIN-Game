package model;

import java.util.Objects;

public class Rabbit implements MoveablePiece {
	private RabbitColor color;
	/**
	 * The Rabbit constructor constructs a new Rabbit constructor
	 * @param color identifies the color of the Rabbit
	 * @param row the X coordinate of the Rabbit
	 * @param column the Y coordinate of the Rabbit
	 * @author Aubin Musingya
	 */
	public Rabbit(RabbitColor color) {
		this.color = color;
	}
	
	/**
	 * Returns the color of the rabbit
	 * @return String representing the color
	 */
	public RabbitColor getColor() {
		return this.color;
	}
	
	/**
	* A getter for the SRC
	* @return string of the image url
	*/
	@Override
	public String getSrc() {
		return this.color.getSrc();
	}
	
	/**
	 * A text representation of the Rabbit
	 * @return String representing the rabbit
	 */
	public String toString() {
		return this.color.toString() + " Rabbit";
	}
	
	/**
	* Hash code function 
	* @return integer value
	*/
	@Override
	public int hashCode() {
		return Objects.hash(color);
	}
	
	/**
	* Equals method to determine if two objects are equal or not
	* @param obj is the object to be compared to
	* @return true or false if the two objects are equals or not
	*/
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		Rabbit rabbit = (Rabbit) obj;
		return rabbit.getColor().equals(this.getColor());
	}
}
