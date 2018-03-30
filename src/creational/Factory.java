package creational;

import java.awt.Point;

import crates.Crate;
import eNum.*;
import enemy.*;

import general.*;
import strategy.Strategy;



public interface Factory {

	
	public  PirateShipAbstract makePirateShip(Point pos);

	public  MonsterAbstract makeMonster(Point pos, Strategy s);

	public  Island makeIsland(Point pos);
	
	public Goal makeGoal(Point pos);
	
	public  Crate makeCrate(Point pos,CrateVals v);
	

}