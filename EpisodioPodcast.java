package clases;

/**
 * Representa un episodio de un podcast dentro de la plataforma de streaming.
 * Hereda de {@link Contenido} y añade detalles propios de la emisión como número de episodio, 
 * resumen temático e invitado especial.
 */
public class EpisodioPodcast extends Contenido{
    private int numeroEpisodio;
    private String resumen; 
    private String invitado;
    
    /**
     * Constructor completo para un episodio con invitado especial. 
     * @param nombre Título del episodio. 
     * @param duracionEnSegundos Duración total en segundos.
     * @param genero {@link Generos Género} o categoría temática.
     * @param creador {@link UsuarioCreador} o conductor del podcast.
     * @param resumen Breve descripción del tema abordado en el episodio.
     * @param invitado Nombre del invitado especial (puede ser {@code null}). 
     * @param numeroEpisodio Número ordinal del episodio.
     */
    public EpisodioPodcast(String nombre, int duracionEnSegundos, Generos genero, 
    UsuarioCreador creador, String resumen, String invitado, int numeroEpisodio){
        super(nombre,duracionEnSegundos,genero,creador);
        this.numeroEpisodio= numeroEpisodio;
        this.invitado= invitado;
        this.resumen= resumen;
    }

    /**
     * Constructor sobrecargado para un episodio sin invitado especial. 
     * @param nombre Título del episodio.
     * @param duracionEnSegundos Duración total en segundos.
     * @param genero {@link Generos Género} o categoría temática.
     * @param creador {@link UsuarioCreador} o conductor del podcast. 
     * @param resumen Breve descripción del tema abordado.
     * @param numeroEpisodio Número ordinal del episodio.
     */
    public EpisodioPodcast(String nombre, int duracionEnSegundos, Generos genero, 
    UsuarioCreador creador, String resumen, int numeroEpisodio){
        this(nombre, duracionEnSegundos, genero, creador, resumen, null, numeroEpisodio);
    }

    /**
     * Ejecuta la reproducción del episodio e incrementa sus métricas globales.
     */
    @Override 
    public void reproducirContenido(){
        System.out.println("Reproduciendo el episodio n° "+getNumeroEpisodio()
        +", "+toString());
        incrementarReproducciones();
    }

    // ---Getters ----
    public int getNumeroEpisodio(){
        return this.numeroEpisodio;
    }

    public String getInvitado(){
        return this.invitado;
    }

    public String getResumen(){
        return this.resumen;
    }
}
