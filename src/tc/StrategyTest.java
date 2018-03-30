package tc;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import eNum.Direction;

import strategy.*;

class StrategyTest {

	@Test
	public void testDrunkenJackassPattern(){
		DrunkenJackass strat = new DrunkenJackass();
		assertFalse(strat.Pattern.isEmpty());
	}
	
	@Test
	public void testFigureEight(){
		FigureEightStratey strat = new FigureEightStratey();
		assertTrue(strat.Pattern.get(0)==Direction.NW);
	}
	@Test
	public void testStrategyName(){
		Loop strat = new Loop();
		assertTrue(strat.getStrategyName()=="Patrol_Loop");
	}
}
