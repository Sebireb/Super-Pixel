package blocks;

import ledControl.BoardController;

public class Brick extends Block {

	public Brick(int x, int y, int[][] color, BoardController controller, int[] background) {
		super(x, y, color, controller, background);
		name = "Brick";
	}

	@Override
	public void action() {
		clear();
	}

}
