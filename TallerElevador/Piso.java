public class Piso {
    private int numero;
    private BotonDePiso botonSubir;
    private BotonDePiso botonBajar;

    public Piso(int numero, boolean primerPiso, boolean ultimoPiso) {
        this.numero = numero;
        if (!primerPiso)
            botonBajar = new BotonDePiso("bajar");
        if (!ultimoPiso)
            botonSubir = new BotonDePiso("subir");
    }

    public int getNumero() {
        return numero;
    }

    public void presionarSubir() {
        if (botonSubir != null) botonSubir.presionar();
    }

    public void presionarBajar() {
        if (botonBajar != null) botonBajar.presionar();
    }
}