package general;

import java.awt.Point;

import creational.ImageMaker_1;
import eNum.*;


public class Island extends MapObj{
	MapVals myVal= MapVals.ISLAND;
	
	public Island(Point pos) {
		this.setLocation(pos);
		this.setImageView(new ImageMaker_1("island.jpg",this).getImage());
		OceanMap.getInstance().updateVal(this.getLocation().x, this.getLocation().y, this.getVal());
	
	}
	
}
