/**
 * Representa un botón de llamada en el pasillo (fuera de la cabina).
 * Hereda la funcionalidad básica de la clase Boton.
 */
public class BotonDePiso extends Boton {
    private Direccion direccion;
    
    /**
     * Constructor para un BotonDePiso.
     * @param direccion La dirección que se solicita (SUBIR o BAJAR).
     */
    public BotonDePiso(Direccion direccion) {
        super();
        this.direccion = direccion;
    }

    /**
     * Simula la pulsación, además de la lógica base, muestra la dirección solicitada.
     */
    @Override
    public void presionar() {
        super.presionar();
        System.out.println("   Dirección solicitada: " + direccion);
    }

    /**
     * Obtiene la dirección solicitada por este botón.
     * @return La dirección (SUBIR o BAJAR).
     */
    public Direccion getDireccion() { return direccion; }
}