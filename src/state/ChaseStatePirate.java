package state;

import enemy.*;
import player.MainPlayer;

public class ChaseStatePirate implements State {
	PirateShipAbstract pirate;

	public ChaseStatePirate(PirateShipAbstract p) {
		pirate = p;
	}

	@Override
	public void caught(MainPlayer p) {
		// TODO Auto-generated method stub
		if (pirate.isWithRange(p, pirate.getAttackRange())) {
			pirate.attack(p);
		}

	}

	@Override
	public void lost(MainPlayer p) {
		// TODO Auto-generated method stub
		if (!pirate.isWithRange(p, pirate.getVisionRange())) {
			pirate.setState(pirate.getNoChaseState());
			p.removeObserver(pirate);
		}

	}

}
