package juego;

import java.awt.Color;
import java.util.Random;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
    private Entorno entorno;
    private Conejo conejo;
    private Auto [] autos;
    private Disparo [] disparos;
    private boolean jugando;
    private int puntos;
    private Imagen imagen;
    private int cantSaltos;
    private Calle calle1;
    private Calle calle2;
   
    
    public Juego()
    {
       
        this.entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo ... - v1", 800, 900);

        this.disparos= new Disparo[3];
        this.jugando= true;
        this.conejo= new Conejo(400,800,20);
        this.puntos=0;
        this.imagen= new Imagen();
        this.cantSaltos=0;
        
        
        this.autos=new Auto[10];
        for (int i=0; i<this.autos.length;i++) {
            Random rand= new Random();
            int num= rand.nextInt(10);
            if(i<=5) {
                this.autos[i]= new Auto(50*num,400+(i*20),15,30);
            }
            else {
                    this.autos[i]= new Auto(50*num,10+(i*20),15,30);
                }

            }
        this.calle1= new Calle(400, 380);
        this.calle2= new Calle(400, 100);
        
        this.entorno.iniciar();
    }


	public void sumarPuntos() {
		this.puntos=this.puntos +5;
	}
	
	public void sumarSaltos() {
		this.cantSaltos=this.cantSaltos +1;
	}
	
	public void tick(){	
		
				if(this.jugando) {
					this.imagen.dibujarse(this.entorno);
					this.imagen.bajando();
					this.entorno.cambiarFont("Puntos: ", 20, Color.WHITE);
					this.entorno.escribirTexto("Puntos: " + this.puntos, 10, 20);
					this.entorno.escribirTexto("Saltos: " + this.cantSaltos,10,50);
					
					 for (int i=0;i<this.disparos.length;i++) {
						 if(this.disparos[i]!=null) {
							 this.disparos[i].dibujarse(this.entorno);
							 this.disparos[i].moverArriba();
							 if(this.disparos[i].getY()<0) {
								 this.disparos[i]=null;
							 }
				        	}
					 }
					
					 for (int i=0; i<this.autos.length;i++) {
						if(this.autos[i]!=null) {
							this.autos[i].bajando();
							this.autos[i].dibujarse(entorno);
							if(i%2==0) {
								this.autos[i].moverDerecha();
							} else {
								this.autos[i].moverIzquierda();		
								}
							if (this.conejo.colisionAutoConejo(this.autos[i]) ||(this.conejo.getY()-this.conejo.getDiametro()/2)==900){
								jugando=false;
							}
							if(this.autos[i].colisionDisparo(this.disparos)) {
								this.autos[i]=null; 
								sumarPuntos();
							}
						
				
						}
					}
					this.conejo.dibujarse(this.entorno);
					this.conejo.bajando();
					this.calle1.bajando();
					this.calle2.bajando();
				
					if(this.calle1.getY()>=900) {
						for(int j = 0; j<this.autos.length; j++) {
							if(this.autos[j]==null) {
								Random rand= new Random();
					            int num= rand.nextInt(10);
					            if(j<=5) {
					            	this.autos[j]= new Auto(50*num,0+(j*20),15,30);
					            }  
							}
						}
					}
					
					if(this.calle2.getY()>=900) {
						int m=0;
						for(int j = 0; j<this.autos.length; j++) {
							if(this.autos[j]==null) {
								Random rand= new Random();
					            int num= rand.nextInt(10);
					            if(j>5) {
					                this.autos[j]= new Auto(50*num,0+(m*20),15,30);
					                m++;
					            }    
							}
						}
					}
				}
				

				
				if(this.entorno.sePresiono(this.entorno.TECLA_DERECHA)&& this.conejo.getX()<790) {
					this.conejo.moverDerecha();
				}
				if(this.entorno.sePresiono(this.entorno.TECLA_IZQUIERDA)&& this.conejo.getX()>10) {
					this.conejo.moverIzquierda();
				}
				if(this.entorno.sePresiono(this.entorno.TECLA_ARRIBA)&& this.conejo.getX()>10 && this.conejo.getY()>0) {
					this.conejo.moverArriba();
					sumarSaltos();
				}
				
				
				if(this.entorno.sePresiono(this.entorno.TECLA_ESPACIO)) {
					int i=0; 
					boolean flag= false;
					while(!flag && i<this.disparos.length) {
						 if(this.disparos[i]==null) {
						 	this.disparos[i]=this.conejo.disparar();
						 	flag=true;
						
						 }else {
							 
							 i++;
						 }
					  
					}
				}
	
}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
