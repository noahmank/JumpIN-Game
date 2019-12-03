package modeltests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.*;

/**
 * Test implementation for the save and load class
 * @author adelatullio
 *
 */
public class Save_LoadTest {
	private SaveLoad saveLoad;
	
	/**
	 * sets up the private variables
	 * for the tests
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		saveLoad = new SaveLoad();
	}
	
	/**
	 * tears down the private variables
	 * after the tests
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		saveLoad = null;
	}
	
	/**
	 * tests method to save and load the game data 
	 * from a file
	 */
	@Test
	public void testSaveAndLoadGameData() {
		fail("Not yet implemented");
	}

}
