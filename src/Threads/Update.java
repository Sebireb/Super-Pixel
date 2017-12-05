package Threads;

import characters.Character;
import blocks.Block;
import ledControl.BoardController;

public class Update implements Runnable {

	BoardController controller;
	Block[] blocks;
	Character[] characters;
	int[] background;
	
	public Update(BoardController controller, Block[] blocks, Character[] characters, int[] background) {
		this.controller = controller;
		this.blocks = blocks;
		this.characters = characters;
		this.background = background;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int x = 0; x < 12; x++){
				for(int y = 0; y < 12; y++){
					controller.setColor(x, y, background);
				}
			}
			for(int i = 0; i < blocks.length; i++) {
				blocks[i].draw();
			}
			for(int i = 0; i < characters.length; i++){
				characters[i].draw();
			}
			
			controller.updateLedStripe();
		}
	}

}
