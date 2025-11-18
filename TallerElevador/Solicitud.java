import java.util.Date;

/**
 * Representa una petición de servicio hecha por un usuario 
 * (presionar un botón en un piso).
 * Esta clase es inmutable una vez creada.
 */
public class Solicitud {
    private int pisoOrigen;
    private Direccion direccion;
    private long timestamp;
    
    /**
     * Constructor para crear una nueva solicitud.
     * @param pisoOrigen El número de piso donde se originó la solicitud.
     * @param direccion La dirección deseada (SUBIR o BAJAR).
     */
    public Solicitud(int pisoOrigen, Direccion direccion) {
        this.pisoOrigen = pisoOrigen;
        this.direccion = direccion;
        this.timestamp = System.currentTimeMillis();
    }
    
    /**
     * Obtiene el piso donde se hizo la llamada.
     * @return El número de piso de origen.
     */
    public int getPisoOrigen() { return pisoOrigen; }
    
    /**
     * Obtiene la dirección deseada (SUBIR o BAJAR).
     * @return La dirección.
     */
    public Direccion getDireccion() { return direccion; }
    
    /**
     * Obtiene la marca de tiempo (timestamp) de la creación de la solicitud.
     * Útil para la lógica FIFO (First-In, First-Out).
     * @return El timestamp en milisegundos.
     */
    public long getTimestamp() { return timestamp; }
}