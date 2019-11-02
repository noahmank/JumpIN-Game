package model;

import static org.junit.Assert.*;

public class MushroomTest {

	private Mushroom mushroom;
	
	@Before
	public void setUp() throws Exception {
		mushroom = new Mushroom();
	}

	@After
	public void tearDown() throws Exception {
		mushroom = null;
	}

	@Test
	public void testToString() {
		assertEquals("Should be 'MS'.", "MS", mushroom.toString());
	}

}
