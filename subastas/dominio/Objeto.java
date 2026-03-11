package subastas.dominio;

import java.time.LocalDate;
import java.time.Period;

/**
 * Representa un objeto de valor ofrecido en la plataforma de subastas.
 */
public class Objeto {

    /** Nombre del objeto */
    private String nombre;

    /** Descripción del objeto */
    private String descripcion;

    /** Estado del objeto: nuevo, usado, antiguo sin abrir */
    private String estado;

    /** Fecha de compra del objeto */
    private LocalDate fechaCompra;

    /**
     * Constructor por defecto.
     */
    public Objeto() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nombre      Nombre del objeto
     * @param descripcion Descripción del objeto
     * @param estado      Estado del objeto
     * @param fechaCompra Fecha de compra
     */
    public Objeto(String nombre, String descripcion, String estado, LocalDate fechaCompra) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaCompra = fechaCompra;
    }

    /**
     * Calcula la antigüedad del objeto desde su fecha de compra.
     *
     * @return String con el formato "X años, Y meses, Z días"
     */
    public String calcularAntiguedad() {
        Period periodo = Period.between(fechaCompra, LocalDate.now());
        return periodo.getYears() + " años, " + periodo.getMonths() + " meses, " + periodo.getDays() + " días";
    }

    // Getters y Setters

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDate getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDate fechaCompra) { this.fechaCompra = fechaCompra; }

    /**
     * Retorna una representación en texto del objeto.
     *
     * @return String con los datos del objeto
     */
    @Override
    public String toString() {
        return "Objeto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", fechaCompra=" + fechaCompra +
                ", antiguedad='" + calcularAntiguedad() + '\'' +
                '}';
    }
}
