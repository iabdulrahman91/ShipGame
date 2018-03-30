package initializers;

import java.util.ArrayList;
import java.util.List;

import crates.Crate;
import eNum.MapVals;
import enemy.MonsterAbstract;
import enemy.PirateShipAbstract;
import general.Goal;
import general.MapObj;

public class GameLevel implements Level {

	List<PirateShipAbstract> pirates;
	List<MonsterAbstract> monsters;
	List<MapObj> islands;
	List<Crate> crates;
	Goal goal;
	Crate key;
	
	
	public GameLevel() {
		pirates = new ArrayList<PirateShipAbstract>();
		monsters = new ArrayList<MonsterAbstract>();
		islands = new ArrayList<MapObj>();
		crates = new ArrayList<Crate>();

	}

	@Override
	public void feed(MapVals type, Object o) {
		// TODO Auto-generated method stub
		switch (type) {
		case CRATE:
			crates.add((Crate) o);
			break;
		case ISLAND:
			islands.add((MapObj) o);
			break;
		case MONSTER:
			monsters.add((MonsterAbstract) o);
			break;
		case PIRATE:
			pirates.add((PirateShipAbstract) o);
			break;
		case GOAL:
			goal = (Goal)o;
		default:
			break;
		}

	}

	@Override
	public List<PirateShipAbstract> getPirates() {
		// TODO Auto-generated method stub
		return pirates;
	}

	@Override
	public List<Crate> getCrates() {
		// TODO Auto-generated method stub
		return crates;
	}

	@Override
	public List<MonsterAbstract> getMonsters() {
		// TODO Auto-generated method stub
		return monsters;
	}

	@Override
	public List<MapObj> getIslands() {
		// TODO Auto-generated method stub
		return islands;
	}

	@Override
	public Goal getGoal() {
		// TODO Auto-generated method stub
		return goal;
	}

	@Override
	public Crate getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public void setKey(Crate k) {
		// TODO Auto-generated method stub
		this.key = k;
		
	}

}
