/**
 * Clase que representa un piso (planta) en el edificio.
 * Es responsable de gestionar los botones de llamada de subir y bajar.
 */
public class Piso {
    private int numero;
    private BotonDePiso botonSubir;
    private BotonDePiso botonBajar;

    /**
     * Constructor para un Piso. Los botones se crean condicionalmente.
     * @param numero El número del piso (empezando en 1).
     * @param primerPiso true si es el piso más bajo (no necesita botón de bajar).
     * @param ultimoPiso true si es el piso más alto (no necesita botón de subir).
     */
    public Piso(int numero, boolean primerPiso, boolean ultimoPiso) {
        this.numero = numero;
        // Solo se crea botón de bajar si no es el primer piso
        if (!primerPiso) {
            botonBajar = new BotonDePiso(Direccion.BAJAR);
        }
        // Solo se crea botón de subir si no es el último piso
        if (!ultimoPiso) {
            botonSubir = new BotonDePiso(Direccion.SUBIR);
        }
    }

    /**
     * Obtiene el número de este piso.
     * @return El número de piso.
     */
    public int getNumero() { return numero; }

    /**
     * Simula la pulsación del botón de subir, si existe.
     */
    public void presionarSubir() {
        if (botonSubir != null) {
            System.out.println("🔼 Piso " + numero + " solicita SUBIR");
            botonSubir.presionar();
        } else {
            System.out.println("❌ No hay botón de subir en el último piso");
        }
    }

    /**
     * Simula la pulsación del botón de bajar, si existe.
     */
    public void presionarBajar() {
        if (botonBajar != null) {
            System.out.println("🔽 Piso " + numero + " solicita BAJAR");
            botonBajar.presionar();
        } else {
            System.out.println("❌ No hay botón de bajar en el primer piso");
        }
    }

    /**
     * Verifica si el piso tiene un botón de subir disponible.
     * @return true si tiene el botón, false en caso contrario.
     */
    public boolean tieneBotonSubir() { return botonSubir != null; }
    
    /**
     * Verifica si el piso tiene un botón de bajar disponible.
     * @return true si tiene el botón, false en caso contrario.
     */
    public boolean tieneBotonBajar() { return botonBajar != null; }
}