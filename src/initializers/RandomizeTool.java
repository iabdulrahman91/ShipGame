package initializers;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import eNum.CrateVals;
import eNum.GlobalVars;
import eNum.PatrolPatterns;
import strategy.DrunkenJackass;
import strategy.FigureEightStratey;
import strategy.Loop;
import strategy.RandomReturning;
import strategy.Strategy;

public class RandomizeTool {

	List<Point> occupiedLocation = new ArrayList<Point>();
	Random rand = new Random();
	
	public CrateVals getRandomCrateVal() {
		CrateVals c = CrateVals.values()[rand.nextInt(3)];
		switch (c) {
		case HEALTH:
			return CrateVals.MOVE;
		case ATTACK:
			return CrateVals.ATTACK;
		case MOVE:
			return CrateVals.HEALTH;
		default:
			return null;
		}
	}
	public Strategy getRandomStrategy() {
		PatrolPatterns patt = PatrolPatterns.values()[rand.nextInt(4)];
		switch (patt) {
		case FigureEight:
			return new FigureEightStratey();
		case Loop:
			return new Loop();
		case DrunkenJackass:
			return new DrunkenJackass();
		case RandomReturning:
			return new RandomReturning();
		default:
			return null;
		}
		
	}
	public Point getRandomLocation() {

		int x = rand.nextInt(GlobalVars.mapX);
		int y = rand.nextInt(GlobalVars.mapY);
		Point randomLocation = new Point(x, y);

		while (occupiedLocation.contains(randomLocation)) {
			x = rand.nextInt(GlobalVars.mapX);
			y = rand.nextInt(GlobalVars.mapY);
			randomLocation = new Point(x, y);
		}
		occupiedLocation.add(randomLocation);
		return randomLocation;
	}
}
