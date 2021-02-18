package juego;

import java.awt.Color;

import entorno.Entorno;

public class Auto {
	private int x;
	private double y;
	private int alto;
	private int ancho;
	
	
	public Auto(int x, double y, int alto, int ancho) {
		this.x=x;
		this.y=y;
		this.alto=alto;
		this.ancho=ancho;
	}

	public int getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	
	public int getAlto() {
		return this.alto;
	}
	
	public int getAncho() {
		return this.ancho;
	}
	public void moverIzquierda() {
		this.x=this.x-3;
		if (this.x<-100) {
			this.setX(800);
		}
	}
	public void moverDerecha() {
		this.x=this.x+5;
		if (this.x>900) {
			this.setX(0);
		}
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}


	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.RED);
	}
	public void bajando() {
		this.y=this.y+0.5;
		if(this.y>910) {
			this.setY(0);
		}
	}

	public boolean colisionDisparo(Disparo [] disparo) {
		for(int i= 0; i<disparo.length;i++) {
			if(disparo[i]!=null) {
			boolean ty=((this.y-this.alto/2)<=(disparo[i].getY()+disparo[i].getDiametro()/2) &&
					(this.y + this.alto/2)>=(disparo[i].getY()- disparo[i].getDiametro()/2));
				
			boolean tx=(this.x - this.ancho/2)<=disparo[i].getX() &&				
					disparo[i].getX()<= (this.x + this.ancho/2);
			if(tx && ty) {
				disparo[i]=null;
				return true;
				}
			}
		}
		return false;
	}
	

}
