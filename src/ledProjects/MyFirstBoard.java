package ledProjects;

import characters.Mario;
import ledControl.BoardController;

public class MyFirstBoard {
	
	static BoardController controller = BoardController.getBoardController();
	final static int[] background = new int[]{127, 127, 127};

	public static void main(String[] args) {
		for(int x = 0; x < 12; x++) {
			for(int y = 0; y < 12; y++) {
				controller.setColor(x, y, background);
			}
		}
		controller.updateLedStripe();
		
		Mario mario = new Mario(6, 6, new int[][] {{127,0,0}}, 1, controller, background);
		controller.sleep(500);
		mario.grow();
		controller.sleep(500);
		mario.move(2, 2);
		controller.sleep(500);
		mario.damage();
		controller.sleep(500);
		mario.damage();
		
		System.out.println("implemented mario, fixed block & character");
	}

}
