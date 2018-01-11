package Threads;

import characters.Mario;
import worlds.World;

public class yMovement implements Runnable {
	
	private final double TICKSPEED = 0.1;
	
	private Mario m;
	private World w;
	private boolean jump = false;
	private int timeMillisec;
	private double yBeforeJump;

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
				timeMillisec += TICKSPEED * 1000;
				double newY = calcY(timeMillisec);
				if(newY == 0){
					jump = false;
				}
				m.setY(yBeforeJump - newY);
				System.out.println(yBeforeJump + "\nnewY: " + newY + "\nInsg: "+(yBeforeJump - newY));
			}
			
			try {
				Thread.sleep((long) (1 / TICKSPEED));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void jump(){
		jump = true;
		timeMillisec = 0;
		yBeforeJump = m.getY();
	}
	
	public double calcY (int millisec){
		double sec = millisec / 1000.0;
		double y = - 1 * Math.pow((1 * sec - 3) , 2) + 9;
		return y;
	}

}
