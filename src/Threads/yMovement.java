package Threads;

import characters.Mario;
import worlds.World;

public class yMovement implements Runnable {
	
	Mario m;
	World w;

	public yMovement(World w) {
		this.w = w;
		m = w.getMario();
	}

	@Override
	public void run() {
		while(true) {
			w.fall();
			m.move(0, m.getSpeedY());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
