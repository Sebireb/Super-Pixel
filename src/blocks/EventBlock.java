package blocks;

import ledControl.BoardController;

public class EventBlock extends Block{

	public EventBlock(int x, int y, BoardController controller, int[] background){
		super(x, y, Block.EVENTBLOCK, controller, background);
		name = "?-Block";
	}

	@Override
	public void collide() {
		state = 1;
		draw();
	}

}
