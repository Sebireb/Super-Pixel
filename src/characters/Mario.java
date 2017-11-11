package characters;

import ledControl.BoardController;

public class Mario extends Character {
	
	int lives = 1;
	int coins = 0;

	public Mario(int px, int py, int[][] pcolor, int pgroeﬂe, BoardController pController, int[] pBackground) {
		super(px, py, pcolor, pgroeﬂe, pController, pBackground);
	}
	
	public void grow() {
		if(groeﬂe == 1) {
			lives ++;
			clear();
			groeﬂe = 2;
			draw();
		}
	}
	
	public void damage() {
		if(lives >= 2) {
			lives --;
			clear();
			groeﬂe = 1;
			draw();
		}else {
			lives = 0;
			clear();
			groeﬂe = 0;
		}
	}
	
	public void pickUpCoin(int amount) {
		coins += amount;
	}

}
