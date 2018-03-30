package initializers;

import java.awt.Point;
import java.util.List;

import crates.Crate;
import enemy.*;
import general.*;
import player.MainPlayer;

public interface Initializer {
	public void makeObjs(int i, int p, int m, int c);
	public void makeObjs(String s);
	public Level getCurrentLevel();
	public void increaseLevel();
	public MainPlayer getPlayer();
	public Goal getGoal();
	public List<PirateShipAbstract> getPirates();
	public List<Crate> getCrates();
	public List<MonsterAbstract> getMonsters();
	public List<MapObj> getIslands();
	public Crate getCrateObj(Point p);
	public Goal getGoalObj(Point p);
	
	public boolean isDone();
	
}
