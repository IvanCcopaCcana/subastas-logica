package subastas.dominio;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.ArrayList;

/**
 * Representa una subasta activa o finalizada en la plataforma.
 * Contiene los objetos a subastar, las ofertas recibidas y su estado actual.
 */
public class Subasta {

    /** Fecha y hora de vencimiento de la subasta */
    private LocalDateTime fechaVencimiento;

    /** Usuario creador de la subasta */
    private Usuario creador;

    /** Precio mínimo de aceptación */
    private double precioMinimo;

    /** Conjunto de objetos subastados */
    private ArrayList<Objeto> objetos;

    /** Lista de ofertas realizadas en esta subasta */
    private ArrayList<Oferta> ofertas;

    /** Estado de la subasta: activa, finalizada, adjudicada */
    private String estado;

    /**
     * Constructor por defecto. Inicializa las listas y estado.
     */
    public Subasta() {
        this.objetos = new ArrayList<>();
        this.ofertas = new ArrayList<>();
        this.estado = "activa";
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param fechaVencimiento Fecha y hora en que vence la subasta
     * @param creador          Usuario que crea la subasta
     * @param precioMinimo     Precio mínimo de aceptación
     * @param objetos          Lista de objetos a subastar
     * @param estado           Estado inicial de la subasta
     */
    public Subasta(LocalDateTime fechaVencimiento, Usuario creador, double precioMinimo,
                   ArrayList<Objeto> objetos, String estado) {
        this.fechaVencimiento = fechaVencimiento;
        this.creador = creador;
        this.precioMinimo = precioMinimo;
        this.objetos = objetos != null ? objetos : new ArrayList<>();
        this.ofertas = new ArrayList<>();
        this.estado = estado != null ? estado : "activa";
    }

    /**
     * Calcula el tiempo restante hasta que venza la subasta.
     *
     * @return String con formato "X días, Y horas, Z minutos, W segundos" o "Subasta vencida"
     */
    public String calcularTiempoRestante() {
        LocalDateTime ahora = LocalDateTime.now();
        if (ahora.isAfter(fechaVencimiento)) {
            return "Subasta vencida";
        }
        Duration duracion = Duration.between(ahora, fechaVencimiento);
        long dias = duracion.toDays();
        long horas = duracion.toHours() % 24;
        long minutos = duracion.toMinutes() % 60;
        long segundos = duracion.getSeconds() % 60;
        return dias + " días, " + horas + " horas, " + minutos + " minutos, " + segundos + " segundos";
    }

    /**
     * Retorna la puntuación del creador de la subasta.
     *
     * @return Puntuación si el creador es Vendedor o Coleccionista, 0.0 en caso contrario
     */
    public double getPuntuacionCreador() {
        if (creador instanceof Vendedor) {
            return ((Vendedor) creador).getPuntuacion();
        } else if (creador instanceof Coleccionista) {
            return ((Coleccionista) creador).getPuntuacion();
        }
        return 0.0;
    }

    /**
     * Agrega una oferta a la subasta.
     *
     * @param oferta Oferta a agregar
     */
    public void agregarOferta(Oferta oferta) {
        ofertas.add(oferta);
    }

    /**
     * Agrega un objeto a la subasta.
     *
     * @param objeto Objeto a agregar
     */
    public void agregarObjeto(Objeto objeto) {
        objetos.add(objeto);
    }

    /**
     * Obtiene la oferta más alta registrada en la subasta.
     *
     * @return La oferta con el mayor precio, o null si no hay ofertas
     */
    public Oferta getMejorOferta() {
        return ofertas.stream()
                .max((o1, o2) -> Double.compare(o1.getPrecioOfertado(), o2.getPrecioOfertado()))
                .orElse(null);
    }

    // Getters y Setters

    public LocalDateTime getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDateTime fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public Usuario getCreador() { return creador; }
    public void setCreador(Usuario creador) { this.creador = creador; }

    public double getPrecioMinimo() { return precioMinimo; }
    public void setPrecioMinimo(double precioMinimo) { this.precioMinimo = precioMinimo; }

    public ArrayList<Objeto> getObjetos() { return objetos; }
    public void setObjetos(ArrayList<Objeto> objetos) { this.objetos = objetos; }

    public ArrayList<Oferta> getOfertas() { return ofertas; }
    public void setOfertas(ArrayList<Oferta> ofertas) { this.ofertas = ofertas; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    /**
     * Retorna una representación en texto de la subasta.
     *
     * @return String con los datos de la subasta
     */
    @Override
    public String toString() {
        return "Subasta{" +
                "fechaVencimiento=" + fechaVencimiento +
                ", creador='" + (creador != null ? creador.getNombreCompleto() : "N/A") + '\'' +
                ", puntuacionCreador=" + getPuntuacionCreador() +
                ", precioMinimo=" + precioMinimo +
                ", estado='" + estado + '\'' +
                ", tiempoRestante='" + calcularTiempoRestante() + '\'' +
                ", totalObjetos=" + objetos.size() +
                ", totalOfertas=" + ofertas.size() +
                '}';
    }
}
