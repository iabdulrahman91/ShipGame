package crates;

import general.MapObj;
import player.MainPlayer;

public abstract class Crate extends MapObj{
	public abstract  MainPlayer wrap(MainPlayer player);
}
