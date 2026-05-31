package juego;



import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	private Personaje p;
	private Enemigo[] enemigos;
	
	// Variables y métodos propios de cada grupo
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Proyecto para TP", 800, 600);
		
		
		// Inicializar lo que haga falta para el juego
		// ...

		p = new Personaje(entorno.ancho()/2, entorno.alto()/2, 20, 50);
		this.enemigos = new Enemigo[5];
		
		for(int i = 0; i< enemigos.length; i++) {
			int xAleatoria = 50 + (int)(Math.random() *700);  //generamos aleatoriamente la x entre 50 y 750 para que no salgan pegados al borde
			
			int yAleatoria = 100 +(int)(Math.random()* 200); // lo mismo pero con y
			
			enemigos[i] = new Enemigo(xAleatoria, yAleatoria, 30,30);
		}

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tie
		p.princesa(entorno);
		

	if (entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO) && p.getDisparo() == null) {
    	p.disparar(entorno);
	}
	if (p.getDisparo() != null) {
    	p.getDisparo().actualizar(entorno);

    	if (p.getDisparo().fueraDePantalla(entorno)) {
    		p.disparo = null;
    	}
	}

	// enemigos
	for(int i=0; i<enemigos.length;i++) {
		if(enemigos[i] !=null) {
			enemigos[i].enemigo(entorno);
			
			if(p.getDisparo() !=null) {
				if(Colisionador.verificarColision(p.getDisparo(), enemigos[i])) {
					enemigos[i] = null;
					p.disparo =null;
				}
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
