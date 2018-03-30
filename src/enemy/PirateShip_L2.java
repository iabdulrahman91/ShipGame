package enemy;

import java.awt.Point;

import creational.ImageMaker_1;
import eNum.MapVals;
import state.ChaseStatePirate;
import state.NoChaseStatePirate;
import strategy.ChaseStrategy1;

public class PirateShip_L2 extends PirateShipAbstract {

	public PirateShip_L2(Point pos) {
		this.setStrategy(new ChaseStrategy1());
		this.setChaseState(new ChaseStatePirate(this));
		this.setNoChaseState(new NoChaseStatePirate(this));
		this.setState(new NoChaseStatePirate(this));
		this.setVal(MapVals.PIRATE);
		this.setHealth(100);
		this.setLocation(pos);
		this.setVisionRange(7);
		this.setAttacRange(3);
		this.setDamage(8);
		this.setMaxHealth(this.getHealth());
		this.setImageView(new ImageMaker_1("pirateShip.PNG", this).getImage());
//		OceanMap.getInstance().updateVal(this.getLocation().x, this.getLocation().y, this.getVal());
	}


}