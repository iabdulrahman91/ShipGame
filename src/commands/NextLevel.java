package commands;

import eNum.GlobalVars;
import game.Game;

public class NextLevel implements GameCommand {
	Game game;
	double sf;
	int Ys;
	int Xs;

	public NextLevel(Game g) {
		this.game = g;
		Ys = GlobalVars.mapY;
		Xs = GlobalVars.mapX;
		sf = GlobalVars.scallingFactor;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		// public void nextLevel() {
		game.getInitializer().increaseLevel();
		System.out.println(game.getInitializer().isDone());
		if (game.getInitializer().isDone()) {
			
			game.CommandReceiver(new EndGameWin(game));
		} else {

			game.getPlayer().removeAllObserver();
			game.getPlayer().setHasKey(false);
			game.getDrawing().cleanBigBox();
			game.cleanMap();
			game.getDrawing().drawMap();
			game.updateMap();
			game.getDrawing().drawMapObjs();

		}

		
	}

}
