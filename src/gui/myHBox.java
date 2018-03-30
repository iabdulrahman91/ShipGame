package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class myHBox extends HBox{
	TextField field;
	public myHBox(String text) {
		
		Label label = new Label(text);
		label.setAlignment(Pos.CENTER);
		label.setPrefWidth(220);
		label.setPrefHeight(30);
		
		field = new TextField("0");
		field.setPrefWidth(70);
		field.setPrefHeight(30);
		field.setAlignment(Pos.CENTER_LEFT);
		
		setAlignment(Pos.CENTER_LEFT);
		setPrefWidth(250);
		setPrefHeight(30);
		
		getChildren().addAll(label, field);
	}
	
	public int getInput() {
		return Integer.parseInt(field.getText());
	}

}
