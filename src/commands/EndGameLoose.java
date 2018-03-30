package commands;

import game.Game;

public class EndGameLoose implements GameCommand {
	Game game;

	public EndGameLoose(Game g) {
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
		game.getDrawing().drawGameOver();
		game.setInitializer(null);
		game.setPlayer(null);

	}

}
