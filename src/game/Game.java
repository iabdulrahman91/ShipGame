package game;

import java.awt.Point;
import java.util.stream.IntStream;

import commands.*;
import commands.EndGameLoose;
import crates.Crate;
import eNum.*;
import general.Goal;
import general.MapObj;
import general.OceanMap;
import gui.*;
import initializers.Initializer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import player.MainPlayer;

public class Game extends Application {
	Scene scene;
	Pane root;
	Stage primaryStage;

	double sf;
	int Ys;
	int Xs;
	Point cCrateLocation;
	Crate cCrate;
	Goal cGoal;
	Drawing drawing;
	private Initializer init;
	private MainPlayer player;
	private boolean run = false;

	MyThread myThread;

	public void CommandReceiver(GameCommand c) {
		c.operate();

	}

	public void nextLevel() {
		CommandReceiver(new NextLevel(this));
	}
	
	public void GameLoose() {
//		CommandReceiver(new EndGameLoose(this));
		CommandReceiver(new EndGameLoose(this));
//		this.myThread.stop();
		
	}

	public void play() {
		EventHandler<KeyEvent> keyHandler = new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (getRunnning()) {
					switch (ke.getCode()) {
					case RIGHT:
						cCrateLocation = player.checkNext(Direction.E);
						if (cCrateLocation != null) {
							cCrate = init.getCrateObj(cCrateLocation);
							cGoal = init.getGoalObj(cCrateLocation);
							if (cCrate != null) {
								drawing.removeObj(cCrate);
								OceanMap.getInstance().updateVal(cCrateLocation.x, cCrateLocation.y, MapVals.OCEAN);
								setPlayer(cCrate.wrap(player));
							} else if (cGoal != null && player.getHasKey()) {
								drawing.removeObj(cGoal);
								OceanMap.getInstance().updateVal(cCrateLocation.x, cCrateLocation.y, MapVals.OCEAN);
								nextLevel();

							}

						}
						if (getRunnning()) {
							getPlayer().move(Direction.E);
						}

						break;

					case LEFT:
						cCrateLocation = player.checkNext(Direction.W);
						if (cCrateLocation != null) {
							cCrate = init.getCrateObj(cCrateLocation);
							cGoal = init.getGoalObj(cCrateLocation);
							if (cCrate != null) {
								drawing.removeObj(cCrate);
								OceanMap.getInstance().updateVal(cCrateLocation.x, cCrateLocation.y, MapVals.OCEAN);
								setPlayer(cCrate.wrap(player));
							} else if (cGoal != null && player.getHasKey()) {
								drawing.removeObj(cGoal);
								OceanMap.getInstance().updateVal(cCrateLocation.x, cCrateLocation.y, MapVals.OCEAN);
								nextLevel();

							}

						}
						if (getRunnning()) {
							getPlayer().move(Direction.W);
						}
						break;

					case UP:
						cCrateLocation = player.checkNext(Direction.N);
						if (cCrateLocation != null) {
							cCrate = init.getCrateObj(cCrateLocation);
							cGoal = init.getGoalObj(cCrateLocation);
							if (cCrate != null) {

								drawing.removeObj(cCrate);
								OceanMap.getInstance().updateVal(cCrateLocation.x, cCrateLocation.y, MapVals.OCEAN);
								setPlayer(cCrate.wrap(player));
							} else if (cGoal != null && player.getHasKey()) {
								drawing.removeObj(cGoal);
								OceanMap.getInstance().updateVal(cCrateLocation.x, cCrateLocation.y, MapVals.OCEAN);
								nextLevel();

							}

						}
						if (getRunnning()) {
							getPlayer().move(Direction.N);
						}
						break;

					case DOWN:
						cCrateLocation = player.checkNext(Direction.S);
						if (cCrateLocation != null) {
							cCrate = init.getCrateObj(cCrateLocation);
							cGoal = init.getGoalObj(cCrateLocation);
							if (cCrate != null) {
								drawing.removeObj(cCrate);
								OceanMap.getInstance().updateVal(cCrateLocation.x, cCrateLocation.y, MapVals.OCEAN);
								setPlayer(cCrate.wrap(player));
							} else if (cGoal != null && player.getHasKey()) {
								drawing.removeObj(cGoal);
								OceanMap.getInstance().updateVal(cCrateLocation.x, cCrateLocation.y, MapVals.OCEAN);
								nextLevel();

							}

						}
						if (getRunnning()) {
							getPlayer().move(Direction.S);
						}
						break;
					default:
						break;
					}
					if (getRunnning()) {

						cCrateLocation = null;
						cCrate = null;
						cGoal = null;
						player.notifyObservers();
					}
				} else {
					if (!getRunnning()&&player!=null) {
						GameLoose();
					}
				}
			}
			
		};
		scene.setOnKeyPressed(keyHandler);

	}

	public void setRunnning(boolean l) {
		run = l;
	}

	public boolean getRunnning() {
		return run;
	}

	public void setInitializer(Initializer init) {
		this.init = init;
	}

	public Initializer getInitializer() {
		return this.init;
	}

	public MainPlayer getPlayer() {
		return this.player;
	}

	public void setPlayer(MainPlayer player) {
		this.player = player;
	}

	public Pane getRoot() {
		return this.root;
	}

	public Drawing getDrawing() {
		return this.drawing;
	}

	public void setThread(MyThread t) {
		this.myThread = t;
	}

	public MyThread getThread() {
		return this.myThread;
	}

	public void updateMap() {
		OceanMap.getInstance().updateVal((int) this.getPlayer().getLocation().getX(),
				(int) this.getPlayer().getLocation().getY(), MapVals.SHIP);
		OceanMap.getInstance().updateVal((int) this.getInitializer().getGoal().getLocation().getX(),
				(int) this.getInitializer().getGoal().getLocation().getY(), MapVals.GOAL);
		OceanMap.getInstance().updateVal((int) this.getInitializer().getCurrentLevel().getKey().getLocation().getX(),
				(int) this.getInitializer().getCurrentLevel().getKey().getLocation().getY(), MapVals.CRATE);

		for (MapObj i : this.getInitializer().getIslands()) {

			OceanMap.getInstance().updateVal((int) i.getLocation().getX(), (int) i.getLocation().getY(), i.getVal());
		}
		for (MapObj i : this.getInitializer().getMonsters()) {

			OceanMap.getInstance().updateVal((int) i.getLocation().getX(), (int) i.getLocation().getY(), i.getVal());
		}
		for (MapObj i : this.getInitializer().getPirates()) {

			OceanMap.getInstance().updateVal((int) i.getLocation().getX(), (int) i.getLocation().getY(), i.getVal());
		}
		for (MapObj i : this.getInitializer().getCrates()) {

			OceanMap.getInstance().updateVal((int) i.getLocation().getX(), (int) i.getLocation().getY(), i.getVal());
		}

	}

	public void cleanMap() {
		IntStream.range(0, Ys).forEach(Y -> {
			IntStream.range(0, Xs).forEach(X -> {
				OceanMap.getInstance().updateVal(X, Y, MapVals.OCEAN);
			}

			);
		}

		);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Ys = GlobalVars.mapY;
		Xs = GlobalVars.mapX;
		sf = GlobalVars.scallingFactor;

		root = new AnchorPane();
		scene = new Scene(root, (sf * (Xs)) + sf * 10, (sf * Ys)); // w, h
		scene.setFill(Color.BISQUE);

		primaryStage.setTitle("**GAME**");
		primaryStage.setScene(scene);

		drawing = new Drawing_1(this);
		drawing.drawHome();
		primaryStage.show();
	}

	public static void main(String[] args) {

		Application.launch(args);
	}

}
