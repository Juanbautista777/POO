public enum Direccion {
    /** Indica que el movimiento o la solicitud es hacia pisos superiores. */
    SUBIR, 
    /** Indica que el movimiento o la solicitud es hacia pisos inferiores. */
    BAJAR, 
    /** Indica que el Ascensor está parado y sin destino inmediato. */
    DETENIDO;
    
    /**
     * Devuelve el nombre de la dirección en minúsculas para una mejor presentación.
     * @return String en minúsculas.
     */
    @Override
    public String toString() {
        return name().toLowerCase();
}}