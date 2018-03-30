package commands;

import game.Game;
import game.MyThread;

public class NewGame implements GameCommand{
	Game game;
	public NewGame(Game g) {
		this.game = g;
	}
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		game.setThread(new MyThread(game));
		game.getThread().start();
		game.setRunnning(true);
		
		game.getDrawing().cleanBigBox();
		game.cleanMap();
		game.getDrawing().drawMap();
		game.updateMap();
		game.getDrawing().drawMapObjs();
		
		game.play();
	}



}
