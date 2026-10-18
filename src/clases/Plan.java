package src.clases;

public abstract class Plan {
    private String nombreTipo;
    private double precioMensual;

    public abstract boolean puedeDescargar();
    public abstract boolean tienePublicidad();
}
