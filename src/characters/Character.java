package characters;

import ledControl.BoardController;
import ledProjects.Drawable;

public abstract class Character implements Drawable {
	
	public final static int[][] MARIO = new int[][] {{127,0,0}};
	
	BoardController controller;
	String name;
	double x;
	double y;
	double speedx;
	double speedy;
	int color[][];
	int size;
	int state;
	int[] background;

	public Character(double x, double y, int color[][], int size, BoardController controller, int[] background) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
		this.controller = controller;
		this.background = background;
		state = 0;
		draw();
	}

	@Override
	public void draw() {
		for(double y = this.y-size; y < this.y; y++){
			controller.setColor((int) Math.round(x), (int)Math.round(y), color[state]);
		}	
	}

	@Override
	public void clear() {
		for(double y = this.y-size; y < this.y; y++){
			controller.setColor((int) Math.round(x), (int)Math.round(y), background);
		}	
	}
	
	public void move(double dx, double dy){
		x += dx;		
		y += dy;
	}
	
	public void addSpeedX(double speed){
		speedx += speed;
	}
	
	public void addSpeedY(double speed){
		speedy += speed;
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

	public double getSpeedx() {
		return speedx;
	}

	public void setSpeedx(double speedx) {
		this.speedx = speedx;
	}

	public double getSpeedy() {
		return speedy;
	}

	public void setSpeedy(double speedy) {
		this.speedy = speedy;
	}

}
