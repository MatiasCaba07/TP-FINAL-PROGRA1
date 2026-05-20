package juego;

import java.awt.Color;

import entorno.Entorno;

public class Personaje {

    private int x;
    private int y;
    private int ancho;
    private int alto;


    public Personaje(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

//          MOV GLOBAL

    public void princesa(Entorno e){
        movIzq(e);
        movDer(e);
        movArr(e);
        movAba(e);
        dibujar(e);
    } 

    public void dibujar (Entorno e){
        e.dibujarRectangulo(x, y, ancho, alto, 0, Color.white);
    }

//         MOVIMIENTO

    public void movIzq(Entorno e){
        if(e.estaPresionada('a') && getX() - getAncho() / 2 > 0){
            this.x = this.x-3;
        }
    }

    public void movDer(Entorno e){
        if(e.estaPresionada('d') && getX() + getAncho() / 2 < e.ancho()){
            this.x = this.x+3;
        }
    }

    public void movArr(Entorno e){
        if(e.estaPresionada('w') && getY() - getAlto() / 2 > 0){
            this.y = this.y-3;
        }
    }

    public void movAba(Entorno e){
        if(e.estaPresionada('s') && getY() + getAlto() / 2 < e.alto()){
            this.y = this.y+3;
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
