package strategy;

import java.util.*;

import eNum.*;
import enemy.Enemy;
import player.MainPlayer;

public class FigureEightStratey implements Strategy {

	public List<Direction> Pattern = new ArrayList<Direction>(Arrays.asList(Direction.NW, Direction.SW, Direction.SE,
			Direction.NE, Direction.NE, Direction.SE, Direction.SW, Direction.NW));
	int x = 1;

	@Override
	public Direction nextDir(MainPlayer player, Enemy i) {
		// TODO Auto-generated method stub
		Direction nextDirection = Pattern.get((x % Pattern.size()));
		x++;
		return nextDirection;

	}

}