package clases;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Representa a un usuario consumidor en la plataforma de streaming.
 * Gestiona sus colecciones personales a traves de su {@link Biblioteca}, 
 * su {@link Plan} de suscripción actual y su historial de escuchas. 
 */

public class UsuarioConsumidor {
    private String id;
    private String nombreUsuario;
    private String email;
    private LocalDate fechaInicioCuenta;
    private Plan plan;
    private List<Reproduccion> historialReciente;
    private Biblioteca biblioteca;
    
    /** 
     * Inicializa un nuevo usuario consumidor asignándole un {@link PlanGratuito} default
     * y un identificador alfanumérico único.
     *  @param nombre Nombre de usuario para identificarse en la plataforma. 
     *  @param email Correo electrónico del usuario. 
     */

    public UsuarioConsumidor(String nombre, String email){
        this.nombreUsuario= nombre;
        this.email= email;
        this.id = "usr-" + UUID.randomUUID().toString().substring(0, 8);
        this.fechaInicioCuenta= LocalDate.now();
        this.biblioteca= new Biblioteca();
        this.historialReciente= new ArrayList<>();
        this.plan= new PlanGratuito(); //default
    }

    /**
     * Crea y registra una nueva lista de reproducción en la {@link Biblioteca}.
     * @param nombre Nombre descriptivo para la nueva {@link Playlist}. 
     * @return La {@link Playlist} creada e incorporada a la biblioteca. 
     */
    public Playlist crearPlaylist(String nombre){
        return this.biblioteca.crearPlaylist(nombre, this);
    }
    
    /**
     * Añade un {@link Contenido} a una {@link Playlist} guardada en la {@link Biblioteca}.
     * @param p {@link Playlist} destino donde se agregará el elemento.
     * @param c {@link Contenido} a incorporar en la lista. 
     */
    public void agregarAPlaylist(Playlist p, Contenido c){
        if (c!=null && p!=null){
            this.biblioteca.agregarAPlaylist(p,c);
        }
    }

    /**
     * Marca un {@link Contenido} como favorito guardándolo en la sección correspondiente de la {@link Biblioteca}.
     * @param c {@link Contenido} a marcar con "Me Gusta". 
     */
    public void marcarMeGusta(Contenido c){
        if (c!=null){
            this.biblioteca.marcarMeGusta(c);
        }
    }

    /**
     * Ejecuta la reproducción de un {@link Contenido} a través del {@link Reproductor} 
     * y {@link #registrarEscucha(Contenido) registra el evento} en el historial personal. 
     * @param c {@link Contenido} que se reproducirá. 
     */
    public void reproducirContenido(Contenido c){
        if (c!=null){
            Reproductor.reproducirContenido(c);
            registrarEscucha(c);
        }
    }

    /**
     * Añade un nuevo registro de {@link Reproduccion} al historial reciente del usuario.
     * @param c {@link Contenido} escuchado por el usuario. 
     */
    public void registrarEscucha(Contenido c){
        this.historialReciente.add(new Reproduccion(c));
    }
    
    @Override 
    public String toString(){
        return getNombreUsuario()+" ("+getEmail()+").";
    }

    // --- Getters y Setters
    public String getEmail(){
        return this.email;
    }
    public LocalDate getFechaInicioCuenta(){
        return this.fechaInicioCuenta;
    }
    public List<Reproduccion> getHistorial(){
        return this.historialReciente;
    }
    public Biblioteca getBiblioteca(){
        return this.biblioteca;
    }
     public String getId(){
        return this.id;
    }
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }
    public Plan getPlan(){
        return this.plan;
    }
    public void setPlan(Plan plan){
        this.plan= plan;
    }

}
