package characters;

import ledControl.BoardController;

public class Mario extends Character {
	
	int lives = 1;
	int coins = 0;

	public Mario(int px, int py, int[][] pcolor, int pgroe�e, BoardController pController, int[] pBackground) {
		super(px, py, pcolor, pgroe�e, pController, pBackground);
	}
	
	public void grow() {
		if(groe�e == 1) {
			lives ++;
			clear();
			groe�e = 2;
			draw();
		}
	}
	
	public void damage() {
		if(lives >= 2) {
			lives --;
			clear();
			groe�e = 1;
			draw();
		}else {
			lives = 0;
			clear();
			groe�e = 0;
		}
	}
	
	public void pickUpCoin(int amount) {
		coins += amount;
	}

}
