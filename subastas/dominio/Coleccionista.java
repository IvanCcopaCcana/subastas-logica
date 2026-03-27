package ccopaccana.ivan.dominio;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa a un coleccionista en la plataforma.
 * Puede crear subastas con sus propios objetos y realizar ofertas en otras subastas.
 */
public class Coleccionista extends Usuario {

    /** Puntuación o reputación del coleccionista */
    private double puntuacion;

    /** Dirección del coleccionista */
    private String direccion;

    /** Lista de intereses del coleccionista */
    private ArrayList<String> intereses;

    /** Lista de objetos que posee el coleccionista */
    private ArrayList<Objeto> coleccion;

    /**
     * Constructor por defecto.
     */
    public Coleccionista() {
        super();
        this.puntuacion = 0.0;
        this.intereses = new ArrayList<>();
        this.coleccion = new ArrayList<>();
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
     * @param intereses         Lista de intereses
     * @param coleccion         Lista de objetos en su colección
     */
    public Coleccionista(String nombreCompleto, String identificacion, LocalDate fechaNacimiento,
                         String contrasena, String correoElectronico, double puntuacion, String direccion,
                         ArrayList<String> intereses, ArrayList<Objeto> coleccion) {
        super(nombreCompleto, identificacion, fechaNacimiento, contrasena, correoElectronico);
        this.puntuacion = puntuacion;
        this.direccion = direccion;
        this.intereses = intereses != null ? intereses : new ArrayList<>();
        this.coleccion = coleccion != null ? coleccion : new ArrayList<>();
    }

    /**
     * Agrega un objeto a la colección del coleccionista.
     *
     * @param objeto Objeto a agregar
     */
    public void agregarObjeto(Objeto objeto) {
        coleccion.add(objeto);
    }

    /**
     * Agrega un interés a la lista del coleccionista.
     *
     * @param interes Interés a agregar
     */
    public void agregarInteres(String interes) {
        intereses.add(interes);
    }

    // Getters y Setters

    /**
     * Retorna la puntuación del coleccionista.
     * @return Puntuación
     */
    public double getPuntuacion() { return puntuacion; }

    /**
     * Establece la puntuación del coleccionista.
     * @param puntuacion Puntuación a asignar
     */
    public void setPuntuacion(double puntuacion) { this.puntuacion = puntuacion; }

    /**
     * Retorna la dirección del coleccionista.
     * @return Dirección
     */
    public String getDireccion() { return direccion; }

    /**
     * Establece la dirección del coleccionista.
     * @param direccion Dirección a asignar
     */
    public void setDireccion(String direccion) { this.direccion = direccion; }

    /**
     * Retorna la lista de intereses del coleccionista.
     * @return Lista de intereses
     */
    public ArrayList<String> getIntereses() { return intereses; }

    /**
     * Establece la lista de intereses del coleccionista.
     * @param intereses Lista de intereses a asignar
     */
    public void setIntereses(ArrayList<String> intereses) { this.intereses = intereses; }

    /**
     * Retorna la colección de objetos del coleccionista.
     * @return Lista de objetos
     */
    public ArrayList<Objeto> getColeccion() { return coleccion; }

    /**
     * Establece la colección de objetos del coleccionista.
     * @param coleccion Lista de objetos a asignar
     */
    public void setColeccion(ArrayList<Objeto> coleccion) { this.coleccion = coleccion; }

    /**
     * Retorna una representación en texto del coleccionista.
     *
     * @return String con los datos del coleccionista
     */
    @Override
    public String toString() {
        return "Coleccionista{" +
                "nombreCompleto='" + getNombreCompleto() + '\'' +
                ", identificacion='" + getIdentificacion() + '\'' +
                ", edad=" + calcularEdad() +
                ", puntuacion=" + puntuacion +
                ", direccion='" + direccion + '\'' +
                ", intereses=" + intereses +
                ", objetos en coleccion=" + coleccion.size() +
                '}';
    }
}
