package characters;

import ledControl.BoardController;
import ledProjects.Drawable;

public abstract class Character implements Drawable {
	
	BoardController controller;
	int colors[][][];
	String name;
	int x;
	int y;
	int color[][];
	int groeﬂe;
	int[] background;

	public Character(int px, int py, int pcolor[][], int pGroeﬂe, BoardController pController, int[] pBackground) {
		x = px;
		y = py;
		color = pcolor;
		groeﬂe = pGroeﬂe;
		controller = pController;
		colors = controller.getColors();
		background = pBackground;
		draw();
	}

	@Override
	public void draw() {
			for(int y = this.y-groeﬂe; y < this.y; y++){
				colors[x][y][0] = color[0][0];
				colors[x][y][1] = color[0][1];
				colors[x][y][2] = color[0][2];
			}		
		controller.updateLedStripe();
	}

	@Override
	public void clear() {
		for(int y = this.y-groeﬂe; y < this.y; y++){
			controller.setColor(x, y, background);
		}
	}
	
	public void move(int dx, int dy){
		clear();
		x += dx;		
		y += dy;
		draw();
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

	public int getGroeﬂe() {
		return groeﬂe;
	}

	public void setGroeﬂe(int groeﬂe) {
		this.groeﬂe = groeﬂe;
	}

}
