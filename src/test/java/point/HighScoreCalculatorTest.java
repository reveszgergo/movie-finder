package point;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class HighScoreCalculatorTest {

	private HighScoreCalculator highScoreCalculator;
	
	@Before
	public void setUp(){
		highScoreCalculator = new HighScoreCalculator();
	}
	
	@Test
	public void addPointTest(){
		assertEquals(0, highScoreCalculator.getPoint());
		
		highScoreCalculator.addPoint(10);
		assertEquals(10, highScoreCalculator.getPoint());
	}

}
