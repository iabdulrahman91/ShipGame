package player;

import eNum.Direction;

public class HealthPower extends PlayerDecorator {
	int nHealth;

	public HealthPower(MainPlayer mP) {
		mainPlayer = mP;
		mainPlayer.setHealth(mainPlayer.getHealth()+100);
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
