package ccopaccana.ivan.dominio;

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

    /**
     * Retorna el nombre del oferente.
     * @return Nombre del oferente
     */
    public String getNombreOferente() { return nombreOferente; }

    /**
     * Establece el nombre del oferente.
     * @param nombreOferente Nombre a asignar
     */
    public void setNombreOferente(String nombreOferente) { this.nombreOferente = nombreOferente; }

    /**
     * Retorna la puntuación del oferente.
     * @return Puntuación del oferente
     */
    public double getPuntuacionOferente() { return puntuacionOferente; }

    /**
     * Establece la puntuación del oferente.
     * @param puntuacionOferente Puntuación a asignar
     */
    public void setPuntuacionOferente(double puntuacionOferente) { this.puntuacionOferente = puntuacionOferente; }

    /**
     * Retorna el precio ofertado.
     * @return Precio ofertado
     */
    public double getPrecioOfertado() { return precioOfertado; }

    /**
     * Establece el precio ofertado.
     * @param precioOfertado Precio a asignar
     */
    public void setPrecioOfertado(double precioOfertado) { this.precioOfertado = precioOfertado; }

    /**
     * Compara esta oferta con otra por igualdad.
     * Dos ofertas son iguales si tienen el mismo oferente y precio ofertado.
     *
     * @param obj Objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Oferta other = (Oferta) obj;
        return Double.compare(precioOfertado, other.precioOfertado) == 0 &&
               nombreOferente != null && nombreOferente.equals(other.nombreOferente);
    }

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
