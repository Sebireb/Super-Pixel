package Threads;

import Items.Item;
import blocks.Block;
import characters.Mario;
import worlds.World;

public class yMovement implements Runnable {
	
	private final double TICKSPEED = 0.05;
	private final int MAXHEIGHT = 9;
	
	private Mario m;
	private World w;
	private boolean jump = false;
	private double timeSec;
	private double yBeforeJump;
	private boolean falling;

	public yMovement(World w) {
		this.w = w;
		m = w.getMario();
	}

	@Override
	public void run() {
		while(true) {
			
			w.fall();
			m.move(0, m.getSpeedY());
			
			if(jump){
				timeSec += TICKSPEED;
				double newY = calcY(timeSec);
				if(newY == MAXHEIGHT){
					falling = true;
				}
				if(falling && w.drawableBelowMario() != null){
					if (w.drawableBelowMario() instanceof Block) {
						jump = false;
					}else {
						w.drawableBelowMario().collide();
					}
				}
				if(!falling && w.drawableAboveMario() != null) {
					if (w.drawableAboveMario() instanceof Block) {
						jump = false;
						w.getCollideable((int)Math.round(m.getX()), (int) Math.round(m.getY() - 1.5)).collide();
					}else
						if (w.drawableAboveMario() instanceof Item) {
							w.getCollideable((int)Math.round(m.getX()), (int) Math.round(m.getY() - 1.5)).collide();
						}else
							w.getMario().damage();
				}
				if(newY == 0){
					jump = false;
				}
				m.setY(yBeforeJump - newY);
			}
			
			try {
				Thread.sleep((long) (100 * TICKSPEED));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void jump(){
		jump = true;
		timeSec = 0;
		yBeforeJump = m.getY();
		falling = false;
	}
	
	public double calcY (double sec){
		double y = - 1 * Math.pow((1 * sec - 3) , 2) + 9;
		return y;
	}

}
