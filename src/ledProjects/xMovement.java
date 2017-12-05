package ledProjects;

import blocks.Block;
import characters.Character;
import characters.Mario;

public class xMovement implements Runnable{
	
	final double SPEED = 0.1;
	Block[] b;
	Character[] c;
	Mario m;

	public xMovement(Block[] b, Character[] c, Mario m) {
		this.b = b;
		this.c = c;
		this.m = m;
	}

	@Override
	public void run() {
		int direction;
		while(true) {
			direction = m.getDirection();
			for(int i = 0; i < b.length; i++) {
				b[i].move(direction * SPEED, 0);
			}
			for(int i = 0; i < c.length; i++) {
				if(! (c[i] instanceof Mario)) {
					c[i].move(direction * SPEED, 0);
				}
			}
			try {
                Thread.sleep((long) (1/SPEED));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}

}
