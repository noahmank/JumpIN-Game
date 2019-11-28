package modeltests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.*;

/**
 * 
 * @author adelatullio
 *
 */
public class Save_LoadTest {
	private Save_Load saveLoad;
	
	@Before
	public void setUp() throws Exception {
		saveLoad = new Save_Load();
	}

	@After
	public void tearDown() throws Exception {
		saveLoad = null;
	}

	@Test
	public void testSaveGameDataToFile() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testLoadGameDataToFile() {
		fail("Not yet implemented");
	}

}
