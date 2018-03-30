package player;

import java.awt.Point;
import eNum.GlobalVars;
import eNum.MapVals;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SimplePlayer extends MainPlayer{

	
	public SimplePlayer(Point pos) {
		this.setNumOfMoves(1);
		int sf = GlobalVars.scallingFactor;
		this.setLocation(pos);
		this.setDamage(10);
		this.setAttacRange(5);
		this.setVisionRange(5);
		this.setMaxHealth(150);
		this.setHealth(150);
		this.setVal(MapVals.SHIP);
		Image image = new Image("ship.png", sf, sf, false,false);
		ImageView imageView = new ImageView(image);
		imageView.setX(getLocation().x*sf);
		imageView.setY(getLocation().y*sf);
		this.setImageView(imageView);
//		OceanMap.getInstance().updateVal(this.getLocation().x, this.getLocation().y, this.getVal());
		this.allowedVals.add(MapVals.CRATE);
		this.allowedVals.add(MapVals.GOAL);
		
	}


//	@Override
//	public void move(Direction d) {
//	IntStream.range(0, getNumOfMoves()).forEach(n -> {
//		super.move(d);
//	});
//	}
}
