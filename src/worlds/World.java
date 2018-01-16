package worlds;

import Items.Item;
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
	Item[] items;
	Mario mario;
	private static boolean movement;
	private Drawable[][] drawables;
	private static double xOffset;

	public World(Block[] blocks, Character[] characters, Item[] items, BoardController controller, int sizeX, int sizeY) {
		this.controller = controller;
		this.blocks = blocks;
		this.characters = characters;
		this.items = items;
		drawables = new Drawable[sizeX][sizeY];
		for(Block b : blocks) {
			drawables[(int)b.getX()][(int)b.getY()] = b;
		}
		for(Character c : characters) {
			drawables[(int)c.getX()][(int)c.getY()] = c;
		}
		for(Item i : items) {
			drawables[(int)i.getX()][(int)i.getY()] = i;
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
		} catch (IndexOutOfBoundsException e) { // Outside the map
			return null;
		}
	}
	
	public Drawable drawableBelowMario(){
		Drawable d = getCollideable((int)Math.round(mario.getX()), (int)Math.round(mario.getY()));
		return d;
	}
	
	public Drawable drawableAboveMario() {
		Drawable d = getCollideable((int)Math.round(mario.getX()), (int)Math.round(mario.getY() - 1.5));
		return d;
	}
	
	public void fall() {
		if(drawableBelowMario() == null) {
			if(mario.getSpeedY() > MAX_FALL_SPEED){
				return;
			}
			mario.addSpeedY(0.1);
		}else if(mario.getSpeedY() > 0){
			mario.setSpeedY(0);
		}
	}
	
	public void removeDrawable(Drawable d) {
		int x = (int) Math.round(d.getX());
		int y = (int) Math.round(d.getY());
		drawables[x][y] = null;		
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
	
	public Drawable[][] getDrawables(){
		return drawables;
	}
	
	public static int getXOffset() {
		return (int) Math.round(xOffset);
	}

}
