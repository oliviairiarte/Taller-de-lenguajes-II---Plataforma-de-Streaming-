package clases;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Clase abstracta base que representa cualquier contenido de audio publicable en la plataforma.
 * Define la estructura común para obras como {@link Cancion}, {@link EpisodioPodcast} y {@link Audiolibro},
 * almacenando sus métricas de interacción, reproducción y recaudación. 
 */
public abstract class Contenido {
    private String id;
    private int duracionEnSegundos;
    private int cantReproducciones;
    private String nombre;
    private LocalDate fechaLanzamiento;
    private Generos genero; 
    private UsuarioCreador creador;
    private int cantMeGusta;
    private double recaudadoTotal;
    private int reproduccionesMujeres;
    private int reproduccionesHombres;
    
    /**
     * Constructor base para inicializar un nuevo contenido con sus métricas en cero. 
     * @param nombre Título o nombre del contenido.
     * @param duracionEnSegundos Duración total expresada en segundos. 
     * @param genero {@link Generos Género} temático o musical del contenido.
     * @param creador {@link UsuarioCreador} autor y dueño de la obra. 
     */
    public Contenido(String nombre, int duracionEnSegundos, Generos genero, UsuarioCreador creador){
        this.nombre= nombre;
        this.duracionEnSegundos= duracionEnSegundos;
        this.genero= genero;
        this.creador= creador;
        this.id= "cnt-"+UUID.randomUUID().toString().substring(0, 8);
        this.fechaLanzamiento= LocalDate.now();
        this.cantReproducciones= 0;
        this.cantMeGusta= 0;
        this.recaudadoTotal=0;
        this.reproduccionesMujeres=0;
        this.reproduccionesHombres=0;
    }

    /**
     * Método abstracto que ejecutará la reproducción específica de cada tipo de contenido. 
     */
    public abstract void reproducirContenido();

    /**
     * Incrementa en una unidad el contador global de reproducciones del contenido.
     */
    public void incrementarReproducciones(){
        this.cantReproducciones++;
    }

    /**
     * Incrementa en una unidad el contador total de me gusta recibidos. 
     */
    public void incrementarMeGusta(){ //se pueden ver  normal los me gusta??
        this.cantMeGusta++;
    }

    /**
     * Determina la tendencia demográfica de los oyentes según el conteo por género.
     * @return Cadena que indica el género predominante ("Femenino", "Masculino" o "Equitativo"). 
     */
    public String getGeneroPredominaOyentes(){
        if (this.reproduccionesMujeres> this.reproduccionesHombres){
            return "Femenino";
        }else{
            if (this.reproduccionesHombres > this.reproduccionesMujeres){
                return "Masculino";
            }
        }
        return "Equitativo";
    }
    
    @Override
    public String toString(){ 
        return getNombre() + " by " + (this.creador != null ? this.creador.getNombreUsuario() : "Desconocido"); 
    }

    // --Getters --
    public int getReproducciones(){
        return this.cantReproducciones;
    }

    public String getId(){
        return this.id;
    }

    public int getDuracion(){
        return this.duracionEnSegundos;
    }

    public UsuarioCreador getArtista(){
        return this.creador;
    }

    public String getNombre(){
        return this.nombre;
    }

    public Generos getGenero(){ 
        return this.genero;
    }

    public LocalDate getFechaLanzamiento(){
        return this.fechaLanzamiento;
    }

    public int getCantMeGusta(){
        return this.cantMeGusta;
    }

    public double getRecaudadoTotal(){
        return this.recaudadoTotal;
    }
}
