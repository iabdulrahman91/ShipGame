package commands;

import game.Game;

public class EndGameWin implements GameCommand {
	Game game;

	public EndGameWin(Game g) {
		this.game = g;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void operate() {
		// TODO Auto-generated method stub
		if (game.getThread() != null) {
			game.getThread().stop();
			game.setThread(null);
		}
		game.setRunnning(false);
		game.getDrawing().drawWin();
		game.setInitializer(null);
		game.setPlayer(null);

	}
}
