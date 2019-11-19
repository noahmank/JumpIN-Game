package model;

/**
 * Enumeration to identify rabbits by colour
 * @author Noah Mank
 *
 */
public enum RabbitColor {
	GREY("greyRabbit.png"),
	BROWN("brownRabbit.png"),
	WHITE("whiteRabbit.png");
	
	private final String src;
	
	/**
	 * Assign the appropriate image for each colour rabbit
	 * @param src is the name of the rabbit's image
	 */
	RabbitColor(String src) {
		this.src = src;
	}
	
	/**
	 * Get the rabbit image for a given colour rabbit
	 * @return the name of the rabbit's image
	 */
	public String getSrc() {
		return this.src;
	}
	
	@Override
	public String toString() {
		return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
	}
}
