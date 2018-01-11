package characters;

import ledControl.BoardController;

public class Mario extends Character {
	
	int lives;
	int coins;

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

}
