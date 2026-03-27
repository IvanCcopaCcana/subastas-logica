package ccopaccana.ivan.dominio;

import java.time.LocalDate;

/**
 * Representa a un vendedor dentro de la plataforma.
 * Puede crear subastas pero no puede realizar ofertas.
 */
public class Vendedor extends Usuario {

    /** Puntuación o reputación del vendedor */
    private double puntuacion;

    /** Dirección del vendedor */
    private String direccion;

    /**
     * Constructor por defecto.
     */
    public Vendedor() {
        super();
        this.puntuacion = 0.0;
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nombreCompleto    Nombre completo
     * @param identificacion    Identificación
     * @param fechaNacimiento   Fecha de nacimiento
     * @param contrasena        Contraseña
     * @param correoElectronico Correo electrónico
     * @param puntuacion        Puntuación inicial
     * @param direccion         Dirección
     */
    public Vendedor(String nombreCompleto, String identificacion, LocalDate fechaNacimiento,
                    String contrasena, String correoElectronico, double puntuacion, String direccion) {
        super(nombreCompleto, identificacion, fechaNacimiento, contrasena, correoElectronico);
        this.puntuacion = puntuacion;
        this.direccion = direccion;
    }

    // Getters y Setters

    /**
     * Retorna la puntuación del vendedor.
     * @return Puntuación
     */
    public double getPuntuacion() { return puntuacion; }

    /**
     * Establece la puntuación del vendedor.
     * @param puntuacion Puntuación a asignar
     */
    public void setPuntuacion(double puntuacion) { this.puntuacion = puntuacion; }

    /**
     * Retorna la dirección del vendedor.
     * @return Dirección
     */
    public String getDireccion() { return direccion; }

    /**
     * Establece la dirección del vendedor.
     * @param direccion Dirección a asignar
     */
    public void setDireccion(String direccion) { this.direccion = direccion; }

    /**
     * Retorna una representación en texto del vendedor.
     *
     * @return String con los datos del vendedor
     */
    @Override
    public String toString() {
        return "Vendedor{" +
                "nombreCompleto='" + getNombreCompleto() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", edad=" + calcularEdad() +
                ", puntuacion=" + puntuacion +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
