package ledProjects;

import blocks.Brick;
import blocks.EventBlock;
import ledControl.BoardController;

public class MyFirstBoard {
	
	static BoardController controller = BoardController.getBoardController();
	final static int[] background = new int[]{127, 127, 127};
	final static int[][] brick = new int[][]{{127,80,30}};
	final static int[][] eventBlock = new int[][]{{127,127,0},{127, 40, 0}};

	public static void main(String[] args) {
		for(int x = 0; x < 12; x++) {
			for(int y = 0; y < 12; y++) {
				controller.setColor(x, y, background);
			}
		}
		controller.updateLedStripe();
		
		EventBlock block = new EventBlock(5, 5, eventBlock, controller, background);
		Brick block2 = new Brick(6,6,brick,controller,background);
		controller.sleep(500);
		block.action();
		block2.action();
		
		System.out.println("");
	}
}
