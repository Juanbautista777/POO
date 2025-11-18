public class Solicitud {
    private int pisoOrigen;
    private Direccion direccion;
    private long timestamp;
    
    public Solicitud(int pisoOrigen, Direccion direccion) {
        this.pisoOrigen = pisoOrigen;
        this.direccion = direccion;
        this.timestamp = System.currentTimeMillis();
    }
    
    public int getPisoOrigen() { return pisoOrigen; }
    public Direccion getDireccion() { return direccion; }
    public long getTimestamp() { return timestamp; }
}