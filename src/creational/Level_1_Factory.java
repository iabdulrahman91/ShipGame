package creational;

import java.awt.Point;

import crates.*;
import eNum.CrateVals;
import enemy.MonsterAbstract;
import enemy.Monster_L1;
import enemy.PirateShipAbstract;
import enemy.PirateShip_L1;
import general.Goal;
import general.Island;
import strategy.Strategy;

public class Level_1_Factory implements Factory{
	
	
	
	@Override
	public PirateShipAbstract makePirateShip(Point pos) {
		// TODO Auto-generated method stub
		return new PirateShip_L1(pos);
		
	}

	@Override
	public MonsterAbstract makeMonster(Point pos, Strategy s) {
		// TODO Auto-generated method stub
		return new Monster_L1(pos, s);
		
	}

	@Override
	public Island makeIsland(Point pos) {
		// TODO Auto-generated method stub
		return new Island(pos);
		
	}

	@Override
	public Crate makeCrate(Point pos, CrateVals v) {
		// TODO Auto-generated method stub
		switch(v) {
		case ATTACK:
			return new AttackCrate(pos, v);
		case HEALTH:
			return new HealthCrate(pos, v);
		case MOVE:
			return new MoveCrate(pos, v);
		case KEY:
			return new KeyCrate(pos, v);
		default:
			break;
		
		}
		return null;
		
	}

	@Override
	public Goal makeGoal(Point pos) {
		// TODO Auto-generated method stub
		return new Goal(pos);
	}


}
