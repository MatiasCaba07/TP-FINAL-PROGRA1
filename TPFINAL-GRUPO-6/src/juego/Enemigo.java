package juego;

import java.awt.Color;

import entorno.Entorno;

public class Enemigo {

	private int x;
    private int y;
    private int ancho;
    private int alto;
    private String direccion;

  
    
    public Enemigo (int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.direccion = "izquierda";
    }
    
//  MOV GLOBAL

public void enemigo(Entorno enemigo){
	movIzq(enemigo);
	movDer(enemigo);
	dibujar(enemigo);
	} 

public void dibujar (Entorno enemigo){
enemigo.dibujarRectangulo(x, y, ancho, alto, 0, Color.yellow);
	}



// MOVIMIENTO

public void movIzq(Entorno e){
	if(this.direccion.equals("izquierda")){
		this.x = this.x-3;
		
		if(this.x - (this.ancho / 2) <= 0) {
			this.direccion = "derecha";
			}
		}
		
	}


public void movDer(Entorno e){
	if(this.direccion.equals("derecha")){
		this.x = this.x+3;
		
		if(getX() +(getAncho() /2)>=e.ancho()){
			this.direccion = "izquierda";
			}
		}
		
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

public int getAncho() {
    return ancho;
}

public void setAncho(int ancho) {
    this.ancho = ancho;
}

public int getAlto() {
    return alto;
}

public void setAlto(int alto) {
    this.alto = alto;
}

	}
