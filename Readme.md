# SoundStream UNLP — Plataforma de Streaming de Audio 

> **Taller de Lenguajes II (2026) — Facultad de Informática (UNLP)** 
> **Trabajo Final Integrador (TFI) — Entrega 1** --- 

## Descripción 
Este proyecto consiste en la arquitectura y desarrollo en Java del backend para una plataforma de streaming de audio basada en los principios de la Programación Orientada a Objetos. 
El sistema permite: 
- Administrar un catálogo heterogéneo de audios (**canciones**, **episodios de podcast** y **audiolibros**) clasificados por categorías.
- Organizar obras mediante contenedores estructurados como **Álbumes** de canciones y **Podcasts**. 
- Gestionar perfiles de **Usuarios Consumidores** y **Usuarios Creadores** (artistas, autores y podcasters). 
- Controlar los niveles de servicio según el nivel de suscripción (**Plan Gratuito** con anuncios vs. **Plan Pago** libre de publicidad y con descargas). 
- Crear y personalizar **Playlists** e integrar favoritos en la biblioteca personal de los oyentes. 

--- 

## Diseño - Diagrama UML
El diseño conceptual del sistema está modelado bajo la especificación UML. 
La documentación gráfica está disponible dentro del repositorio: 
- **Ubicación en el repositorio:** `documentacion/UML.pdf`. 
- **Contenido:** Clases abstractas (`Contenido`, `Plan`), subclases concretas, estereotipos (<<enumeration>>), visibilidad de miembros (`+`, `-`), relaciones de herencia (`<|--`), agregaciones (`◇`), composiciones (`◆`).

---

## Instalación y Requisitos 
### Requisitos previos 
- **Java Development Kit (JDK):** Versión 17 o superior. 
- **Sistema Operativo:** Plataforma neutral (Windows, Linux, macOS). 
- **Entorno de Desarrollo (IDE):** Eclipse IDE o Visual Studio Code (con Extension Pack for Java)

### Pasos para clonar e instalar 
1. Clonar el repositorio oficial desde el servidor de la facultad [7, 8]: \`\`\`bash git clone [suspicious link removed] cd grupo-X