package model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BrownHoleTest.class, FoxTest.class, GameBoardTest.class,
		HoleTest.class, JumpInGameTest.class, MushroomTest.class, RabbitTest.class,
		RaisedHoleTest.class })
public class AllTests {

}
