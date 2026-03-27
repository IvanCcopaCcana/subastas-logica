package ccopaccana.ivan.dominio;

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

    /**
     * Retorna el nombre del objeto.
     * @return Nombre
     */
    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del objeto.
     * @param nombre Nombre a asignar
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /**
     * Retorna la descripción del objeto.
     * @return Descripción
     */
    public String getDescripcion() { return descripcion; }

    /**
     * Establece la descripción del objeto.
     * @param descripcion Descripción a asignar
     */
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    /**
     * Retorna el estado del objeto.
     * @return Estado (nuevo, usado, antiguo sin abrir)
     */
    public String getEstado() { return estado; }

    /**
     * Establece el estado del objeto.
     * @param estado Estado a asignar
     */
    public void setEstado(String estado) { this.estado = estado; }

    /**
     * Retorna la fecha de compra del objeto.
     * @return Fecha de compra
     */
    public LocalDate getFechaCompra() { return fechaCompra; }

    /**
     * Establece la fecha de compra del objeto.
     * @param fechaCompra Fecha de compra a asignar
     */
    public void setFechaCompra(LocalDate fechaCompra) { this.fechaCompra = fechaCompra; }

    /**
     * Compara este objeto con otro por igualdad.
     * Dos objetos son iguales si tienen el mismo nombre y fecha de compra.
     *
     * @param obj Objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Objeto other = (Objeto) obj;
        return nombre != null && nombre.equals(other.nombre) &&
               fechaCompra != null && fechaCompra.equals(other.fechaCompra);
    }

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
