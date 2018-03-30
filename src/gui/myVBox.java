package gui;

import eNum.GlobalVars;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class myVBox extends VBox{
	int Ys = GlobalVars.mapY;
	int Xs = GlobalVars.mapX;
	double sf = GlobalVars.scallingFactor;
	public myVBox() {
		setSpacing(sf/2);
		setAlignment(Pos.TOP_LEFT);
		setPadding(new Insets(15, 15, 15, 15));
		setLayoutX(sf*Xs);
		setLayoutY(0);
		setPrefHeight(sf*Ys);
		setMinHeight(30*9);
	}
}
