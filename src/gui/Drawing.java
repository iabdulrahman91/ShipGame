package gui;

import game.Game;
import general.MapObj;

public abstract class Drawing {
	Game game;

	public abstract void drawHome();
	public abstract void drawWelcome();

	public abstract void drawGameOver();
	
	public abstract void drawWin();

	public abstract void resetBtn();
	
	public abstract void drawMap();
	
	public abstract void cleanBigBox();

	public abstract void drawButton();

	public abstract void drawMapObjs();

	public abstract void removeObj(MapObj obj);

	public abstract void drawObj(MapObj obj);
	
	


}
