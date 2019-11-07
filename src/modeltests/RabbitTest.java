package modeltests;
import model.*;
/**
* Tests for the Rabbit class implementation
* @author Adela Tullio
*/
import static org.junit.Assert.*;
import org.junit.*;

public class RabbitTest {

	private Rabbit rabbit;
	private Rabbit rabbit2;
	private Rabbit rabbit3;
	
  	
	/**
	* Set up method for variables
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
		rabbit = new Rabbit("Grey");
		rabbit2 = new Rabbit("Brown");
		rabbit3 = new Rabbit("White");
	}
	
	/**
	* Tear down method for variables
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		rabbit = null;
		rabbit2 = null;
		rabbit3 = null;
	}
	
	/**
	* Test the toString method in Rabbit class
	* for a Grey rabbit
	*/
	@Test
	public void testToStringGreyRabbit() {
		assertEquals("Should be 'GR'", "GR", rabbit.toString());
	}
	
	/**
	 * Test the toString method in Rabbit class
	 * for a Brown rabbit
	 */
	@Test
	public void testToStringBrownRabbit() {
		assertEquals("Should be 'BR'", "BR", rabbit2.toString());
	}
	
	/**
	 * Test the toString method in Rabbit class
	 * for a White rabbit
	 */
	@Test
	public void testToStringWhiteRabbit() {
		assertEquals("Should be 'WR'", "WR", rabbit3.toString());
	}
}
