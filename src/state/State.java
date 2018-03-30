package state;

import player.MainPlayer;

public interface State {
	public void caught(MainPlayer mainPlayer);
	public void lost(MainPlayer p);
}
