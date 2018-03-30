package strategy;

import java.awt.Point;

import eNum.Direction;
import enemy.Enemy;
import player.MainPlayer;

public class ReturnStrategy implements Strategy {

	@Override
	public Direction nextDir(MainPlayer player, Enemy i) {
		// TODO Auto-generated method stub

		Point originalLocation = i.getOriginalLocation();
		if (i.getLocation().x - originalLocation.x < 0) {
			return (Direction.E);
		} else if (i.getLocation().x - originalLocation.x > 0) {
			return (Direction.W);
		} else if (i.getLocation().y - originalLocation.y < 0) {
			return (Direction.S);
		} else {
			return (Direction.N);
		}
	}

}
