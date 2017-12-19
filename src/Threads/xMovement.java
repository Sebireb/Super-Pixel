package Threads;

import blocks.Block;
import characters.Character;
import characters.Mario;
import ledProjects.Drawable;
import worlds.World;

public class xMovement implements Runnable{
	
	final double SPEED = 0.1;
	Block[] b;
	Character[] c;
	World w;
	Mario m;

	public xMovement(World w, Mario m) {
		this.w = w;
		this.m = m;
		this.b = w.getBlocks();
		this.c = w.getCharacters();
	}

	@Override
	public void run() {
		int direction;
		double nextX;
		Drawable drawable;
		while(true) {
			direction = (int) m.getSpeedx();
			nextX = m.getX() - direction;
			drawable = w.getCollideable((int)Math.round(nextX), (int) Math.round(m.getY() - 0.5));
			if (drawable != null) {
				drawable.collide();
			}else {
				w.addXOffset(direction / 10.0);
			}
			try {
                Thread.sleep((long) (1/SPEED));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}

}
