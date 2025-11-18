public class Piso {
    private int numero;
    private BotonDePiso botonSubir;
    private BotonDePiso botonBajar;

    public Piso(int numero, boolean primerPiso, boolean ultimoPiso) {
        this.numero = numero;
        if (!primerPiso) {
            botonBajar = new BotonDePiso(Direccion.BAJAR);
        }
        if (!ultimoPiso) {
            botonSubir = new BotonDePiso(Direccion.SUBIR);
        }
    }

    public int getNumero() { return numero; }

    public void presionarSubir() {
        if (botonSubir != null) {
            System.out.println("🔼 Piso " + numero + " solicita SUBIR");
            botonSubir.presionar();
        } else {
            System.out.println("❌ No hay botón de subir en el último piso");
        }
    }

    public void presionarBajar() {
        if (botonBajar != null) {
            System.out.println("🔽 Piso " + numero + " solicita BAJAR");
            botonBajar.presionar();
        } else {
            System.out.println("❌ No hay botón de bajar en el primer piso");
        }
    }

    public boolean tieneBotonSubir() { return botonSubir != null; }
    public boolean tieneBotonBajar() { return botonBajar != null; }
}