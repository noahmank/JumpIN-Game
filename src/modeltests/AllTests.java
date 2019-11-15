package modeltests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
* Test suite for all the tests 
* @author Adela Tullio
*/
@RunWith(Suite.class)
@SuiteClasses({ BoardSolverTest.class, BoardTreeNodeTest.class, BoardTreeTest.class, BrownHoleTest.class,
		DirectionTest.class, FoxTest.class, GameBoardTest.class, HoleTest.class, MoveActionTest.class,
		MushroomTest.class, RabbitColorTest.class, RabbitTest.class, RaisedHoleTest.class })
public class AllTests {

}
