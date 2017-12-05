package ledProjects;

import java.awt.event.KeyEvent;

import blocks.Block;
import blocks.Grass;
import characters.Character;
import characters.Mario;
import ledControl.BoardController;
import ledControl.gui.KeyBuffer;
import worlds.World;

public class MyFirstBoard {
	
	static BoardController controller = BoardController.getBoardController();
	public final static int[] background = new int[]{0, 0, 0};
	final static int[][] brick = new int[][]{{127,80,30}};
	final static int[][] eventBlock = new int[][]{{127,127,0},{127, 40, 0}};
	private static World w;
	private static KeyBuffer input;
	private static Thread t;

	public static void main(String[] args) {
		
		input = controller.getKeyBuffer();
		
		for(int x = 0; x < 12; x++) {
			for(int y = 0; y < 12; y++) {
				controller.setColor(x, y, background);
			}
		}
		controller.updateLedStripe();
		
		//TESTCODE
		
		Block[] b = new Block[50];
		for(int x = -15; x < 35; x++) {
			b[x+15] = new Grass(x, 11, Block.GRASS, controller, background);
		}
		Character[] c = new Character[]{new Mario(6, 6, Character.MARIO, 1, controller, background)};
		w = new World(b, c, controller);
		
		t = new Thread(new Update(controller, b, c, background));
		t.start();
		
		while(true){
			processInput(input.pop());
			input.clear();
			w.move();
			controller.sleep(200);
		}
	}
	
	public static void goRight(){
		if(w.getMario().getSpeedx()>1.5){
			return;
		}
		w.getMario().addSpeedX(0.5);
	}
	
	public static void goLeft(){
		if(w.getMario().getSpeedx()<-1.5){
			return;
		}
		w.getMario().addSpeedX(-0.5);
	}
	
	public static void jump() {
		if(w.blockBelowMario()){
			w.getMario().jump();
		}
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
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				jump();
			}
		}
	}
}
