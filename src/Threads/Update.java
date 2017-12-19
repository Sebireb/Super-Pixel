package Threads;

import java.util.ArrayList;
import java.util.List;

import blocks.Block;
import characters.Character;
import ledControl.BoardController;
import ledProjects.Drawable;

public class Update implements Runnable {

	private BoardController controller;
	private List<Drawable> drawables = new ArrayList<Drawable>();
	int[] background;
	
	public Update(BoardController controller, Block[] blocks, Character[] characters, int[] background) {
		this.controller = controller;
		for(Block block : blocks) {
			drawables.add(block);
		}
		for(Character character : characters) {
			drawables.add(character);
		}
		this.background = background;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int x = 0; x < 12; x++){
				for(int y = 0; y < 12; y++){
					controller.setColor(x, y, background);
				}
			}
			for(Drawable drawable : drawables) {
				drawable.draw();
			}
			
			controller.updateLedStripe();
		}
	}

}
