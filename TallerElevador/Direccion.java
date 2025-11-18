public enum Direccion {
    SUBIR, BAJAR, DETENIDO;
    
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}