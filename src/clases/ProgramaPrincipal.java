package clases;

/**
 * Clase principal para la ejecución de pruebas de la Plataforma de Streaming de Audio (TFI - Entrega 1).
 * Implementada de acuerdo a las especificaciones para grupos de 2 integrantes.
 */
public class ProgramaPrincipal {

    public static void main(String[] args) {
        System.out.println("\n ");
        System.out.println("   TALLER DE LENGUAJES II - TRABAJO FINAL INTEGRADOR (ENTREGA 1)");
        System.out.println("   PLATAFORMA DE STREAMING DE AUDIO");
        System.out.println("--------------------------------------------------------------------");

        // Instanciación de la plataforma
        PlataformaStreaming plataforma = new PlataformaStreaming("SoundStream UNLP");

        // Creación de planes de suscripción
        Plan planGratis = new PlanGratuito();
        Plan planPremium = new PlanPago("Premium Individual", 1500.0);
        Plan planFamiliar = new PlanPago("Premium Familiar", 2800.0);

        // FUNCION 1: Agregar usuarios a la plataforma
        System.out.println("1. Registrando usuarios consumidores y creadores...");
        
        UsuarioConsumidor u1 = new UsuarioConsumidor("Juliana_Moroni", "juli@gmail.com");
        u1.setPlan(planPremium);

        UsuarioConsumidor u2 = new UsuarioConsumidor("Olivia_Iriarte", "mateo@gmail.com");
        u2.setPlan(planGratis);
        
        UsuarioCreador creador1 = new UsuarioCreador("SodaStereo_Official", "contacto@sodastereo.com");
        creador1.setPlan(planFamiliar);

        UsuarioCreador creador2 = new UsuarioCreador("Luzu_Podcast", "podcast@luzu.io");
        creador2.setPlan(planPremium);

        UsuarioCreador creador3 = new UsuarioCreador("Editorial_AudioLibros", "info@audiolibros.org");
        creador3.setPlan(planGratis);

        plataforma.agregarUsuario(u1);
        plataforma.agregarUsuario(u2);
        plataforma.agregarUsuario(creador1);
        plataforma.agregarUsuario(creador2);
        plataforma.agregarUsuario(creador3);
        System.out.println("   Usuarios registrados exitosamente.");

        // FUNCION 2: Publicar contenidos de diferentes géneros al catálogo
        System.out.println("\n2. Publicando contenidos de diferentes géneros al catálogo...");

        Contenido c1 = new Cancion("De Música Ligera", 212, Genero.ROCK, creador1,
                "Ella durmió al calor de las masas...", null, false);
        
        Contenido c2 = new Cancion("Persiana Americana", 292, Genero.ROCK, creador1,
                "Yo te vi cruzar entre la niebla...", null, false);
        
        Contenido c3 = new Cancion("Tratame Suavemente", 201, Genero.CLASICOS, creador1,
                "Alguien me dijo que la soledad...", null, true);

        Contenido c4 = new EpisodioPodcast("IA y el futuro de Java 2026", 1850, Genero.CIENCIA, creador2,
                "Analizamos las nuevas características de Java y el impacto de la IA.", "Prof. Claudia Queiruga", 1);

        Contenido c5 = new EpisodioPodcast("Patrones de Diseño en la Práctica", 2100, Genero.ENTRETENIMIENTO, creador2,
                "Revisamos Singleton, Factory y Observer con ejemplos prácticos.", "Prof. Isabel Kimura", 2);

        Contenido c6 = new Audiolibro("Don Quijote de la Mancha (Cap. 1)", 3600, Genero.HISTORIA, creador3,
                "Jorge Luis Borges", "Obra cumbre de la literatura hispana.", 1);

        creador1.publicarContenido(c1, plataforma);
        creador1.publicarContenido(c2, plataforma);
        creador1.publicarContenido(c3, plataforma);
        creador2.publicarContenido(c4, plataforma);
        creador2.publicarContenido(c5, plataforma);
        creador3.publicarContenido(c6, plataforma);
        System.out.println("   Contenidos publicados en el catálogo general.");

        // Simulación de reproducciones
        u1.reproducirContenido(c1);
        u1.reproducirContenido(c4);
        u2.reproducirContenido(c2);

        // FUNCION 3: Agregar contenidos a playlists de los usuarios consumidores
        System.out.println("\n3. Creando playlists y agregando contenidos para usuarios consumidores...");

        Playlist plJuliana = u1.crearPlaylist("Rock Nacional");
        u1.agregarAPlaylist(plJuliana, c1);
        u1.agregarAPlaylist(plJuliana, c2);
        u1.agregarAPlaylist(plJuliana, c3);

        Playlist plJuliana2 = u1.crearPlaylist("Estudio & Programación");
        u1.agregarAPlaylist(plJuliana2, c4);
        u1.agregarAPlaylist(plJuliana2, c5);

        Playlist plOlivia = u2.crearPlaylist("Favoritos de Oli");
        u2.agregarAPlaylist(plOlivia, c2);
        u2.agregarAPlaylist(plOlivia, c6);

        u1.marcarMeGusta(c1);
        u2.marcarMeGusta(c6);

        System.out.println("   Playlists creadas e integradas a las bibliotecas");

        // FUNCION 4: Salida de datos por consola
        System.out.println("\n ");
        System.out.println("                  SALIDA DE DATOS POR CONSOLA                    ");
        System.out.println("--------------------------------------------------------------------");

        // Mostrar catálogo
        plataforma.mostrarCatalogo();

        // Mostrar datos de los usuarios
        System.out.println("\n-----------------------------------------------------------------");
        plataforma.mostrarUsuarios();

        System.out.println("\n=================================================================");
    }
}
