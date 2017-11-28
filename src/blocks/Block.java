package blocks;

import ledControl.BoardController;
import ledProjects.Drawable;

public abstract class Block implements Drawable {
	
	public final static int[][] EVENTBLOCK = new int[][]{{127, 127, 0},{127, 50, 50}};
	public final static int[][] BRICK = new int[][] {{127, 70, 20}};
	public final static int[][] GRASS = new int[][] {{0, 127, 0}};
	
	BoardController controller;
	String name;
	int x;
	int y;
	int color[][];	
	int background[];
	int state;

	public Block(int x, int y, int color[][], BoardController controller, int background[]) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.controller = controller;
		this.background = background;
		state = 0;
		draw();
	}

	@Override
	public void draw() {
		controller.setColor(x, y, color[state]);
	}

	@Override
	public void clear() {
		controller.setColor(x, y, background);
	}
	
	public void move(int dx, int dy){
		x += dx;
		y += dy;
	}
	
	abstract public void action();

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int[][] getColor() {
		return color;
	}

	public void setColor(int[][] color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}
	
	public void setState(int state) {
		this.state = state;
	}
	
	public int getState() {
		return state;
	}
}
