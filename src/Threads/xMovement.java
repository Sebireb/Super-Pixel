package Threads;

import java.util.List;

import Items.Item;
import blocks.Block;
import characters.Character;
import characters.Mario;
import ledProjects.Drawable;
import worlds.World;

public class xMovement implements Runnable{
	
	final double SPEED = 0.1;
	List<Block> b;
	List<Character> c;
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
			direction = (int) m.getSpeedX();
			nextX = m.getX() - direction;
			drawable = w.getCollideable((int)Math.round(nextX), (int) Math.round(m.getY() - 0.5));
			if (drawable != null && drawable != m) {
				if (drawable instanceof Character) {
					m.collide();
				}else {
					if (drawable instanceof Item){
						drawable.collide();
					}	
				}
			}else {
				w.addXOffset(direction / 10.0);
			}
			try {
                Thread.sleep((long) (100 * SPEED));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}

}
