package clases;

/**
 * Proporciona métodos de utilidad estáticos para simular las acciones de control
 * del reproductor multimedia de la plataforma (reproducir, pausar, adelantar).
 */
public class Reproductor {

    /**
     * Simula el avance en la barra de tiempo de un {@link Contenido}. 
     * @param segundos Cantidad de segundos a adelantar. 
     * @param c {@link Contenido} en reproducción. 
     */
    public static void adelantar(int segundos, Contenido c){
        if (c!=null && segundos>0){
            System.out.println("Adelantando "+c.getNombre()+", "+segundos+" segundos.");
        }
    }

    /**
     * Simula la pausa en la reproducción de un {@link Contenido}.
     * @param c {@link Contenido} a pausar.
     */
    public static void pausar(Contenido c){ 
        if (c!=null){
            System.out.println("Pausando "+c.getNombre());
        }
    }

    /**
     * Ejecuta la reproducción de un {@link Contenido} e incrementa sus métricas globales. 
     * @param c {@link Contenido} a reproducir.
     */
    public static void reproducirContenido(Contenido c){
        if (c!=null){
            c.reproducirContenido();
            c.incrementarReproducciones();
        }
    }
}
