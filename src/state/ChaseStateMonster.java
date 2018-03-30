package state;

import enemy.*;
import player.MainPlayer;
import strategy.ReturnStrategy;

public class ChaseStateMonster implements State {
	MonsterAbstract monster;

	public ChaseStateMonster(MonsterAbstract m) {
		monster = m;
	}

	@Override
	public void caught(MainPlayer p) {
		if (monster.isWithRange(p, monster.getAttackRange())) {
			monster.attack(p);
			p.setHealth(p.getHealth()-1);
		}

	}

	@Override
	public void lost(MainPlayer p) {
		monster.move(monster.getStrategy().nextDir(p, monster));
		if (!monster.isWithRange(p, monster.getVisionRange())) {
			monster.setState(monster.getReturnState());
			monster.setStrategy(new ReturnStrategy());
			
		}
	}

}
