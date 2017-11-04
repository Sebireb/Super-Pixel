package characters;

import java.awt.Color;

import ledControl.BoardController;
import ledProjects.Drawable;

public abstract class Character implements Drawable {
	
	BoardController controller = BoardController.getBoardController();
	int colors[][][] = controller.getColors();
	String name;
	int x[];
	int y[];
	Color color[][];

	public Character(int px[], int py[], Color pcolor[][]) {
		x = px;
		y = py;
		color = pcolor;
		draw();
	}

	@Override
	public void draw() {
		if(!(x[1] < 0 || x[0] > 12 || y[1] < 0 || y[0] > 12)){
			return;
		}
		for(int x = this.x[0]; x < this.x[1]; x++){
			for(int y = this.y[0]; y < this.y[1]; y++){
				colors[x][y][0] = color[x][y].getRed();
				colors[x][y][1] = color[x][y].getGreen();
				colors[x][y][2] = color[x][y].getBlue();
			}
		}
		controller.updateLedStripe();
	}

	@Override
	public void clear() {
		if(!(x[1] < 0 || x[0] > 12 || y[1] < 0 || y[0] > 12)){
			return;
		}
		for(int x = this.x[0]; x < this.x[1]; x++){
			for(int y = this.y[0]; y < this.y[1]; y++){
				for(int c = 0; c < 3; c++){
					colors[x][y][c] = 0;
				}
			}
		}
	}
	
	public void move(int dx, int dy){
		clear();
		for(int i = 0; i < x.length; i++){
			x[i] += dx;
		}
		for(int i = 0; i < y.length; i++){
			y[i] += dy;
		}
		draw();
	}

	public int[] getX() {
		return x;
	}

	public void setX(int[] x) {
		this.x = x;
	}

	public int[] getY() {
		return y;
	}

	public void setY(int[] y) {
		this.y = y;
	}

	public Color[][] getColor() {
		return color;
	}

	public void setColor(Color[][] color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}

}
