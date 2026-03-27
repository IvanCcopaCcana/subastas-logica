package ccopaccana.ivan.dominio;

import java.time.LocalDate;

/**
 * Representa al moderador de la plataforma.
 * Solo puede existir un único moderador en el sistema.
 * No puede participar en subastas ni realizar ofertas.
 */
public class Moderador extends Usuario {

    /**
     * Constructor por defecto.
     */
    public Moderador() {
        super();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nombreCompleto    Nombre completo
     * @param identificacion    Identificación
     * @param fechaNacimiento   Fecha de nacimiento
     * @param contrasena        Contraseña
     * @param correoElectronico Correo electrónico
     */
    public Moderador(String nombreCompleto, String identificacion, LocalDate fechaNacimiento,
                     String contrasena, String correoElectronico) {
        super(nombreCompleto, identificacion, fechaNacimiento, contrasena, correoElectronico);
    }

    /**
     * Retorna una representación en texto del moderador.
     *
     * @return String con los datos del moderador
     */
    @Override
    public String toString() {
        return "Moderador{" +
                "nombreCompleto='" + getNombreCompleto() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", edad=" + calcularEdad() +
                ", correo='" + getCorreoElectronico() + '\'' +
                '}';
    }
}
