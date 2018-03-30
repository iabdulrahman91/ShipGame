package strategy;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eNum.Direction;
import enemy.Enemy;
import player.MainPlayer;

public class Loop implements Strategy {

	final int xymax=3;
	private int ctr;
	private int MaxMovements;
	private int currentMovement;
	public List<Direction> Pattern;
	Iterator<Direction> MoveM;


	public Loop()
	{
		ctr=1;
		MaxMovements=8;
		currentMovement=0;
		addPattern();
	}
	public void addPattern() {
		Pattern=new ArrayList<Direction>();
		Pattern.add(Direction.N);
		Pattern.add(Direction.W);
		Pattern.add(Direction.S);
		Pattern.add(Direction.S);
		Pattern.add(Direction.E);
		Pattern.add(Direction.E);
		Pattern.add(Direction.N);
		Pattern.add(Direction.N);
		Pattern.add(Direction.SW);
		MoveM=Pattern.iterator();
	}
	public String getStrategyName() {
		return "Patrol_Loop";
	}
	@Override
	public Direction nextDir(MainPlayer player, Enemy i) {
		// TODO Auto-generated method stub
		Direction nextDirection = Pattern.get((currentMovement % Pattern.size()));
		currentMovement++;
		return nextDirection;
	}

}
