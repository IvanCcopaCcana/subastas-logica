package subastas.dominio;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Representa una orden de adjudicación generada al finalizar una subasta.
 * Registra al ganador, los objetos adjudicados y el precio total.
 */
public class Orden {

    /** Nombre completo del ganador */
    private String nombreGanador;

    /** Fecha en que se generó la orden */
    private LocalDate fechaOrden;

    /** Lista de objetos adjudicados */
    private ArrayList<Objeto> objetosAdjudicados;

    /** Precio total de la orden */
    private double precioTotal;

    /**
     * Constructor por defecto.
     */
    public Orden() {
        this.objetosAdjudicados = new ArrayList<>();
        this.fechaOrden = LocalDate.now();
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param nombreGanador       Nombre completo del ganador
     * @param fechaOrden          Fecha de la orden
     * @param objetosAdjudicados  Lista de objetos adjudicados
     * @param precioTotal         Precio total de la orden
     */
    public Orden(String nombreGanador, LocalDate fechaOrden,
                 ArrayList<Objeto> objetosAdjudicados, double precioTotal) {
        this.nombreGanador = nombreGanador;
        this.fechaOrden = fechaOrden;
        this.objetosAdjudicados = objetosAdjudicados != null ? objetosAdjudicados : new ArrayList<>();
        this.precioTotal = precioTotal;
    }

    // Getters y Setters

    public String getNombreGanador() { return nombreGanador; }
    public void setNombreGanador(String nombreGanador) { this.nombreGanador = nombreGanador; }

    public LocalDate getFechaOrden() { return fechaOrden; }
    public void setFechaOrden(LocalDate fechaOrden) { this.fechaOrden = fechaOrden; }

    public ArrayList<Objeto> getObjetosAdjudicados() { return objetosAdjudicados; }
    public void setObjetosAdjudicados(ArrayList<Objeto> objetosAdjudicados) { this.objetosAdjudicados = objetosAdjudicados; }

    public double getPrecioTotal() { return precioTotal; }
    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }

    /**
     * Retorna una representación en texto de la orden.
     *
     * @return String con los datos de la orden
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Orden{");
        sb.append("ganador='").append(nombreGanador).append('\'');
        sb.append(", fechaOrden=").append(fechaOrden);
        sb.append(", precioTotal=").append(precioTotal);
        sb.append(", objetos=[");
        for (int i = 0; i < objetosAdjudicados.size(); i++) {
            sb.append(objetosAdjudicados.get(i).getNombre());
            if (i < objetosAdjudicados.size() - 1) sb.append(", ");
        }
        sb.append("]}");
        return sb.toString();
    }
}
