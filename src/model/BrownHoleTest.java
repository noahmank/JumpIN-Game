package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BrownHoleTest {
	private BrownHole bh;
	
	@Before
	public void setUp() throws Exception {
		BrownHole bh = new BrownHole();
	}

	@After
	public void tearDown() throws Exception {
		bh = null;
	}

	@Test
	public void testToString() {
		assertEquals("String should be 'BH'.", "BH", bh.toString());
	}

}
