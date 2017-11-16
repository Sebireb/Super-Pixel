package ledProjects;

import blocks.Block;
import blocks.EventBlock;
import ledControl.BoardController;
import worlds.World;

public class MyFirstBoard {
	
	static BoardController controller = BoardController.getBoardController();
	public final static int[] background = new int[]{127, 127, 127};
	final static int[][] brick = new int[][]{{127,80,30}};
	final static int[][] eventBlock = new int[][]{{127,127,0},{127, 40, 0}};

	public static void main(String[] args) {
		for(int x = 0; x < 12; x++) {
			for(int y = 0; y < 12; y++) {
				controller.setColor(x, y, background);
			}
		}
		controller.updateLedStripe();
		
		//Testcode
		
		Block[] b = new Block[12];
		for(int i = 0; i < b.length; i++){
			b[i] = new EventBlock(i, i, Block.EVENTBLOCK, controller, background);
		}
		
		World w = new World(b, controller);
		controller.sleep(500);
		for(int i = 0; i < 10; i++){
			w.move(1, 1);	
			controller.sleep(500);
		}
		
		System.out.println("implemented Brick");
	}
}
