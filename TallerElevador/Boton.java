public class Boton {
    private boolean iluminado;
    private boolean presionado;

    public Boton() {  
        this.iluminado = false;
        this.presionado = false;
    }

    public void presionar() {
        this.presionado = true;
        this.iluminado = true;
        System.out.println("💡 Beep! Botón presionado.");
    }

    public void apagarLuz() {
        this.iluminado = false;
        this.presionado = false;
        System.out.println("🔌 Luz del botón apagada.");
    }

    public boolean isIluminado() { return iluminado; }
    public boolean isPresionado() { return presionado; }
}
