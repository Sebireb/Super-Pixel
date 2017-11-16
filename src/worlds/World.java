package worlds;

import blocks.Block;
import characters.Character;
import characters.Mario;
import ledControl.BoardController;
import ledProjects.MyFirstBoard;

public class World {
	
	BoardController controller;
	Block[] blocks;
	Character[] characters;

	public World(Block[] pBlocks, BoardController pController) {
		controller = pController;
		blocks = pBlocks;
		characters = new Character[1];
		characters[0] = new Mario(6, 6, new int[][]{{127, 0, 0}}, 1, controller, MyFirstBoard.background);
		controller.updateLedStripe();
	}
	
	public void move(int dx, int dy){
		for(int i = 0; i < blocks.length; i++){
			blocks[i].move(dx, dy);	
		}
		for(int i = 0; i < blocks.length; i++){
			blocks[i].draw();
		}
		for(int i = 0; i < characters.length; i++){
			if(!characters[i].getName().equals("Mario")){
				characters[i].move(dx, dy);
			}
		}
		for(int i = 0; i < characters.length; i++){
			characters[i].draw();
		}
		controller.updateLedStripe();
	}

}
