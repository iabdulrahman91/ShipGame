package strategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eNum.Direction;
import enemy.Enemy;
import player.MainPlayer;

public class DrunkenJackass implements Strategy{
	final int xymax=3;
	private int ctr;
	private int MaxMovements;
	private int currentMovement;
	public List<Direction> Pattern;
	Iterator<Direction> MoveM;
public DrunkenJackass()
{
	this.ctr=0;
	this.MaxMovements=8;
	this.currentMovement=0;
	addPattern();
	
}
	public void addPattern() {
		Pattern=new ArrayList<Direction>();
		for(int x=1;x<=xymax;x++)
		{
			for(int y=0;y<x;y++)
				{
				Pattern.add(Direction.E);
				}
			for(int y=0;y<x*2;y++)
			{
			Pattern.add(Direction.W);
			}
			for(int y=0;y<x;y++)
			{
			Pattern.add(Direction.E);
			}
			MoveM=Pattern.iterator();
		}
	}
	public void nextMove(Enemy e)
	{
		if(e.getImageView().getRotate()!=180)
		{
		e.getImageView().setRotate(180);
		}
	}
	
	public String getStrategyName() {
		return "Drunken_JackASS";
	}
	@Override
	public Direction nextDir(MainPlayer player, Enemy i) {
		if(!MoveM.hasNext()) MoveM = Pattern.iterator();
		ctr++;
		nextMove(i);
		return MoveM.next();
	}
}
