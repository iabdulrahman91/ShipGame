package enemy;

import java.awt.Point;

import general.Actor;
import state.State;
import strategy.Strategy;

public abstract class Enemy extends Actor {
	private Strategy moveStrategy;
	private State state;
	private State noChaseState;
	private State chaseState;

	private Point originalLocation;

	public void setOriginalLocation(Point p) {
		this.originalLocation = p;
	}

	public Point getOriginalLocation() {
		return this.originalLocation;
	}

	public void setStrategy(Strategy s) {
		moveStrategy = s;
	}

	public Strategy getStrategy() {
		return this.moveStrategy;
	}

	public State getState() {
		return state;
	}

	public void setState(State s) {
		state = s;
	}

	public State getNoChaseState() {
		return noChaseState;
	}

	public State getChaseState() {
		return chaseState;
	}

	public void setNoChaseState(State s) {
		this.noChaseState = s;
	}

	public void setChaseState(State s) {
		this.chaseState = s;
	}



}
