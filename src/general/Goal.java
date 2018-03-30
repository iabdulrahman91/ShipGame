package general;

import java.awt.Point;

import creational.ImageMaker_1;
import eNum.MapVals;

public class Goal extends MapObj {
	MapVals myVal = MapVals.GOAL;

	public Goal(Point pos) {
		this.setVal(myVal);
		this.setLocation(pos);
		this.setImageView(new ImageMaker_1("goal.png", this).getImage());
		OceanMap.getInstance().updateVal(this.getLocation().x, this.getLocation().y, this.getVal());

	}
}
