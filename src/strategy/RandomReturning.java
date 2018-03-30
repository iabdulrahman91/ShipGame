package strategy;



import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Random;

import eNum.Direction;
import enemy.Enemy;
import player.MainPlayer;

public class  RandomReturning implements Strategy {
	final int xymax = 3;
	private int ctr;
	private int MaxMovements;
	private int currentMovement;
	List<Direction> Pattern;
	Iterator<Direction> MoveM;
	List<Direction> fwd;
	List<Direction> rev;
	final int MaxMoves = 3;

	public RandomReturning() {
		ctr = 0;
		fwd = new ArrayList<Direction>();
		rev = new ArrayList<Direction>();
		Pattern = new ArrayList<Direction>();
		MoveM = Pattern.iterator();
	};

	private Direction Opposite(Direction dir) {
		switch (dir) {
		case S:
			return Direction.N;
		case N:
			return Direction.S;
		case E:
			return Direction.W;
		case W:
			return Direction.E;
		case NW:
			return Direction.SE;
		case NE:
			return Direction.SW;
		case SW:
			return Direction.NE;
		case SE:
			return Direction.NE;
		default:
			return null;
		}
	}

	public void updatePattern() {
		fwd = new ArrayList<Direction>();
		rev = new ArrayList<Direction>();
		Pattern = new ArrayList<Direction>();
		Pattern.clear();
		forwardPattern();
		backwardPattern();
		Pattern.addAll(fwd);
		Pattern.addAll(rev);
		MoveM = Pattern.iterator();

	}

	private void forwardPattern() {
		int ctr = 0;
		Direction oldDir;
		Direction dir;
		Random rnd = new Random();
		dir = Direction.values()[rnd.nextInt(8)];
		fwd.add(dir);
		oldDir = dir;
		while (ctr < MaxMoves - 1) {
			dir = Direction.values()[rnd.nextInt(8)];
			if (dir != Opposite(oldDir)) {
				fwd.add(dir);
				oldDir = dir;
				ctr++;
			}
		}
	}

	private void backwardPattern() {
		Iterator<Direction> itDir = fwd.iterator();
		while (itDir.hasNext()) {
			rev.add(Opposite(itDir.next()));
		}
		Collections.reverse(rev);
	}

	@Override
	public Direction nextDir(MainPlayer player, Enemy i) {
		if (!MoveM.hasNext()) {
			ctr = 0;
			updatePattern();
			MoveM = Pattern.iterator();

		} else {
			ctr++;
		}
		return MoveM.next();
	}

	
	public String getStrategyName() {

		return "RandomReturning";
	}
}
