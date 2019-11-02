package model;

import static org.junit.Assert.*;

public class RabbitTest {

	private Rabbit rabbit;
  
	@Before
	public void setUp() throws Exception {
		rabbit = new Rabbit("Grey");
	}

	@After
	public void tearDown() throws Exception {
		rabbit = null;
	}

	@Test
	public void testToString() {
		assertEquals("Should be 'GR'", "GR", rabbit.toString());
	}
}
