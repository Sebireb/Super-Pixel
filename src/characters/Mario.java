package characters;

import ledControl.BoardController;

public class Mario extends Character {
	
	int lives = 1;
	int coins = 0;

	public Mario(int px, int py, int[][] pcolor, int pgroeße, BoardController pController, int[] pBackground) {
		super(px, py, pcolor, pgroeße, pController, pBackground);
		name = "Mario";
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
		}
	}
	
	public void pickUpCoin(int amount) {
		coins += amount;
	}

}
