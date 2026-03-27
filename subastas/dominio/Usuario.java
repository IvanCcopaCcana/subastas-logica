package ccopaccana.ivan.dominio;

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

    /**
     * Retorna el nombre completo del usuario.
     * @return Nombre completo
     */
    public String getNombreCompleto() { return nombreCompleto; }

    /**
     * Establece el nombre completo del usuario.
     * @param nombreCompleto Nombre completo a asignar
     */
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    /**
     * Retorna la identificación única del usuario.
     * @return Identificación
     */
    public String getIdentificacion() { return identificacion; }

    /**
     * Establece la identificación única del usuario.
     * @param identificacion Identificación a asignar
     */
    public void setIdentificacion(String identificacion) { this.identificacion = identificacion; }

    /**
     * Retorna la fecha de nacimiento del usuario.
     * @return Fecha de nacimiento
     */
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }

    /**
     * Establece la fecha de nacimiento del usuario.
     * @param fechaNacimiento Fecha de nacimiento a asignar
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    /**
     * Retorna la contraseña del usuario.
     * @return Contraseña
     */
    public String getContrasena() { return contrasena; }

    /**
     * Establece la contraseña del usuario.
     * @param contrasena Contraseña a asignar
     */
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    /**
     * Retorna el correo electrónico del usuario.
     * @return Correo electrónico
     */
    public String getCorreoElectronico() { return correoElectronico; }

    /**
     * Establece el correo electrónico del usuario.
     * @param correoElectronico Correo electrónico a asignar
     */
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }

    /**
     * Compara este usuario con otro objeto por igualdad.
     * Dos usuarios son iguales si tienen la misma identificación.
     *
     * @param obj Objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario other = (Usuario) obj;
        return identificacion != null && identificacion.equals(other.identificacion);
    }

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
