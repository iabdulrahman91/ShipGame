package enemy;

import player.MainPlayer;

public abstract class PirateShipAbstract extends Enemy implements Observer {

	@Override
	public void update(MainPlayer player) {
		this.move(this.getStrategy().nextDir(player, this));
	}


}