package juego;

import java.awt.Image;
import java.io.File;
import entorno.Entorno;

import entorno.Herramientas;

public class Imagen {
	 private Image imagen1;
	 private Image imagen2;
	 private double y1;
	 private double y2;
	 
	 
	public Imagen() {
		this.imagen1=Herramientas.cargarImagen("sprites"+File.separator+"FondoFinal.png");
		this.imagen2=Herramientas.cargarImagen("sprites"+File.separator+"FondoFinal.png");
		this.y1=350.0;
		this.y2=-550.0;
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(this.imagen1,400.0, this.y1, 0.0);
		entorno.dibujarImagen(this.imagen2,400.0, this.y2, 0.0);
	}
		
	
	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public void bajando() {
		this.y1=this.y1 +0.5;
		this.y2=this.y2 +0.5;
		if (this.y1>1320.0) {
			setY1(-500.0);
		}
		if (this.y2>1320.0) {
			setY2(-500.0);
		}
	}
}
