package juego;

import entorno.Entorno;

public class Calle {
	private int x;
	private double y;
	
	
	public Calle(int x, double y) {
		this.x=x;
		this.y=y;
		
	}
	public int getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}
	public void bajando() {
		this.y=this.y+0.5;
		if(this.y>901) {
			this.setY(0);
		}
	}
	
}
