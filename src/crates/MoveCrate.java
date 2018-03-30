package crates;

import java.awt.Point;

import creational.ImageMaker_1;
import eNum.CrateVals;
import eNum.MapVals;
import general.OceanMap;
import player.MainPlayer;
import player.MovePower;

public class MoveCrate extends Crate {
private CrateVals val;
	
	public MoveCrate(Point pos, CrateVals v) {
		this.val = v;
		this.setVal(MapVals.CRATE);
		this.setLocation(pos);
		this.setImageView(new ImageMaker_1("speed.png", this).getImage());
		OceanMap.getInstance().updateVal(this.getLocation().x, this.getLocation().y, this.getVal());
	}

	@Override
	public MainPlayer wrap(MainPlayer player) {
		
		return new MovePower(player);
	}
}
