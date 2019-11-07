package model;

public enum RabbitColor {
	GREY("greyRabbit.png"),
	BROWN("brownRabbit.png"),
	WHITE("whiteRabbit.png");
	
	private final String src;
	
	RabbitColor(String src) {
		this.src = src;
	}
	
	public String getSrc() {
		return this.src;
	}
	
	@Override
	public String toString() {
		return name().substring(0, 1).toUpperCase() + name().substring(1).toLowerCase();
	}
}
