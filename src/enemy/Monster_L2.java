package enemy;

import java.awt.Point;

import creational.ImageMaker_1;
import eNum.MapVals;
import state.*;
import strategy.Strategy;

public class Monster_L2 extends MonsterAbstract {

	public Monster_L2(Point pos, Strategy s) {
		this.setStrategy(s);
		this.setOriginalStrategy(this.getStrategy());
		
		this.setChaseState(new ChaseStateMonster(this));
		this.setNoChaseState(new NoChaseStateMonster(this));
		this.setReturnState(new ReturnStateMonster(this));
		this.setState(new NoChaseStateMonster(this));
		
		this.setVal(MapVals.MONSTER);
		this.setHealth(100);
		this.setLocation(pos);
		this.setOriginalLocation(this.getLocation());
		this.setVisionRange(5);
		this.setAttacRange(2);
		this.setDamage(4);
		this.setMaxHealth(this.getHealth());
		this.setImageView(new ImageMaker_1("monster.png", this).getImage());
//		OceanMap.getInstance().updateVal(this.getLocation().x, this.getLocation().y, this.getVal());

	}

}
