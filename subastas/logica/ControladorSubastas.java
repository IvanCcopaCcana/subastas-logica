package subastas.logica;

import subastas.dominio.*;
import java.util.ArrayList;

/**
 * Controlador principal de la lógica de negocio de la plataforma de subastas.
 * Gestiona usuarios, subastas, ofertas y órdenes aplicando las reglas de negocio.
 */
public class ControladorSubastas {

    /** Lista de usuarios registrados en el sistema */
    private ArrayList<Usuario> usuarios;

    /** Lista de subastas activas y finalizadas */
    private ArrayList<Subasta> subastas;

    /** Lista de órdenes generadas */
    private ArrayList<Orden> ordenes;

    /** Moderador único del sistema */
    private Moderador moderador;

    /**
     * Constructor por defecto. Inicializa todas las listas.
     */
    public ControladorSubastas() {
        this.usuarios = new ArrayList<>();
        this.subastas = new ArrayList<>();
        this.ordenes = new ArrayList<>();
        this.moderador = null;
    }

    // =================== MODERADOR ===================

    /**
     * Verifica si existe un moderador registrado en el sistema.
     *
     * @return true si existe moderador, false si no
     */
    public boolean existeModerador() {
        return moderador != null;
    }

    /**
     * Registra el moderador del sistema. Solo puede registrarse uno.
     *
     * @param mod Moderador a registrar
     * @return true si fue registrado correctamente, false si ya existe uno o no es mayor de edad
     */
    public boolean registrarModerador(Moderador mod) {
        if (moderador != null) return false;
        if (!mod.esMayorDeEdad()) return false;
        this.moderador = mod;
        return true;
    }

    // =================== USUARIOS ===================

    /**
     * Registra un nuevo vendedor en el sistema.
     *
     * @param vendedor Vendedor a registrar
     * @return true si fue registrado, false si no es mayor de edad
     */
    public boolean registrarVendedor(Vendedor vendedor) {
        if (!vendedor.esMayorDeEdad()) return false;
        usuarios.add(vendedor);
        return true;
    }

    /**
     * Registra un nuevo coleccionista en el sistema.
     *
     * @param coleccionista Coleccionista a registrar
     * @return true si fue registrado, false si no es mayor de edad
     */
    public boolean registrarColeccionista(Coleccionista coleccionista) {
        if (!coleccionista.esMayorDeEdad()) return false;
        usuarios.add(coleccionista);
        return true;
    }

    /**
     * Retorna la lista de todos los usuarios registrados.
     *
     * @return Lista de usuarios
     */
    public ArrayList<Usuario> listarUsuarios() {
        return usuarios;
    }

    // =================== SUBASTAS ===================

    /**
     * Crea una nueva subasta aplicando las reglas de negocio.
     *
     * @param subasta  Subasta a crear
     * @param creador  Usuario que intenta crear la subasta
     * @return Mensaje indicando el resultado de la operación
     */
    public String crearSubasta(Subasta subasta, Usuario creador) {
        // El moderador no puede crear subastas
        if (creador instanceof Moderador) {
            return "Error: El moderador no puede crear subastas.";
        }
        // La subasta debe tener al menos un objeto
        if (subasta.getObjetos() == null || subasta.getObjetos().isEmpty()) {
            return "Error: La subasta debe tener al menos un objeto asociado.";
        }
        // Si el creador es coleccionista, los objetos deben ser de su colección
        if (creador instanceof Coleccionista) {
            Coleccionista col = (Coleccionista) creador;
            for (Objeto obj : subasta.getObjetos()) {
                if (!col.getColeccion().contains(obj)) {
                    return "Error: El coleccionista solo puede subastar objetos de su colección.";
                }
            }
        }
        subasta.setCreador(creador);
        subastas.add(subasta);
        return "Subasta creada exitosamente.";
    }

    /**
     * Retorna la lista de todas las subastas.
     *
     * @return Lista de subastas
     */
    public ArrayList<Subasta> listarSubastas() {
        return subastas;
    }

    // =================== OFERTAS ===================

    /**
     * Registra una oferta en una subasta aplicando las reglas de negocio.
     *
     * @param subasta        Subasta en la que se realiza la oferta
     * @param oferente       Usuario que realiza la oferta
     * @param precioOfertado Precio ofertado
     * @return Mensaje indicando el resultado de la operación
     */
    public String realizarOferta(Subasta subasta, Usuario oferente, double precioOfertado) {
        // El moderador no puede ofertar
        if (oferente instanceof Moderador) {
            return "Error: El moderador no puede realizar ofertas.";
        }
        // El vendedor no puede ofertar
        if (oferente instanceof Vendedor) {
            return "Error: El vendedor no puede realizar ofertas.";
        }
        // Si el creador de la subasta es el mismo coleccionista, no puede ofertar
        if (oferente.equals(subasta.getCreador())) {
            return "Error: El creador de la subasta no puede realizar ofertas en ella.";
        }
        // El precio debe superar el mínimo
        if (precioOfertado < subasta.getPrecioMinimo()) {
            return "Error: El precio ofertado no supera el precio mínimo de la subasta.";
        }

        Coleccionista col = (Coleccionista) oferente;
        Oferta oferta = new Oferta(col.getNombreCompleto(), col.getPuntuacion(), precioOfertado);
        subasta.agregarOferta(oferta);
        return "Oferta registrada exitosamente.";
    }

    /**
     * Retorna todas las ofertas de una subasta específica.
     *
     * @param subasta Subasta de la que se quieren las ofertas
     * @return Lista de ofertas
     */
    public ArrayList<Oferta> listarOfertas(Subasta subasta) {
        return subasta.getOfertas();
    }

    // =================== ÓRDENES ===================

    /**
     * Genera una orden de adjudicación para la subasta dada.
     *
     * @param subasta Subasta a adjudicar
     * @return La orden generada, o null si no hay ofertas válidas
     */
    public Orden generarOrden(Subasta subasta) {
        Oferta mejorOferta = subasta.getMejorOferta();
        if (mejorOferta == null) return null;

        Orden orden = new Orden(
                mejorOferta.getNombreOferente(),
                java.time.LocalDate.now(),
                subasta.getObjetos(),
                mejorOferta.getPrecioOfertado()
        );
        subasta.setEstado("adjudicada");
        ordenes.add(orden);
        return orden;
    }

    /**
     * Retorna la lista de órdenes generadas.
     *
     * @return Lista de órdenes
     */
    public ArrayList<Orden> listarOrdenes() {
        return ordenes;
    }

    public Moderador getModerador() { return moderador; }
}
