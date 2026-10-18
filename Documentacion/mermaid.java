---
config:
    theme: redux-dark-color
---
classDiagram
    class PlataformaStreaming {
        -String nombre
        -String fechaLanzamiento
        +agregarUsuario(UsuarioConsumidor u) void
    }
    class Catalogo{
        +obtenerContenidoMasReproducido() Contenido
        +buscarPorArtista(String creador) List~Contenido~
        +filtrarPorGenero(String genero) List~Contenido~
        +buscarContenido(String criterio) List~Contenido~
        +publicarContenido(Contenido c) void
    }
    class UsuarioConsumidor { 
        -String id
        -String nombreUsuario
        -String email
        -String fechaInicioCuenta
        +getId() String
        +getNombre() String
        +crearPlaylist(String nombre) Playlist
        +marcarMeGusta(Contenido c) void
        +reproducirContenido(Contenido c) void
        +registrarEscucha(Contenido c) void
        +getHistorial() List~Reproduccion~
        +getPlaylist(String nombre) Playlist
        +getMeGusta() Playlist
        +agregarPlaylist(Playlist p) void
        +eliminarPlaylist(Playlist p) void
    }
    class Creador {
        +publicarContenido(Contenido c) void
        +obtenerEstadisticas() String
        +obtenerFrecuenciaPublicacion() double
        +getCantidadMeGustaTotales() int
        +getGeneroPredomina() String
        +getRecaudacionTotal() double
    }
    class Reproductor{
        +adelantar(int segundos);
        +pausar(Contenido c): void
    }
    class Contenido <<abstract>> { 
        -String id
        -String titulo
        -int duracionEnSegundos
        -int cantReproducciones
        -int cantMeGusta
        -double recaudadoTotal 
        -int reproduccionesMujeres 
        -int reproduccionesHombres 
        +reproducir() void
        +incrementarReproducciones() void
        +incrementarMeGusta() void
        +getReproducciones() int
        +getRecaudadoTotal() double
        +getGeneroPredominaOyentes() String
    }
    class Generos{ <<enumeration>>
    ROCK, POP, TRAP, CLASICO
    }
    class Cancion {
    }
    class Album { 
        -String nombre
        -String fechaLanzamiento
        +agregarCancion(Cancion c) void 
    }
    class Audiolibro {      
    }
    class Podcast{
        -String nombrePodcast
        -String fechaLanzamiento
    }
    class EpisodioPodcast {
        -int numeroEpisodio
        -String nombreEpisodio
    }
    class Playlist {
        -String id
        -String nombre
        +agregarContenido(Contenido c) void
        +eliminarContenido(Contenido c) void
    }
    class Reproduccion {
        -LocalDateTime fechaHora

        +getFechaHora() LocalDateTime
    }
    class Plan { <<abstract>>
        -String nombre
        -double precioMensual
        +puedeDescargar() boolean *
        +tienePublicidad() boolean *
    }
    class PlanGratuito{
        +puedeDescargar() boolean
        +tienePublicidad() boolean 
    }
    class PlanPago {
        -String tipo 
        -LocalDateTime fechaInicio 
        -LocalDateTime fechaVencimiento
        +puedeDescargar() boolean 
        +tienePublicidad() boolean 
    }
    PlataformaStreaming "1" o-- "*" UsuarioConsumidor
    PlataformaStreaming "1" o-- "1" Catalogo
    Catalogo "1" o-- "*" Contenido
    UsuarioConsumidor <|-- Creador
    UsuarioConsumidor "1" --> "1" Plan 
    UsuarioConsumidor "1" *-- "*" Reproduccion 
    UsuarioConsumidor "1" *-- "*" Playlist
    UsuarioConsumidor "1" *-- "1" Playlist : meGusta
    Plan <|-- PlanGratuito 
    Plan <|-- PlanPago 
    Reproduccion "1" --> "1" UsuarioConsumidor
    Creador "1" o-- "*" Contenido : Posted List
    Album "1" o-- "*" Cancion 
    Playlist "*" o-- "*" Contenido 
    Podcast "1" o-- "*" EpisodioPodcast
    Contenido "*" --> "1" Creador 
    Contenido <|-- Cancion 
    Contenido <|-- EpisodioPodcast
    Contenido <|-- Audiolibro
