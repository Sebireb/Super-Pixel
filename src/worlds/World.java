package worlds;

import blocks.Block;
import characters.Character;
import characters.Mario;
import ledControl.BoardController;

public class World {
	
	BoardController controller;
	Block[] blocks;
	Character[] characters;
	Mario mario;

	public World(Block[] pBlocks, Character[] pCharacters, BoardController pController) {
		controller = pController;
		blocks = pBlocks;
		characters = pCharacters;
		mario = (Mario) characters[0];
		controller.updateLedStripe();
	}
	
	public void move(int dx, int dy){
		for(int i = 0; i < blocks.length; i++){
			blocks[i].move(dx, dy);	
		}
		for(int i = 0; i < characters.length; i++){
			if(!characters[i].getName().equals("Mario")){
				characters[i].move(dx, dy);
			}
		}
	}
	
	public boolean isSolid(double x, double y){
		for(int i = 0; i < blocks.length; i++){
			if((int)Math.round(blocks[i].getX()) == (int)Math.round(x) && (int) Math.round(blocks[i].getY()) == (int) Math.round(y)){
				return true;
			}
		}
		return false;
	}
	
	public boolean blockBelowMario(){
		if(isSolid(Math.round((int)mario.getX()), (int)Math.round(mario.getY()))){
			return true;
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
	
	public void fall() {
		if(! blockBelowMario()) {
			if(mario.getSpeedy() > 0.3){
				return;
			}
			mario.addSpeedY(0.1);
		}else if(mario.getSpeedy() > 0){
			mario.setSpeedy(0);
		}
	}

	public Mario getMario() {
		return mario;
	}

}
