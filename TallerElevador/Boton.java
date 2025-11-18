/**
 * Clase base abstracta que representa la funcionalidad común de cualquier botón
 * en el sistema de ascensor (tanto dentro de la cabina como en los pisos).
 */
public class Boton {
    private boolean iluminado;
    private boolean presionado;

    /**
     * Constructor por defecto de un Boton. Inicialmente no está ni presionado ni iluminado.
     */
    public Boton() {  
        this.iluminado = false;
        this.presionado = false;
    }

    /**
     * Simula la pulsación del botón, activando los estados de 'presionado' e 'iluminado'.
     */
    public void presionar() {
        this.presionado = true;
        this.iluminado = true;
        System.out.println("💡 Beep! Botón presionado.");
    }

    /**
     * Apaga la luz del botón y restablece su estado a no presionado.
     */
    public void apagarLuz() {
        this.iluminado = false;
        this.presionado = false;
        System.out.println("🔌 Luz del botón apagada.");
    }

    /**
     * Verifica si el botón está actualmente iluminado.
     * @return true si la luz está encendida, false en caso contrario.
     */
    public boolean isIluminado() { return iluminado; }
    
    /**
     * Verifica si el botón está actualmente presionado.
     * @return true si está presionado, false en caso contrario.
     */
    public boolean isPresionado() { return presionado; }
}