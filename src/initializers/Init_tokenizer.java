package initializers;

import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import crates.Crate;
import creational.Factory;
import creational.FactoryMaker;
import eNum.CrateVals;
import eNum.FacLEVEL;
import eNum.MapVals;
import enemy.MonsterAbstract;
import enemy.PirateShipAbstract;
import general.Goal;
import general.MapObj;
import player.MainPlayer;
import player.SimplePlayer;

public class Init_tokenizer implements Initializer {

	List<Level> levels;
	int currentLevel;
	Factory factory;
	MainPlayer player;
	String FName;
	int levelCount;
	RandomizeTool ran;

	public Init_tokenizer() {

		ran = new RandomizeTool();
		levels = new ArrayList<Level>();
		currentLevel = 0;

	}

	public void scanFile(String fileName) {
		FName = fileName;
		try {
			Scanner sc = new Scanner(new File(FName));
			levelCount = 0;
			while (sc.hasNextLine()) {
				ReadLevel(sc.nextLine());
			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ReadLevel(String line) {
		StringTokenizer LevelTokenizer = new StringTokenizer(line, ";");
		Level l = new GameLevel();
		switch (levelCount) {
		case 0: // since we have only two levels of enemies
			factory = FactoryMaker.getFactory(FacLEVEL.L1);
			break;
		default:
			factory = FactoryMaker.getFactory(FacLEVEL.L2);
		}
		if (LevelTokenizer.hasMoreTokens()) {
			System.out.println("Level : " + levelCount);
			levelCount++;
			// Level newLevel = new Gamelevel(); //level
			while (LevelTokenizer.hasMoreTokens()) {
				StringTokenizer ObjectTokenizer = new StringTokenizer(LevelTokenizer.nextToken(), " ");
				String name = ObjectTokenizer.nextToken(); // type
				while (ObjectTokenizer.hasMoreTokens()) {
					String pair = ObjectTokenizer.nextToken();
					pair = pair.substring(1, pair.length() - 1);
					String[] cord = pair.split(",");
					int x = Integer.parseInt(cord[0]);
					int y = Integer.parseInt(cord[1]);
					Point location = new Point(x, y); // location

					switch (name) {
					case "PirateShip":
						l.feed(MapVals.PIRATE, factory.makePirateShip(location));
						break;
					case "Ship":
						player = new SimplePlayer(location);
						break;
					case "Island":
						l.feed(MapVals.ISLAND, factory.makeIsland(location));
						break;
					case "SeaMonster":
						l.feed(MapVals.MONSTER, factory.makeMonster(location, ran.getRandomStrategy()));
						break;
					case "AttackPower":
						l.feed(MapVals.CRATE, factory.makeCrate(location, CrateVals.ATTACK));
						break;
					default:
						System.out.println("wrong identifier for an object, check the txt file format");
						break;
					}
				}
			}
			Crate key = factory.makeCrate(ran.getRandomLocation(), CrateVals.KEY);
			l.setKey(key);
			l.feed(MapVals.CRATE, key);
			l.feed(MapVals.GOAL, factory.makeGoal(ran.getRandomLocation()));

			// return newLevel;
		}
		// return null;
		levels.add(l);
	}

	@Override
	public void makeObjs(String s) {
		// TODO Auto-generated method stub
		scanFile(s);

	}

	@Override
	public void makeObjs(int i, int p, int m, int c) {
		// TODO Auto-generated method stub
		// not used since the input file is used
	}

	@Override
	public Level getCurrentLevel() {
		// TODO Auto-generated method stub
		return levels.get(currentLevel);
	}

	@Override
	public void increaseLevel() {
		// TODO Auto-generated method stub
		currentLevel++;

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
		return levels.get(currentLevel).getGoal();
	}
	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return (this.currentLevel >= levels.size());
	}

}
