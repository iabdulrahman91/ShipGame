package general;

import java.util.Random;

public abstract class Actor extends Moveable {

	private int Health, MaxHealth, Damage, visionRange, attackRange;

	public void attack(Actor target) {
		int oldHealth = target.getHealth();
		if (oldHealth - getDamage() <= 0) {
			target.setHealth(0);
		} else {

//			Random rand = 
			if (new Random().nextInt(3) == 1) {
				// Or call Terminate
				System.out.println(target.getHealth());
				target.setHealth(oldHealth - getDamage());
				
			}
		}

	}

	public boolean isWithRange(Actor target, int range) {
		boolean h = (target.getLocation().getX() <= this.getLocation().getX() + range)
				&& (target.getLocation().getX() >= this.getLocation().getX() - range);
		boolean v = (target.getLocation().getY() <= this.getLocation().getY() + range)
				&& (target.getLocation().getY() >= this.getLocation().getY() - range);
		return (h && v);
	}

	public int getHealth() {
		return this.Health;
	}

	public int getVisionRange() {
		return this.visionRange;
	}

	public int getAttackRange() {
		return this.visionRange;
	}

	public int getDamage() {
		return this.Damage;
	}

	public int getMaxHealth() {
		return this.MaxHealth;
	}

	public void setHealth(int nHealth) {
		this.Health = nHealth;
	}

	public void setMaxHealth(int h) {
		this.MaxHealth = h;
	}

	public void setVisionRange(int r) {
		this.visionRange = r;
	}

	public void setAttacRange(int r) {
		this.visionRange = r;
	}

	public void setDamage(int d) {
		this.Damage = d;
	}


}
