package ledProjects;

import java.awt.event.KeyEvent;

import blocks.Block;
import blocks.EventBlock;
import characters.Character;
import characters.Mario;
import ledControl.BoardController;
import ledControl.gui.KeyBuffer;
import worlds.World;

public class MyFirstBoard {
	
	static BoardController controller = BoardController.getBoardController();
	public final static int[] background = new int[]{127, 127, 127};
	final static int[][] brick = new int[][]{{127,80,30}};
	final static int[][] eventBlock = new int[][]{{127,127,0},{127, 40, 0}};
	private static World w;
	private static KeyBuffer input;

	public static void main(String[] args) {
		
		input = controller.getKeyBuffer();
		
		for(int x = 0; x < 12; x++) {
			for(int y = 0; y < 12; y++) {
				controller.setColor(x, y, background);
			}
		}
		controller.updateLedStripe();
		
		//TESTCODE
		
		w = new World(new Block[]{new EventBlock(2, 2, Block.EVENTBLOCK, controller, background)}, new Character[]{new Mario(6, 6, new int[][]{{127,0,0}}, 1, controller, background)}, controller);
		
		while(true){
			processInput(input.pop());
		}
	}
	
	public static void goRight(){
		w.move(-1, 0);
	}
	
	public static void goLeft(){
		w.move(1, 0);
	}
	
	public static void processInput(KeyEvent e){
		if(e == null){
			return;
		}
		if(e.getID() == KeyEvent.KEY_PRESSED){
			if(e.getKeyCode() == KeyEvent.VK_A){
				goLeft();
			}
			if(e.getKeyCode() == KeyEvent.VK_D){
				goRight();
			}
		}
	}
}
