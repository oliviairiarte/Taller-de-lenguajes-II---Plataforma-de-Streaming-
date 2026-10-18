package clases;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Representa una lista de reproducción en la plataforma de streaming.
 * Agrupa distintos {@link Contenido} y pertenece obligatoriamente a un {@link UsuarioConsumidor}.
 */
public class Playlist {
    private String nombre;
    private String id;
    private UsuarioConsumidor creador;
    private List<Contenido> contenidos;

    /**
     * Instancia una nueva playlist vinculada de forma obligatoria a su {@link UsuarioConsumidor creador}.
     * @param nombre Nombre descriptivo de la lista de reproducción.
     * @param creador {@link UsuarioConsumidor} propietario de la lista. 
     */
    public Playlist(String nombre, UsuarioConsumidor creador){
        this.nombre= nombre;
        this.id= "plt-"+UUID.randomUUID().toString().substring(0, 8);

        this.contenidos= new ArrayList<>();
        this.creador= creador;
    }
    
    /**
     * Agrega un {@link Contenido} a la lista de reproducción. 
     * @param c {@link Contenido} a incorporar. 
     */
    public void agregarContenido(Contenido c){
        if (c!=null){
            this.contenidos.add(c);
        }
    }

    /**
     * Remueve un {@link Contenido} de la lista de reproducción. 
     * @param c {@link Contenido} a eliminar. 
     */
    public void eliminarContenido(Contenido c){
        if (c!=null){
            this.contenidos.remove(c);
        }
    }

    /**Calcula la duración total acumulada sumando la duración de cada {@link Contenido} guardado. 
     * @return Duración total expresada en segundos.
     */
    public int getDuracionTotal(){
        int tot=0;
        for (Contenido c: contenidos){
            if (c!=null){
                tot+=c.getDuracion();
            }
        }
        return tot;
    }

    // --- Getters ---
    public String getNombre(){
        return this.nombre;
    }
    
    public List<Contenido> getContenidos(){
        return this.contenidos;
    }
    public UsuarioConsumidor getCreador(){
        return this.creador;
    }
    public String getId(){
        return this.id;
    }

}
