public class BotonDeAscensor extends Boton {
    private int pisoDestino;

    public BotonDeAscensor(int pisoDestino) {
        super();
        this.pisoDestino = pisoDestino;
    }

    @Override
    public void presionar() {
        super.presionar();
        System.out.println("   Destino interno: Piso " + pisoDestino);
    }

    public int getPisoDestino() { return pisoDestino; }
}
