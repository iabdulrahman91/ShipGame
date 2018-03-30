package initializers;

import java.util.List;

import crates.Crate;
import eNum.*;
import enemy.*;
import general.*;

public interface Level {
	public void feed(MapVals type, Object o);
	public List<PirateShipAbstract> getPirates();
	public List<Crate> getCrates();
	public List<MonsterAbstract> getMonsters();
	public List<MapObj> getIslands();
	public Goal getGoal();
	public Crate getKey();
	public void setKey(Crate k);
}
