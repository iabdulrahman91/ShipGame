package creational;

import eNum.GlobalVars;
import general.MapObj;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageMaker_1 implements ImageMaker{
	private Image image;
	private ImageView imageView;

	public ImageMaker_1(String path, MapObj m) {
		int sf = GlobalVars.scallingFactor;
		image = new Image(path, sf, sf, false, false);
		imageView = new ImageView(image);
		
		imageView.setX(m.getLocation().x*sf);
		imageView.setY(m.getLocation().y*sf);
		
		
	}

	@Override
	public ImageView getImage() {
		// TODO Auto-generated method stub
		return imageView;
	}

	
}
