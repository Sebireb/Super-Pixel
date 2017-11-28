package blocks;

import ledControl.BoardController;

public class Grass extends Block{

	public Grass(int x, int y, int[][] color, BoardController controller, int[] background){
		super(x, y, color, controller, background);
		name = "Grass";
	}

	@Override
	public void action() {
		
	}

	
}
