package player;

import java.util.stream.IntStream;

import eNum.Direction;

public class MovePower extends PlayerDecorator {

	public MovePower(MainPlayer mP) {
		mainPlayer = mP;
		
	}

	

	@Override
	public int getNumOfMoves() {
		return mainPlayer.getNumOfMoves()+1;
	}

	@Override
	public void move(Direction d) {
		 IntStream.range(0, getNumOfMoves()).forEach(n -> {
		mainPlayer.move(d);
		 });
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return mainPlayer.getHealth();
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return mainPlayer.getDamage();
	}

	@Override
	public void setHasKey(boolean k) {
		mainPlayer.setHasKey(k);
	}

	@Override
	public boolean getHasKey() {
		return mainPlayer.getHasKey();
	}
}
