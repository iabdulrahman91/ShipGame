package crates;

import java.awt.Point;

import creational.ImageMaker_1;
import eNum.CrateVals;
import eNum.MapVals;
import general.OceanMap;
import player.*;

public class AttackCrate extends Crate {
private CrateVals val;
	
	public AttackCrate(Point pos, CrateVals v) {
		this.val = v;
		this.setVal(MapVals.CRATE);
		this.setLocation(pos);
		this.setImageView(new ImageMaker_1("attack.png", this).getImage());
		OceanMap.getInstance().updateVal(this.getLocation().x, this.getLocation().y, this.getVal());
	}

	@Override
	public MainPlayer wrap(MainPlayer player) {
		
		return new AttackPower(player);
	}
}
