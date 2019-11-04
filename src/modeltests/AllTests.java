package modeltests;
/**
* Test suite for all the tests within this package
* @author Adela Tullio
*/
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BrownHoleTest.class, FoxTest.class, GameBoardTest.class,
		HoleTest.class, MushroomTest.class, RabbitTest.class,
		RaisedHoleTest.class })
public class AllTests {

}
