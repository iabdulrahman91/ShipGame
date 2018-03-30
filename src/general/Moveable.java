package general;

import java.awt.Point;

import eNum.*;

public abstract class Moveable extends MapObj{
		
	public void updateImageViewLocation() {
		this.getImageView().setX(this.getLocation().x * GlobalVars.scallingFactor);
		this.getImageView().setY(this.getLocation().y * GlobalVars.scallingFactor);
	}
	
	
	public void move(Direction d) {
		if(d==null) return;
		int i = 1;
		Point oldLocation = (Point)this.getLocation().clone();
		Point currentLocation = this.getLocation();
		switch(d) {
			case N:
				if((currentLocation.y-1>=0) && OceanMap.getInstance().getVal(currentLocation.x, currentLocation.y-1)==MapVals.OCEAN) {
					currentLocation.y--;
				}
			break;
			case S:
				if((currentLocation.y+1<GlobalVars.mapY) && OceanMap.getInstance().getVal(currentLocation.x, currentLocation.y+1)==MapVals.OCEAN) {
					currentLocation.y++;
				}
			break;
			case E:
				if((currentLocation.x+1<GlobalVars.mapX) && OceanMap.getInstance().getVal(currentLocation.x+1, currentLocation.y)==MapVals.OCEAN) {
					currentLocation.x++;
				}
			break;
			case W:
				if((currentLocation.x-1>=0) && OceanMap.getInstance().getVal(currentLocation.x-1, currentLocation.y)==MapVals.OCEAN) {
					currentLocation.x--;
				}
			break;	
			case NW:
				move(Direction.N);
				move(Direction.W);
			break;
			case SE:
				move(Direction.S);
				move(Direction.E);
			break;
			case SW:
				move(Direction.S);
				move(Direction.W);
			break;
			default:
				move(Direction.N);
				move(Direction.E);
				break;
		}
//		 if the movement occurred the old location should be Ocean and new location will be updated to hold
//		 the new value. then ImageViewLocation would be updated.
		if(!oldLocation.equals(currentLocation)) {
			OceanMap.getInstance().updateVal(oldLocation.x, oldLocation.y, MapVals.OCEAN);
			OceanMap.getInstance().updateVal(currentLocation.x, currentLocation.y, this.getVal());
			updateImageViewLocation();
		}
	}

	

}