package ccopaccana.ivan.dominio;

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

    /**
     * Retorna el nombre del ganador de la orden.
     * @return Nombre del ganador
     */
    public String getNombreGanador() { return nombreGanador; }

    /**
     * Establece el nombre del ganador de la orden.
     * @param nombreGanador Nombre a asignar
     */
    public void setNombreGanador(String nombreGanador) { this.nombreGanador = nombreGanador; }

    /**
     * Retorna la fecha en que se generó la orden.
     * @return Fecha de la orden
     */
    public LocalDate getFechaOrden() { return fechaOrden; }

    /**
     * Establece la fecha de la orden.
     * @param fechaOrden Fecha a asignar
     */
    public void setFechaOrden(LocalDate fechaOrden) { this.fechaOrden = fechaOrden; }

    /**
     * Retorna la lista de objetos adjudicados en la orden.
     * @return Lista de objetos adjudicados
     */
    public ArrayList<Objeto> getObjetosAdjudicados() { return objetosAdjudicados; }

    /**
     * Establece la lista de objetos adjudicados en la orden.
     * @param objetosAdjudicados Lista de objetos a asignar
     */
    public void setObjetosAdjudicados(ArrayList<Objeto> objetosAdjudicados) { this.objetosAdjudicados = objetosAdjudicados; }

    /**
     * Retorna el precio total de la orden.
     * @return Precio total
     */
    public double getPrecioTotal() { return precioTotal; }

    /**
     * Establece el precio total de la orden.
     * @param precioTotal Precio total a asignar
     */
    public void setPrecioTotal(double precioTotal) { this.precioTotal = precioTotal; }

    /**
     * Compara esta orden con otra por igualdad.
     * Dos órdenes son iguales si tienen el mismo ganador y fecha.
     *
     * @param obj Objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Orden other = (Orden) obj;
        return nombreGanador != null && nombreGanador.equals(other.nombreGanador) &&
               fechaOrden != null && fechaOrden.equals(other.fechaOrden);
    }

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
