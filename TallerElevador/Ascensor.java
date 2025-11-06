public class Ascensor {
    private int pisoActual;
    private String direccion; 
    private boolean enMovimiento;
    private Puerta puerta;
    private BotonDeAscensor[] botonesInternos;

    public Ascensor(int cantidadPisos) {
        this.pisoActual = 1;
        this.direccion = "detenido";
        this.enMovimiento = false;
        this.puerta = new Puerta();
        this.botonesInternos = new BotonDeAscensor[cantidadPisos];
        for (int i = 0; i < cantidadPisos; i++) {
            botonesInternos[i] = new BotonDeAscensor(i + 1);
        }
    }

    public void seleccionarPiso(int piso) {
        System.out.println("Piso " + piso + " solicitado desde el ascensor.");
        botonesInternos[piso - 1].presionar();
    }

    public void mover() {
       
        System.out.println("Ascensor moviéndose en dirección: " + direccion);
    }

    public void abrirPuertas() {
        puerta.abrir();
    }

    public void cerrarPuertas() {
        puerta.cerrar();
    }

    public void detenerAscensor() {
        direccion = "detenido";
        enMovimiento = false;
        System.out.println("Ascensor detenido en piso " + pisoActual);
    }

    public int getPisoActual() {
        return pisoActual;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
