package player;

import eNum.Direction;

public class AttackPower extends PlayerDecorator {

	public AttackPower(MainPlayer mP) {
		mainPlayer = mP;

	}


	@Override
	public int getNumOfMoves() {
		return mainPlayer.getNumOfMoves();
	}

	@Override
	public void move(Direction d) {
		// IntStream.range(0, getNumOfMoves()).forEach(n -> {
		mainPlayer.move(d);
		// });
	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return mainPlayer.getHealth();
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return mainPlayer.getDamage()+5;
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
