package blocks;

import ledControl.BoardController;

public class Grass extends Block{

	public Grass(int px, int py, int[][] pcolor, BoardController pController, int[] pBackground) {
		super(px, py, pcolor, pController, pBackground);
		name = "Grass";
	}

	@Override
	public void action() {
		
	}

	
}
