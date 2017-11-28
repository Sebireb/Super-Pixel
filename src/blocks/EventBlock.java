package blocks;

import ledControl.BoardController;

public class EventBlock extends Block{

	public EventBlock(int x, int y, int[][] color, BoardController controller, int[] background){
		super(x, y, color, controller, background);
		name = "?-Block";
	}

	@Override
	public void action() {
		state = 1;
		draw();
	}

}
