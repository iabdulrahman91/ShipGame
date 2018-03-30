package state;

import enemy.PirateShipAbstract;
import player.MainPlayer;

public class NoChaseStatePirate implements State {
	PirateShipAbstract pirate;

	public NoChaseStatePirate(PirateShipAbstract p) {
		pirate = p;
	}

	@Override
	public void caught(MainPlayer p) {
		// TODO Auto-generated method stub
		if (pirate.isWithRange(p, pirate.getVisionRange())) {
			p.registerObserver(pirate);
			pirate.setState(pirate.getChaseState());
		}

	}

	@Override
	public void lost(MainPlayer p) {
		// TODO Auto-generated method stub

	}

}
