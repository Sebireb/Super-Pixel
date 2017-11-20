package worlds;

import blocks.Block;
import characters.Character;
import ledControl.BoardController;

public class World {
	
	BoardController controller;
	Block[] blocks;
	Character[] characters;

	public World(Block[] pBlocks, Character[] pCharacters, BoardController pController) {
		controller = pController;
		blocks = pBlocks;
		characters = pCharacters;
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
	
	public boolean isSolid(int x, int y){
		for(int i = 0; i < blocks.length; i++){
			if(blocks[i].getX() == x && blocks[i].getY() == y){
				return true;
			}
		}
		return false;
	}
	
	public boolean isEnemy(int x, int y){
		for(int i = 0; i < characters.length; i++){
			if(characters[i].getX() == x && characters[i].getY() == y && !characters[i].getName().equals("Mario")){
				return true;
			}
		}
		return false;
	}

}
