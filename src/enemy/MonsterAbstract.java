package enemy;

import state.*;
import strategy.Strategy;

public abstract class MonsterAbstract extends Enemy {

	private Strategy originalMoveStrategy;
	private State returnState;

	public Strategy getOriginalMoveStrategy() {
		return this.originalMoveStrategy;
	}

	public State getReturnState() {
		return returnState;
	}

	public void setReturnState(State s) {
		this.returnState = s;
	}

	public void setOriginalStrategy(Strategy s) {
		this.originalMoveStrategy = s;
	}



}