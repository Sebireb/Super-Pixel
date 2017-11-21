package characters;

import ledControl.BoardController;
import ledProjects.Drawable;

public abstract class Character implements Drawable {
	
	public final static int[][] MARIO = new int[][] {{127,0,0}};
	
	BoardController controller;
	int colors[][][];
	String name;
	int x;
	int y;
	int color[][];
	int size;
	int state;
	int[] background;

	public Character(int px, int py, int pcolor[][], int pSize, BoardController pController, int[] pBackground) {
		x = px;
		y = py;
		color = pcolor;
		size = pSize;
		controller = pController;
		colors = controller.getColors();
		background = pBackground;
		state = 0;
		draw();
	}

	@Override
	public void draw() {
		for(int y = this.y-size; y < this.y; y++){
			controller.setColor(x, y, color[state]);
		}	
	}

	@Override
	public void clear() {
		for(int y = this.y-size; y < this.y; y++){
			controller.setColor(x, y, background);
		}
	}
	
	public void move(int dx, int dy){
		clear();
		x += dx;		
		y += dy;
	}

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

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void setState(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

}
