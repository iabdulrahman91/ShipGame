package state;

import enemy.MonsterAbstract;
import player.MainPlayer;
import strategy.ChaseStrategy1;

public class NoChaseStateMonster implements State {
	MonsterAbstract monster;

	public NoChaseStateMonster(MonsterAbstract m) {
		monster = m;
	}

	@Override
	public void caught(MainPlayer p) {
		if (monster.isWithRange(p, monster.getVisionRange())) {
			System.out.println(p.getLocation().toString());
			monster.setState(monster.getChaseState());
			monster.setStrategy(new ChaseStrategy1());
		}
	}

	@Override
	public void lost(MainPlayer p) {
		monster.move(monster.getStrategy().nextDir(p, monster));
	}

}
