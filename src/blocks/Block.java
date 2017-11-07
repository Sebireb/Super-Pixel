package blocks;

import ledControl.BoardController;
import ledProjects.Drawable;

public abstract class Block implements Drawable {
	
	BoardController controller;
	int colors[][][];
	String name;
	int x;
	int y;
	int color[][];	
	int background[];

	public Block(int px, int py, int pcolor[][], BoardController pController, int pBackground[]) {
		x = px;
		y = py;
		color = pcolor;
		controller = pController;
		colors = controller.getColors();
		background = pBackground;
		draw();
	}

	@Override
	public void draw() {
		colors[x][y][0] = color[0][0];
		colors[x][y][1] = color[0][1];
		colors[x][y][2] = color[0][2];
		controller.updateLedStripe();
	}

	@Override
	public void clear() {
		controller.setColor(x, y, background);
		controller.updateLedStripe();
	}
	
	public void move(int dx, int dy){
		clear();
		x += dx;
		y += dy;
		draw();
	}
	
	abstract void action();

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
}
