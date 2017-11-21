package ledProjects;

import characters.Character;
import blocks.Block;
import ledControl.BoardController;

public class Update extends Thread {

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
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//			for(int i = 0; i < blocks.length; i++) {
//				blocks[i].draw();
//			}
//			for(int i = 0; i < characters.length; i++) {
//				characters[i].draw();
//			}

			Block[][] b = new Block[12][12];
			Character[][] c = new Character[12][12];
			for(int i = 0; i < blocks.length; i++) {
				int x = blocks[i].getX();
				int y = blocks[i].getY();
				if(onBoard(x, y)) {
					b[x][y] = blocks[i];
				}
			}
			for(int i = 0; i < characters.length; i++) {
				int x = characters[i].getX();
				int y = characters[i].getY();
				if(onBoard(x, y)) {
					c[x][y] = characters[i];
				}
			}
			
			for(int x = 0; x < 12; x++) {
				for(int y = 0; y < 12; y++) {
					if(b[x][y] != null) {
						controller.setColor(x, y, b[x][y].getColor()[b[x][y].getState()]);
					}else
					if(c[x][y] != null) {
						controller.setColor(x, y, c[x][y].getColor()[c[x][y].getState()]);
					}else controller.setColor(x, y, background);
				}
			}
			
			controller.updateLedStripe();
		}
	}
	
	public boolean onBoard(int x, int y) {
		if(x < 0 || x >= 12 || y < 0 || y >= 12) {
			return false;
		}
		return true;
	}

}
