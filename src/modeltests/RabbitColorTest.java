package modeltests;

import static org.junit.Assert.*;
import org.junit.Test;
import model.RabbitColor;

/**
 * Test class for the RabbitColor Enumeration class
 * @author Adela Tullio
 *
 */
public class RabbitColorTest {

	/**
	 * Tests the getSrc method for RabbitColor
	 */
	@Test
	public void testGetSrc() {
		assertEquals("Expected to be 'whiteRabbit.png", "whiteRabbit.png", RabbitColor.WHITE.getSrc());
		assertEquals("Expected to be 'brownRabbit.png", "brownRabbit.png", RabbitColor.BROWN.getSrc());
		assertEquals("Expected to be 'greyRabbit.png", "greyRabbit.png", RabbitColor.GREY.getSrc());
	}
	
	/**
	 * Tests the toString method for RabbitColor
	 */
	@Test
	public void testToString() {
		assertEquals("Expected to be 'White'", "White", RabbitColor.WHITE.toString());
		assertEquals("Expected to be 'Brown'", "Brown", RabbitColor.BROWN.toString());
		assertEquals("Expected to be 'Grey'", "Grey", RabbitColor.GREY.toString());
	}

}
