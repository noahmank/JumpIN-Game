package model;

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
	 * A text representation of the Rabbit
	 * @return String representing the rabbit
	 */
	public String toString() {
		return this.color.toString() + " Rabbit";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || obj.getClass() != this.getClass()) return false;
		Rabbit rabbit = (Rabbit) obj;
		return rabbit.getColor() == this.getColor();
	}
}
