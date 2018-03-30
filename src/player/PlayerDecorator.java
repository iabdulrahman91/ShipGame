package player;

import java.awt.Point;
import java.util.List;

import eNum.Direction;
import eNum.MapVals;
import enemy.Observer;
import general.Actor;
import javafx.scene.image.ImageView;

public abstract class PlayerDecorator extends MainPlayer {

	MainPlayer mainPlayer;

	
	@Override
	public List<MapVals> getAllowed(){
		return mainPlayer.getAllowed();
	}
	



	@Override
	public void attack(Actor target) {
		// TODO Auto-generated method stub
		mainPlayer.attack(target);

	}

	@Override
	public void setDamage(int d) {
		// TODO Auto-generated method stub
		mainPlayer.setDamage(d);

	}



	@Override
	public ImageView getImageView() {
		// TODO Auto-generated method stub
		return mainPlayer.getImageView();
	}

	@Override
	public void setImageView(ImageView img) {
		// TODO Auto-generated method stub
		mainPlayer.setImageView(img);

	}

	@Override
	public MapVals getVal() {
		// TODO Auto-generated method stub
		return mainPlayer.getVal();
	}

	@Override
	public void setVal(MapVals v) {
		// TODO Auto-generated method stub
		mainPlayer.setVal(v);
	}

	@Override
	public Point getLocation() {
		// TODO Auto-generated method stub
		return mainPlayer.getLocation();
	}

	@Override
	public void setLocation(Point pos) {
		// TODO Auto-generated method stub
		mainPlayer.setLocation(pos);
	}

	@Override
	public int getVisionRange() {
		// TODO Auto-generated method stub
		return mainPlayer.getVisionRange();
	}

	@Override
	public int getAttackRange() {
		// TODO Auto-generated method stub
		return mainPlayer.getAttackRange();
	}

	@Override
	public int getMaxHealth() {
		// TODO Auto-generated method stub
		return mainPlayer.getMaxHealth();
	}

	@Override
	public void setMaxHealth(int h) {
		// TODO Auto-generated method stub
		mainPlayer.setMaxHealth(h);

	}

	@Override
	public void setVisionRange(int r) {
		// TODO Auto-generated method stub
		mainPlayer.setVisionRange(r);

	}

	@Override
	public void setAttacRange(int r) {
		// TODO Auto-generated method stub
		mainPlayer.setAttacRange(r);

	}

	@Override
	public void updateImageViewLocation() {
		// TODO Auto-generated method stub
		mainPlayer.updateImageViewLocation();

	}

	@Override
	public boolean isWithRange(Actor target, int range) {
		// TODO Auto-generated method stub
		return mainPlayer.isWithRange(target, range);
	}



	@Override
	public void setHealth(int nHealth) {
		// TODO Auto-generated method stub
		mainPlayer.setHealth(nHealth);

	}

	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		mainPlayer.registerObserver(o);

	}

	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		mainPlayer.removeObserver(o);

	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		mainPlayer.notifyObservers();

	}


	@Override
	public abstract int getNumOfMoves();


	@Override
	public abstract void move(Direction d);


	@Override
	public abstract int getHealth();

	@Override
	public abstract int getDamage();


	@Override
	public abstract void setHasKey(boolean k);

	@Override
	public abstract boolean getHasKey();

}
