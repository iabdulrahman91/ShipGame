package strategy;

import java.awt.Point;
import java.util.Random;

import eNum.*;
import enemy.Enemy;
import player.MainPlayer;

public class ChaseStrategy1 implements Strategy{

	
	@Override
	public Direction nextDir(MainPlayer player, Enemy i) {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		Point ShipLocation = player.getLocation();
		if (rand.nextInt(2) == 1) {
		if (i.getLocation().x - ShipLocation.x < 0) {
			return(Direction.E);
		} else if (i.getLocation().x - ShipLocation.x > 0){
			return(Direction.W);
		} else if (i.getLocation().y - ShipLocation.y < 0) {
			return(Direction.S);
		}
		else {
			return(Direction.N);
		}}
		return null;
	}
	
}