package clases;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestiona la colección privada de listas de reproducción de un {@link UsuarioConsumidor}.
 * Administra tanto las {@link Playlist} creadas como la lista especial de favoritos.
 */

public class Biblioteca {
    private List<Playlist> playlistsGenerales;
    private Playlist playlistMeGusta;

    /**
     * Inicializa la biblioteca instanciando la lista de colecciones generales 
     * y la {@link Playlist} especial de favoritos. 
     */
    public Biblioteca(UsuarioConsumidor user){
        this.playlistsGenerales= new ArrayList<>();
        this.playlistMeGusta= new Playlist("Me gusta", user);
    }

    /**Instancia e incorpora una nueva {@link Playlist} a la biblioteca personal. 
     * @param nombre Nombre descriptivo para la nueva lista.
     * @return La {@link Playlist} creada e incorporada. 
     */
    public Playlist crearPlaylist(String nombre, UsuarioConsumidor creador){
        Playlist p= new Playlist(nombre,creador);
        this.playlistsGenerales.add(p);
        return p;
    }

    /**Incorpora un {@link Contenido} a una {@link Playlist} específica de la biblioteca. 
     * @param p {@link Playlist} destino. 
     * @param c {@link Contenido} a agregar.
     */
    public void agregarAPlaylist(Playlist p, Contenido c){
        if (p!=null && c!=null){
            p.agregarContenido(c);
        }
    }

    /**Registra un {@link Contenido} en la lista de favoritos e incrementa sus métricas.
     * @param c {@link Contenido} a marcar con "Me Gusta".
     */
    public void marcarMeGusta(Contenido c){
        if (c!=null){ 
            this.playlistMeGusta.agregarContenido(c);
            c.incrementarMeGusta();
        }
    }

    /**Remueve una {@link Playlist} de la biblioteca personal del usuario. 
     * @param p {@link Playlist} a eliminar.
     */
    public void eliminarPlaylist(Playlist p){
        if (p!=null){
            if (this.playlistsGenerales.remove(p)) { 
                System.out.println("Se eliminó " + p.getNombre()); 
            } else { 
                System.out.println("La playlist " + p.getNombre() + " no existe."); 
            }
        }
    }

    /**Busca y retorna una {@link Playlist} por su nombre. 
     * @param nombre Nombre de la playlist buscada.
     * @return La {@link Playlist} encontrada, o {@code null} si no existe. 
     */
    public Playlist getPlaylist(String nombre){
        if (nombre==null){
            return null;
        }
        if (this.playlistMeGusta.getNombre().equalsIgnoreCase(nombre)){
            return this.playlistMeGusta;
        }
        for (Playlist p: playlistsGenerales){
            if (p.getNombre().equalsIgnoreCase(nombre)){
                return p;
            }
        }
        return null;
    }

    // --- Getters ---
    public Playlist getMeGusta(){
        return this.playlistMeGusta;
    }

    public List<Playlist> getPlaylists(){
        return this.playlistsGenerales;
    }
    
}
