package player;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import eNum.Direction;
import eNum.GlobalVars;
import eNum.MapVals;
import enemy.Observer;
import general.Actor;
import general.OceanMap;

public abstract class MainPlayer extends Actor implements Subject {
	private List<Observer> observers = new LinkedList<Observer>();
	protected List<MapVals> allowedVals = new LinkedList<MapVals>();
	private int numOfmovements;
	private boolean hasKey;
	@Override
	public void registerObserver(Observer o) {
		if (!observers.contains(o)) {
			observers.add(o);
		}

	}

	public int getNumOfMoves() {
		return numOfmovements;
	}
	public void setNumOfMoves(int i) {
		numOfmovements = i;
	}
	@Override
	public void removeObserver(Observer o) {
		if (observers.contains(o))
			observers.remove(o);
	}

	@Override
	public void notifyObservers() {
		for (Observer i : observers)
			i.update(this);

	}
	
	public void removeAllObserver() {
		observers.clear();
	}

	// return the location for found crate, or null if the cell contain no crate
	public Point checkNext(Direction d) {
		Point currentLocation = this.getLocation();
		switch (d) {
		case E:
			if ((currentLocation.x + 1 < GlobalVars.mapX)
					&& getAllowed().contains(OceanMap.getInstance().getVal(currentLocation.x + 1, currentLocation.y))) {
				return new Point(currentLocation.x + 1, currentLocation.y);
			}

			break;
		case N:
			if ((currentLocation.y - 1 >= 0)
					&& getAllowed().contains(OceanMap.getInstance().getVal(currentLocation.x, currentLocation.y - 1))) {
				return new Point(currentLocation.x, currentLocation.y - 1);
			}
			break;
		case S:
			if ((currentLocation.y + 1 < GlobalVars.mapY)
					&& getAllowed().contains(OceanMap.getInstance().getVal(currentLocation.x, currentLocation.y + 1))) {
				return new Point(currentLocation.x, currentLocation.y + 1);
			}
			break;
		case W:
			if ((currentLocation.x - 1 >= 0)
					&& getAllowed().contains(OceanMap.getInstance().getVal(currentLocation.x - 1, currentLocation.y))) {
				return new Point(currentLocation.x - 1, currentLocation.y);
			}
			break;
		default:
			break;

		}
		return null;

	}
	
	public void setHasKey(boolean k) {
		hasKey=k;
	}
	public boolean getHasKey() {
		return hasKey;
	}
	public List<MapVals> getAllowed(){
		return allowedVals;
	}

}
