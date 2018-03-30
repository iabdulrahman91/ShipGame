package state;

import enemy.MonsterAbstract;
import player.MainPlayer;
import strategy.ChaseStrategy1;

public class ReturnStateMonster implements State {
	MonsterAbstract monster;

	public ReturnStateMonster(MonsterAbstract m) {
		monster = m;
	}

	@Override
	public void caught(MainPlayer p) {
		if (monster.isWithRange(p, monster.getVisionRange())) {
			monster.setState(monster.getChaseState());
			monster.setStrategy(new ChaseStrategy1());
		}

	}

	@Override
	public void lost(MainPlayer p) {
		monster.move(monster.getStrategy().nextDir(p, monster));
		if(monster.getOriginalLocation().equals(monster.getLocation())) {
			monster.setState(monster.getNoChaseState());
			monster.setStrategy(monster.getOriginalMoveStrategy());
		}

	}

}
