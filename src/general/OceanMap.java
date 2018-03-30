package general;
import eNum.*;

public class OceanMap {
	private static OceanMap instance = null;
	private MapVals[][] map; // MapVals [row/Y][column/X]

	private int X = GlobalVars.mapX;
	private int Y = GlobalVars.mapY;
	
	
	private OceanMap() {
		map = new MapVals[Y][X];
		int y = 0;
		int x = 0;
		while (y < Y) {
			while (x < X) {
				map[y][x] = MapVals.OCEAN;
				x++;
			}
			x = 0;
			y++;
		}
		
	}

	public synchronized void updateVal(int x, int y, MapVals val) { // synchronization could be implemented here
		map[y][x] = val;
	}

	public synchronized MapVals getVal(int x, int y) {
		return map[y][x];
	}

	public static synchronized OceanMap getInstance() {
		if (instance == null) { // lazy initialization
			instance = new OceanMap();
		}
		return instance;

	}


}
