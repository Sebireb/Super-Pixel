package blocks;

import java.awt.Color;

import ledControl.BoardController;
import ledProjects.Drawable;

public abstract class Block implements Drawable {
	
	BoardController controller = BoardController.getBoardController();
	int colors[][][] = controller.getColors();
	String name;
	int x;
	int y;
	Color color;	

	public Block(int px, int py, Color pcolor) {
		x = px;
		y = py;
		color = pcolor;
		draw();
	}

	@Override
	public void draw() {
		if(!(x < 0 || x > 12 || y < 0 || y > 12)){
			return;
		}
		colors[x][y][0] = color.getRed();
		colors[x][y][1] = color.getGreen();
		colors[x][y][2] = color.getBlue();
		controller.updateLedStripe();
	}

	@Override
	public void clear() {
		if(!(x < 0 || x > 12 || y < 0 || y > 12)){
			return;
		}
		for(int c = 0; c < 3; c++){
			colors[x][y][c] = 0;
		}
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getName() {
		return name;
	}
}
