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
  	
	/**
	* Set up method for variables
	* @throws Exception
	*/
	@Before
	public void setUp() throws Exception {
		rabbit = new Rabbit("Grey");
	}
	
	/**
	* Tear down method for variables
	* @throws Exception
	*/
	@After
	public void tearDown() throws Exception {
		rabbit = null;
	}
	
	/**
	* Test the toString method in Rabbit class
	*/
	@Test
	public void testToString() {
		assertEquals("Should be 'GR'", "GR", rabbit.toString());
	}
}
