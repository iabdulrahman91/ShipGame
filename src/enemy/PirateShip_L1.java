package enemy;

import java.awt.Point;


import creational.ImageMaker_1;
import eNum.MapVals;
import state.*;
import strategy.ChaseStrategy1;

public class PirateShip_L1 extends PirateShipAbstract {

	public PirateShip_L1(Point pos) {
		this.setStrategy(new ChaseStrategy1());
		this.setChaseState(new ChaseStatePirate(this));
		this.setNoChaseState(new NoChaseStatePirate(this));
		this.setState(new NoChaseStatePirate(this));
		this.setVal(MapVals.PIRATE);
		this.setHealth(100);
		this.setLocation(pos);
		this.setVisionRange(6);
		this.setAttacRange(2);
		this.setDamage(6);
		this.setMaxHealth(this.getHealth());
		this.setImageView(new ImageMaker_1("pirateShip.png", this).getImage());
//		OceanMap.getInstance().updateVal(this.getLocation().x, this.getLocation().y, this.getVal());
	}

}
