package juego;

public class Colisionador {

	public static boolean verificarColision(Proyectil p, Enemigo e) {
		double diferenciaX = p.getX() - e.getX();
		double diferenciaY = p.getY() - e.getY();
		
		double distancia = Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY));
		
		double radioEnemigo = e.getAncho() / 2.0;
		return distancia <= (p.getRadio() + radioEnemigo);
		
	}
	
	
	
}
