package worlds;

import blocks.Block;
import characters.Character;
import characters.Mario;
import ledControl.BoardController;
import ledProjects.Drawable;

public class World {
	private static final double MAX_FALL_SPEED = 0.3;
	
	BoardController controller;
	Block[] blocks;
	Character[] characters;
	Mario mario;
	private static boolean movement;
	private Drawable[][] drawables;
	private static double xOffset;

	public World(Block[] blocks, Character[] characters, BoardController controller, int sizeX, int sizeY) {
		this.controller = controller;
		this.blocks = blocks;
		this.characters = characters;
		drawables = new Drawable[sizeX][sizeY];
		for(Block b : blocks) {
			drawables[(int)b.getX()][(int)b.getY()] = b;
		}
		for(Character c : characters) {
			drawables[(int)c.getX()][(int)c.getY()] = c;
		}
		mario = (Mario) characters[0];
		allowMovement(true);
		xOffset = 0;
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

	public Drawable getCollideable(int x, int y) {
		try {
			return drawables[x - (int) Math.round(xOffset)][y];
		} catch (IndexOutOfBoundsException e) { // Außerhalb der Map
			return null;
		}
	}
	
	public boolean isSolid(double x, double y){
		for(Block b : blocks){
			if((int)Math.round(b.getX()) == (int)Math.round(x) && (int) Math.round(b.getY()) == (int) Math.round(y)){
				return true;
			}
		}
		return false;
	}
	
	public boolean blockBelowMario(){
		if(getCollideable((int)Math.round(mario.getX()), (int)Math.round(mario.getY())) != null){
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
			if(mario.getSpeedy() > MAX_FALL_SPEED){
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

	public Block[] getBlocks() {
		return blocks;
	}

	public Character[] getCharacters() {
		return characters;
	}

	public static boolean isMovementAllowed() {
		return movement;
	}

	public static void allowMovement(boolean movement) {
		World.movement = movement;
	}
	
	public void addXOffset(double xOffset) {
		World.xOffset += xOffset;
	}
	
	public static int getXOffset() {
		return (int) Math.round(xOffset);
	}

}
