package blocks;

import ledControl.BoardController;

public class EventBlock extends Block{

	public EventBlock(int px, int py, int pc[][], BoardController pController, int[] pBackground){
		super(px, py, pc, pController, pBackground);
		name = "?-Block";
	}

	@Override
	public void action() {
		state = 1;
		draw();
	}

}
