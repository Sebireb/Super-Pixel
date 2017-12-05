package characters;

import ledControl.BoardController;

public class Mario extends Character {
	
	int lives;
	int coins;
	int direction = 0;

	public Mario(int x, int y, int[][] color, int size, BoardController controller, int[] background) {
		super(x, y, color, size, controller, background);
		name = "Mario";
		lives = 1;
		coins = 0;
		speedx = 0;
		speedy = 0;
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
			
			//GAMEOVER
		}
	}
	
	public void pickUpCoin(int amount) {
		coins += amount;
	}
	
	public void jump(){
		addSpeedY(-1.5);
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public int getDirection() {
		return direction;
	}

}
