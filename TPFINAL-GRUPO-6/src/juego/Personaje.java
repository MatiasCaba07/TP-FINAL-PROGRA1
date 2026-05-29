package juego;

import java.awt.Color;

import entorno.Entorno;

public class Personaje {

    private int x;
    private int y;
    private int ancho;
    private int alto;

    private double velocidadY;
    private boolean enSuelo;

    public Proyectil getDisparo() {
        return disparo;
    }
    public Proyectil disparo;


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
        saltar(e);
        aplicarGravedad();
        controlarPiso(e);
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

        //SALTO

    public void saltar(Entorno e){
        if(e.sePresiono('w')) {
            if(enSuelo){
             velocidadY = -13;
              enSuelo = false;
            }
        }
    }


        //GRAVEDAD
    public void aplicarGravedad(){
        velocidadY += 0.5;
        y += velocidadY;
    }


        // COLISION CON EL PISO (se va a  cambiar)
    public void controlarPiso(Entorno e){
        if(y + alto/2 >= e.alto()){
            y = e.alto() - alto/2;
            velocidadY = 0;
            enSuelo = true;
            
        }
    }


        //DISPARO
    public void disparar(Entorno e) {
        double mouseX = e.mouseX();
        double mouseY = e.mouseY();

        double dx = mouseX - this.x;
        double dy = mouseY - this.y;

        disparo = new Proyectil(this.x, this.y, dx, dy);
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
