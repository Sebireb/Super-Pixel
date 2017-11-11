package blocks;

import ledControl.BoardController;

public class Brick extends Block {

	public Brick(int px, int py, int[][] pcolor, BoardController pController, int[] pBackground) {
		super(px, py, pcolor, pController, pBackground);
		name = "Brick";
	}

	@Override
	public void action() {
		clear();
	}

}
