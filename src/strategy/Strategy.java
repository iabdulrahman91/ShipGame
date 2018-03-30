package strategy;

import eNum.*;
import enemy.Enemy;
import player.MainPlayer;

public interface Strategy{
	public abstract Direction nextDir(MainPlayer player,Enemy i);
}