package gui;

import commands.*;
import eNum.*;
import game.*;
import general.*;
import initializers.Init_Gui;
import initializers.Init_tokenizer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Drawing_1 extends Drawing {

	int sf;
	int Ys;
	int Xs;

	myHBox islandLabel;
	myHBox monsterLabel;
	myHBox pirateLabel;
	myHBox crateLabel;

	myButton startBtn;
	myButton endBtn;
	myButton inputBtn;

	MsgBox msgBox;
	VBox controls;

	Pane BigBox;



	public Drawing_1(Game g) {
		Ys = GlobalVars.mapY;
		Xs = GlobalVars.mapX;
		sf = GlobalVars.scallingFactor;
		game = g;

	}
	@Override
	public void drawHome() {
		BigBox = new Pane();
		BigBox.setPrefHeight(Ys * sf);
		BigBox.setPrefWidth(Xs * sf);
		drawButton();
		
		drawWelcome();
		game.getRoot().getChildren().addAll(BigBox, controls);

	}

	@Override
	public void drawMap() {

		for (int y = 0; y < Ys; y++) {
			for (int x = 0; x < Xs; x++) {

				Rectangle rect = new Rectangle(x * sf, y * sf, sf, sf);
				rect.setStroke(Color.BLACK);
				rect.setFill(Color.LIGHTBLUE);

				if (OceanMap.getInstance().getVal(x, y) == MapVals.OCEAN) {
					BigBox.getChildren().addAll(rect);
				}
			}
		}

	}

	@Override
	public void drawButton() {

		pirateLabel = new myHBox("Number 	of 	Pirate	: ");
		islandLabel = new myHBox("Number 	of 	Islands	: ");
		monsterLabel = new myHBox("Number 	of 	Monsters	: ");
		crateLabel = new myHBox("Number 	of 	Crate	: ");

		startBtn = new myButton("Start Level 1");
		endBtn = new myButton("End Game");
		inputBtn = new myButton("Read InPut file");

		controls = new myVBox();
		controls.getChildren().addAll(pirateLabel, islandLabel, monsterLabel, crateLabel, startBtn, endBtn, inputBtn);

		startBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {

				pirateLabel.setDisable(true);
				monsterLabel.setDisable(true);
				islandLabel.setDisable(true);
				crateLabel.setDisable(true);
				startBtn.setDisable(true);

				startBtn.setDisable(true);
				inputBtn.setDisable(true);
				endBtn.setDisable(false);

//				cleanBigBox();
//				drawMap();

				int p = pirateLabel.getInput();
				int m = monsterLabel.getInput();
				int i = islandLabel.getInput();
				int c = crateLabel.getInput();

				game.setInitializer(new Init_Gui());
				game.getInitializer().makeObjs(i, p, m, c);
				game.setPlayer(game.getInitializer().getPlayer());

//				drawMapObjs();

				game.CommandReceiver(new NewGame(game));

			}

		});

		endBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				startBtn.setDisable(true);
				inputBtn.setDisable(true);
				endBtn.setDisable(true);

				pirateLabel.setDisable(false);
				monsterLabel.setDisable(false);
				islandLabel.setDisable(false);
				crateLabel.setDisable(false);

				cleanBigBox();
				game.getRoot().getChildren().remove(BigBox);
				game.getRoot().getChildren().add(msgBox);

				game.CommandReceiver(new EndGameLoose(game));

			}
		});

		inputBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				// read from tokenizer
				pirateLabel.setDisable(true);
				monsterLabel.setDisable(true);
				islandLabel.setDisable(true);
				crateLabel.setDisable(true);
				startBtn.setDisable(true);

				startBtn.setDisable(true);
				inputBtn.setDisable(true);
				endBtn.setDisable(false);

				cleanBigBox();
				drawMap();

				game.setInitializer(new Init_tokenizer());
				game.getInitializer().makeObjs("src/input.txt");
				game.setPlayer(game.getInitializer().getPlayer());

				drawMapObjs();
				
				game.CommandReceiver(new NewGame(game));

			}
		});

	}

	@Override
	public void drawMapObjs() {
		for (MapObj i : game.getInitializer().getIslands()) {
			drawObj(i);
			OceanMap.getInstance().updateVal((int) i.getLocation().getX(), (int) i.getLocation().getY(),
					i.getVal());
		}
		for (MapObj i : game.getInitializer().getMonsters()) {
			drawObj(i);
			OceanMap.getInstance().updateVal((int) i.getLocation().getX(), (int) i.getLocation().getY(),
					i.getVal());
		}
		for (MapObj i : game.getInitializer().getPirates()) {
			drawObj(i);
			OceanMap.getInstance().updateVal((int) i.getLocation().getX(), (int) i.getLocation().getY(),
					i.getVal());
		}
		for (MapObj i : game.getInitializer().getCrates()) {
			drawObj(i);
			OceanMap.getInstance().updateVal((int) i.getLocation().getX(), (int) i.getLocation().getY(),
					i.getVal());
		}
		drawObj(game.getInitializer().getPlayer());
		drawObj(game.getInitializer().getGoal());
	}

	@Override
	public void cleanBigBox() {
		BigBox.getChildren().clear();
	}

	@Override
	public void removeObj(MapObj obj) {
		BigBox.getChildren().remove(obj.getImageView());
	}


	@Override
	public void drawObj(MapObj obj) {
		BigBox.getChildren().add(obj.getImageView());
	}

	@Override
	public void drawWelcome() {
		// TODO Auto-generated method stub
		cleanBigBox();
		msgBox = new MsgBox("Welcome", Color.DARKGRAY);
		BigBox.getChildren().add(msgBox);
		

	}

	@Override
	public void drawGameOver() {
		// TODO Auto-generated method stub
		cleanBigBox();
		msgBox = new MsgBox("GAME OVER", Color.INDIANRED);
		BigBox.getChildren().add(msgBox);
		resetBtn();

	}

	@Override
	public void drawWin() {
		// TODO Auto-generated method stub
		cleanBigBox();
		msgBox = new MsgBox("Congratulation", Color.DARKCYAN);
		BigBox.getChildren().add(msgBox);
		resetBtn();

	}

	@Override
	public void resetBtn() {
		startBtn.setDisable(true);
		inputBtn.setDisable(true);
		endBtn.setDisable(true);
		pirateLabel.setDisable(true);
		monsterLabel.setDisable(true);
		islandLabel.setDisable(true);
		crateLabel.setDisable(true);
	}

}
