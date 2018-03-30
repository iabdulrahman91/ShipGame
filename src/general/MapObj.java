package general;

import java.awt.Point;

import eNum.MapVals;
import javafx.scene.image.ImageView;

public class MapObj {
	private Point location;
	private ImageView imageView;
	private MapVals myVal;

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView img) {
		imageView = img;
	}

	public MapVals getVal() {
		return myVal;
	}
	public void setVal(MapVals v) {
		myVal = v;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point pos) {
		location = pos;
	}
}
