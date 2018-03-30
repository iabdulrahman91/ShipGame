package tc;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import eNum.*;
import general.*;

class OceanMapTest {

	private int mapX = GlobalVars.mapX;
	private int mapY = GlobalVars.mapY;
	Random rand;
	
	@Test
	public void testUpdateMap(){
		OceanMap oceanMap = OceanMap.getInstance();
		rand = new Random(50);
		int x = rand.nextInt(mapX);
		int y = rand.nextInt(mapY);
		MapVals oldVal = oceanMap.getVal(x, y);
		oceanMap.updateVal(x, y, MapVals.MONSTER);
		MapVals newVal = oceanMap.getVal(x, y);
		assertFalse(oldVal == newVal);
	}
	
	@Test
	public void testUnique(){
		OceanMap oceanMap1 = OceanMap.getInstance();
		OceanMap oceanMap2 = OceanMap.getInstance();
		assertTrue(oceanMap1==oceanMap2);
	}


}
