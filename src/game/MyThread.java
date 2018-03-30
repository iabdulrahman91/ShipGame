package game;

import enemy.*;
import enemy.PirateShipAbstract;

public class MyThread extends Thread {
	Game game;

	public MyThread(Game g) {
		game = g;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (game.getRunnning()) {

			try {
				for (Enemy e : game.getInitializer().getMonsters()) {
					e.getState().caught(game.getPlayer());
					e.getState().lost(game.getPlayer());
				}
				for (PirateShipAbstract p : game.getInitializer().getPirates()) {
					p.getState().caught(game.getPlayer());
					p.getState().lost(game.getPlayer());
					
				}
				if(game.getPlayer().getHealth()<=0) {
					
					game.setRunnning(false);
				}
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
