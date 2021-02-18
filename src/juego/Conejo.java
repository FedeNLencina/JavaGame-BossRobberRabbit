package juego;

import java.awt.Color;

import entorno.Entorno;

public class Conejo {
	private int x;
	private double y;
	private int diametro;
	
	
	public Conejo(int x,int y, int diametro) {
		this.x=x;
		this.y=y;
		this.diametro=diametro;	
		
	}
	public int getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public int getDiametro() {
		return this.diametro;
	}
	
	public void moverIzquierda() {
		this.x=this.x-10;
	}
	public void moverDerecha() {
		this.x=this.x+10;
	}
	public void moverArriba() {
		this.y=this.y-15;
	}
	
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarCirculo(this.x, this.y, this.diametro, Color.BLUE);
	}
	public void bajando() {
		this.y=this.y+0.5;
	}
	
	public Disparo disparar() {
		 Disparo disparo= new Disparo(this.x,this.y,10);
		return disparo;
	}
	
	public boolean colisionAutoConejo(Auto auto) {
		
		boolean ty=((auto.getY()-auto.getAlto()/2)<=(this.y+this.diametro/2) &&
				(auto.getY()+auto.getAlto()/2)>=(this.y- this.diametro/2));
			
		boolean tx=(auto.getX() - auto.getAncho()/2)<=this.x &&				
				this.x<= (auto.getX() + auto.getAncho()/2);
				
			if(tx && ty) {
				return true;
			}
			
		return false;
	}
}
