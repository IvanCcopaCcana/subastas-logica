package subastas.dominio;

/**
 * Representa una oferta realizada por un coleccionista en una subasta.
 */
public class Oferta {

    /** Nombre del oferente */
    private String nombreOferente;

    /** Puntuación del oferente */
    private double puntuacionOferente;

    /** Precio ofertado */
    private double precioOfertado;

    /**
     * Constructor por defecto.
     */
    public Oferta() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nombreOferente     Nombre del oferente
     * @param puntuacionOferente Puntuación del oferente
     * @param precioOfertado     Precio ofertado
     */
    public Oferta(String nombreOferente, double puntuacionOferente, double precioOfertado) {
        this.nombreOferente = nombreOferente;
        this.puntuacionOferente = puntuacionOferente;
        this.precioOfertado = precioOfertado;
    }

    // Getters y Setters

    public String getNombreOferente() { return nombreOferente; }
    public void setNombreOferente(String nombreOferente) { this.nombreOferente = nombreOferente; }

    public double getPuntuacionOferente() { return puntuacionOferente; }
    public void setPuntuacionOferente(double puntuacionOferente) { this.puntuacionOferente = puntuacionOferente; }

    public double getPrecioOfertado() { return precioOfertado; }
    public void setPrecioOfertado(double precioOfertado) { this.precioOfertado = precioOfertado; }

    /**
     * Retorna una representación en texto de la oferta.
     *
     * @return String con los datos de la oferta
     */
    @Override
    public String toString() {
        return "Oferta{" +
                "nombreOferente='" + nombreOferente + '\'' +
                ", puntuacionOferente=" + puntuacionOferente +
                ", precioOfertado=" + precioOfertado +
                '}';
    }
}
