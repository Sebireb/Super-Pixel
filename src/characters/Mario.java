package characters;

import ledControl.BoardController;
import ledProjects.Drawable;
import ledProjects.DrawableType;

public class Mario extends Character {
	
	final static long COLLISIONDELAY = 1000;
	
	private final double MAXFALLSPEED = 1;
	
	private int lives;
	private int coins;
	private long lastCollision = System.currentTimeMillis();

	public Mario(int x, int y, int size, BoardController controller, int[] background) {
		super(x, y, Character.MARIO, size, controller, background);
		name = "Mario";
		lives = 1;
		coins = 0;
		speedx = 0;
		speedy = 0;
		player = true;
	}
	
	@Override
	public void move(double dx, double dy){
		x += dx;
		y += dy;
	}
	
	@Override
	public void draw() {
		for(double y = this.y-size; y < this.y; y++){
			controller.setColor((int) Math.round(x), (int)Math.round(y), color[state]);
		}	
	}
	
	@Override
	public void  clear() {
		for(double y = this.y-size; y < this.y; y++){
			controller.setColor((int) Math.round(x), (int)Math.round(y), background);
		}
	}
	
	public void move() {
		Drawable d = w.getCollideable((int)Math.round(x + speedx), (int)Math.round(y));
		if (d != null && d.getDrawableType() == DrawableType.BLOCK) {
			
		}else
			w.addXOffset(-speedx);
	}
	
	public void stopFall() {
		speedy = 0;
	}
	
	public void fall() {
		if (speedy <= MAXFALLSPEED) {
			speedy += 0.2;
		}
		y += speedy;
	}
	
	public void grow() {
		if(size == 1) {
			lives ++;
			clear();
			size = 2;
			draw();
		}
	}
	
	public void damage() {
		if(lives >= 2) {
			lives --;
			clear();
			size = 1;
			draw();
		}else {
			lives = 0;
			clear();
			size = 0;
			
			System.exit(1000);
		}
	}
	
	public void pickUpCoin(int amount) {
		coins += amount;
	}

	@Override
	public void collide() {
		if (System.currentTimeMillis() - lastCollision >= COLLISIONDELAY) {
			damage();
			lastCollision = System.currentTimeMillis();	
		}
	}

}
