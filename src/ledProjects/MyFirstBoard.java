package ledProjects;

import java.awt.event.KeyEvent;

import Threads.Update;
import Threads.xMovement;
import Threads.yMovement;
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
	private static Thread t, t2, t3;
	private static yMovement yMovement;

	public static void main(String[] args) {
		
		input = controller.getKeyBuffer();
		
		for(int x = 0; x < 12; x++) {
			for(int y = 0; y < 12; y++) {
				controller.setColor(x, y, background);
			}
		}
		controller.updateLedStripe();
		
		//TESTCODE
		
		Block[] b = new Block[42];
		for(int x = 0; x < 30; x++) {
			b[x] = new Grass(x, 11, controller, background);
		}
		for(int x = 0; x < 10; x++) {
			b[x+30] = new Grass(x, 5, controller, background);
		}
		
		b[40] = new Grass(10, 9, controller, background);
		b[41] = new Grass(10, 10,  controller, background);
		Character[] c = new Character[]{new Mario(6, 0, 1, controller, background)};
		w = new World(b, c, controller, 100, 12);
		
		//-----------
		
		t = new Thread(new Update(controller, b, c, background));
		t.start();
		
		t2 = new Thread(new xMovement(w, w.getMario()));
		t2.start();
		
		yMovement = new yMovement(w);
		
		t3 = new Thread(yMovement);
		t3.start();
		
		while(true){
			processInput(input.pop());
			input.clear();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void goRight(){
		w.getMario().setSpeedX(-1);
	}
	
	public static void goLeft(){
		w.getMario().setSpeedX(1);
	}
	
	public static void stopXMovement() {
		w.getMario().setSpeedX(0);
	}
	
	public static void jump() {
		if(w.blockBelowMario()){
			yMovement.jump();
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
		if(e.getID() == KeyEvent.KEY_RELEASED){
			if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D){
				stopXMovement();
			}
		}
	}
}
