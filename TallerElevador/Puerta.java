public class Puerta {
    private boolean abierta;
    private boolean hayObstaculo;
    private static final int TIEMPO_ESPERA = 3; // segundos

    public Puerta() {
        this.abierta = false;
        this.hayObstaculo = false;
    }

    public void abrir() {
        if (!hayObstaculo) {
            abierta = true;
            System.out.println("🚪 Puertas ABIERTAS");
        } else {
            System.out.println("⚠️  No se pueden abrir: obstáculo detectado");
        }
    }

    public void cerrar() {
        if (!hayObstaculo) {
            abierta = false;
            System.out.println("🚪 Puertas CERRADAS");
        } else {
            System.out.println("⚠️  Obstáculo detectado, puertas permanecen abiertas");
            reabrirPorSeguridad();
        }
    }

    private void reabrirPorSeguridad() {
        abierta = true;
        System.out.println("🔄 Reabriendo puertas por seguridad...");
    }

    public void mantenerAbierta() {
        abierta = true;
        System.out.println("🖐️  Botón 'mantener abiertas' activado");
    }

    public boolean isAbierta() { return abierta; }
    public void setHayObstaculo(boolean hayObstaculo) { 
        this.hayObstaculo = hayObstaculo; 
    }
}