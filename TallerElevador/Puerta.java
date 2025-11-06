public class Puerta {
    private boolean abierta;
    private boolean hayObstaculo;

    public Puerta() {
        this.abierta = false;
        this.hayObstaculo = false;
    }

    public void abrir() {
        if (!hayObstaculo) {
            abierta = true;
            System.out.println("Puertas abiertas.");
        }
    }

    public void cerrar() {
        if (!hayObstaculo) {
            abierta = false;
            System.out.println("Puertas cerradas.");
        } else {
            System.out.println("Obstáculo detectado, no se cierran las puertas.");
        }
    }

    public void mantenerAbierta() {
        abierta = true;
        System.out.println("Botón de 'mantener puertas abiertas' activado.");
    }

    public boolean isAbierta() {
        return abierta;
    }

    public void setHayObstaculo(boolean hayObstaculo) {
        this.hayObstaculo = hayObstaculo;
    }
}