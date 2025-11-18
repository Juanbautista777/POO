/**
 * Clase que modela las puertas del ascensor y su comportamiento, 
 * incluyendo la lógica de seguridad.
 */
public class Puerta {
    private boolean abierta;
    private boolean hayObstaculo;
    private static final int TIEMPO_ESPERA = 3; // segundos

    /**
     * Constructor de la Puerta. Inicialmente, las puertas están cerradas.
     */
    public Puerta() {
        this.abierta = false;
        this.hayObstaculo = false;
    }

    /**
     * Intenta abrir las puertas. Falla si hay un obstáculo.
     */
    public void abrir() {
        if (!hayObstaculo) {
            abierta = true;
            System.out.println("🚪 Puertas ABIERTAS");
        } else {
            System.out.println("⚠️  No se pueden abrir: obstáculo detectado");
        }
    }

    /**
     * Intenta cerrar las puertas. Si hay un obstáculo, permanece abierta y reabre por seguridad.
     */
    public void cerrar() {
        if (!hayObstaculo) {
            abierta = false;
            System.out.println("🚪 Puertas CERRADAS");
        } else {
            System.out.println("⚠️  Obstáculo detectado, puertas permanecen abiertas");
            reabrirPorSeguridad();
        }
    }

    /**
     * Lógica interna para reabrir automáticamente la puerta al detectar un obstáculo.
     */
    private void reabrirPorSeguridad() {
        abierta = true;
        System.out.println("🔄 Reabriendo puertas por seguridad...");
    }

    /**
     * Mantiene las puertas abiertas (simula el botón de 'mantener abiertas').
     */
    public void mantenerAbierta() {
        abierta = true;
        System.out.println("🖐️  Botón 'mantener abiertas' activado");
    }

    /**
     * Verifica el estado de apertura de la puerta.
     * @return true si está abierta, false si está cerrada.
     */
    public boolean isAbierta() { return abierta; }
    
    /**
     * Establece si hay un obstáculo que impida el cierre de la puerta.
     * @param hayObstaculo true si hay un objeto bloqueando, false en caso contrario.
     */
    public void setHayObstaculo(boolean hayObstaculo) { 
        this.hayObstaculo = hayObstaculo; 
    }
}