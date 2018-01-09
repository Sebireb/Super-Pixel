package blocks;

import ledControl.BoardController;

public class Brick extends Block {

	public Brick(int x, int y, BoardController controller, int[] background) {
		super(x, y, Block.BRICK, controller, background);
		name = "Brick";
	}

	@Override
	public void action() {
		clear();
	}

}
