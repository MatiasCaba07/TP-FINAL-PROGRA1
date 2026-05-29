package juego;

import java.awt.Color;

import entorno.Entorno;

public class Proyectil {

    double x, y;
    double dx, dy;
    int radio = 18;

    public Proyectil(double x, double y, double dx, double dy) {
        this.x = x;
        this.y = y;

        double distancia = Math.sqrt(dx * dx + dy * dy);

        if (distancia == 0) {
            this.dx = 1;
            this.dy = 0;
        } else {
            this.dx = dx / distancia * 7;
            this.dy = dy / distancia * 7;
        }
    }

    public boolean fueraDePantalla(Entorno e) {
        return x < 0 || x > e.ancho() || y < 0 || y > e.alto();
    }

    public void actualizar(Entorno e) {
        mover();
        dibujar(e);
    }

    private void mover() {
        this.x += dx;
        this.y += dy;
    }

    private void dibujar(Entorno e) {
        e.dibujarCirculo(this.x, this.y, radio, Color.RED);
    }
}
