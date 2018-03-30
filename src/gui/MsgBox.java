package gui;

import eNum.GlobalVars;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MsgBox extends StackPane{
	int Ys = GlobalVars.mapY;
	int Xs = GlobalVars.mapX;
	double sf = GlobalVars.scallingFactor;

	public MsgBox(String text,  Color color) {
		this.setAlignment(Pos.CENTER);
		this.setHeight(sf*Ys);
		this.setWidth(sf*Xs);
		Rectangle rect = new Rectangle(0,0, sf*Xs, sf*Ys);
		rect.setFill(color);
		
		Text t = new Text(text);
		t.setStyle("-fx-font: 150 Muller;");
		t.setFill(Color.LIGHTCORAL);
		
		getChildren().addAll(rect, t);
		
		
	}
	

}
