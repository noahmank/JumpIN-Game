package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JumpInGameTest {
	private GameBoard gameboard;
	private GameStatus gamestatus;
	
	@Before
	public void setUp() throws Exception {
		gameboard = new GameBoard();
	}

	@After
	public void tearDown() throws Exception {
		gameboard = null;
	}

	@Test
	public void testStart() {
		
	}

}
