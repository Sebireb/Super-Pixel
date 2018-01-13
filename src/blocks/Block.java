package blocks;

import ledControl.BoardController;
import ledProjects.Drawable;
import worlds.World;

public abstract class Block implements Drawable {

	public final static int[][] EVENTBLOCK = new int[][]{{127, 127, 0},{127, 50, 50}};
	public final static int[][] BRICK = new int[][] {{127, 70, 20}};
	public final static int[][] GRASS = new int[][] {{0, 127, 0}};
	
	BoardController controller;
	String name;
	double x;
	double y;
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
		controller.setColor((int) Math.round(x) + World.getXOffset(), (int) Math.round(y), color[state]);
	}

	@Override
	public void clear() {
		controller.setColor((int) Math.round(x) + World.getXOffset(), (int) Math.round(y), background);
	}
	
	@Override
	public void collide() { }
	
	public void move(double dx, double dy){
		x += dx;
		y += dy;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
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
