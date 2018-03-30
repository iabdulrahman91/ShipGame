package initializers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import crates.Crate;
import creational.*;
import eNum.*;
import enemy.*;
import general.*;
import player.MainPlayer;
import player.SimplePlayer;

public class Init_Gui implements Initializer {

	List<Level> levels;
	int currentLevel;
	Factory factory;
	MainPlayer player;
	Goal goal;
	RandomizeTool ran;

	public Init_Gui() {
		levels = new ArrayList<Level>();
		currentLevel = 0;
		factory = FactoryMaker.getFactory(FacLEVEL.L1);
		ran = new RandomizeTool();
		player = new SimplePlayer(new Point(0, 0));
		goal = factory.makeGoal(ran.getRandomLocation());
	}

	@Override
	public void makeObjs(String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeObjs(int i, int p, int m, int c) {
		// TODO Auto-generated method stub
		int numOfIslands = i;
		int numOfMonsters = m;
		int numOfPirates = p;
		int numOfCrates = c;

		Level l = new GameLevel();

		IntStream.range(0, numOfIslands).forEach(n -> {
			l.feed(MapVals.ISLAND, factory.makeIsland(ran.getRandomLocation()));
			// (factory.makeIsland());
		}

		);

		IntStream.range(0, numOfMonsters).forEach(n -> {
			l.feed(MapVals.MONSTER, factory.makeMonster(ran.getRandomLocation(), ran.getRandomStrategy()));
		}

		);
		IntStream.range(0, numOfPirates).forEach(n -> {
			l.feed(MapVals.PIRATE, factory.makePirateShip(ran.getRandomLocation()));
		}

		);
		IntStream.range(0, numOfCrates).forEach(n -> {
			l.feed(MapVals.CRATE, factory.makeCrate(ran.getRandomLocation(), ran.getRandomCrateVal()));
		}

		);
		Crate key =factory.makeCrate(ran.getRandomLocation(), CrateVals.KEY);
		l.setKey(key);
		l.feed(MapVals.CRATE, key);
		l.feed(MapVals.GOAL, goal);
		levels.add(l);
	}

	@Override
	public Level getCurrentLevel() {
		// TODO Auto-generated method stub
//		if(this.currentLevel+1 >= levels.size()) {
//			return null;
//		}
		return levels.get(currentLevel);
	}

	@Override
	public void increaseLevel() {
		// TODO Auto-generated method stub
		 currentLevel++;
		// new GameLevel should be made with 0 objects

	}

	@Override
	public MainPlayer getPlayer() {
		// TODO Auto-generated method stub
		return player;
	}

	@Override
	public List<PirateShipAbstract> getPirates() {
		// TODO Auto-generated method stub
		return levels.get(currentLevel).getPirates();
	}

	@Override
	public List<Crate> getCrates() {
		// TODO Auto-generated method stub
		return levels.get(currentLevel).getCrates();
	}

	@Override
	public List<MonsterAbstract> getMonsters() {
		// TODO Auto-generated method stub
		return levels.get(currentLevel).getMonsters();
	}

	@Override
	public List<MapObj> getIslands() {
		// TODO Auto-generated method stub
		return levels.get(currentLevel).getIslands();
	}

	@Override
	public Crate getCrateObj(Point p) {
		for (Crate i : getCrates()) {
			if (i.getLocation().getX() == p.getX() && i.getLocation().getY() == p.getY()) {
				return i;
			}
		}
		return null;
	}

	@Override
	public Goal getGoalObj(Point p) {
		// TODO Auto-generated method stub
		if (getGoal().getLocation().equals(p)) {
			return getGoal();
		} else {
			return null;
		}
	}

	@Override
	public Goal getGoal() {
		// TODO Auto-generated method stub
		return goal;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return (this.currentLevel >= levels.size());
	}
	
	

}
