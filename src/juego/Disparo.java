package juego;

import java.awt.Color;

import entorno.Entorno;

public class Disparo {
	private int x;
	private double y;
	private int diametro;


	
	public Disparo(int x, double y,int diametro) {
		this.x=x;
		this.y=y;
		this.diametro=diametro;

	}
	
	void dibujarse(Entorno entorno) {
		entorno.dibujarCirculo(x, y, diametro, Color.ORANGE);
	}
	
	public int getX() {
		return this.x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getY() {
		return this.y;
	}
	
	public int getDiametro() {
		return this.diametro;
	}
	

	void moverArriba() {
		this.y=this.y - 10;
		
	}
}
