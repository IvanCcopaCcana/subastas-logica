package subastas.dominio;

import java.time.LocalDate;
import java.time.Period;

/**
 * Clase base que representa un usuario del sistema de subastas.
 * Contiene los atributos y comportamientos comunes a todos los tipos de usuario.
 */
public abstract class Usuario {

    /** Nombre completo del usuario */
    private String nombreCompleto;

    /** Identificación única del usuario */
    private String identificacion;

    /** Fecha de nacimiento del usuario */
    private LocalDate fechaNacimiento;

    /** Contraseña del usuario */
    private String contrasena;

    /** Correo electrónico del usuario */
    private String correoElectronico;

    /**
     * Constructor por defecto.
     */
    public Usuario() {
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nombreCompleto   Nombre completo del usuario
     * @param identificacion   Identificación del usuario
     * @param fechaNacimiento  Fecha de nacimiento
     * @param contrasena       Contraseña
     * @param correoElectronico Correo electrónico
     */
    public Usuario(String nombreCompleto, String identificacion, LocalDate fechaNacimiento,
                   String contrasena, String correoElectronico) {
        this.nombreCompleto = nombreCompleto;
        this.identificacion = identificacion;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Calcula la edad del usuario en años a partir de su fecha de nacimiento.
     *
     * @return Edad en años
     */
    public int calcularEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }

    /**
     * Verifica si el usuario es mayor de edad (18 años o más).
     *
     * @return true si es mayor de edad, false en caso contrario
     */
    public boolean esMayorDeEdad() {
        return calcularEdad() >= 18;
    }

    // Getters y Setters

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getIdentificacion() { return identificacion; }
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    /**
     * Retorna una representación en texto del usuario.
     *
     * @return String con los datos del usuario
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", identificacion='" + identificacion + '\'' +
                ", edad=" + calcularEdad() +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}
