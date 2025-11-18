/**
 * Representa un botón de destino dentro de la cabina del ascensor.
 * Hereda la funcionalidad básica de la clase Boton.
 */
public class BotonDeAscensor extends Boton {
    private int pisoDestino;

    /**
     * Constructor para un BotonDeAscensor.
     * @param pisoDestino El número de piso al que este botón solicita ir.
     */
    public BotonDeAscensor(int pisoDestino) {
        super();
        this.pisoDestino = pisoDestino;
    }

    /**
     * Simula la pulsación, además de la lógica base, muestra el piso de destino.
     */
    @Override
    public void presionar() {
        super.presionar();
        System.out.println("   Destino interno: Piso " + pisoDestino);
    }

    /**
     * Obtiene el piso de destino asociado a este botón.
     * @return El número de piso de destino.
     */
    public int getPisoDestino() { return pisoDestino; }
}