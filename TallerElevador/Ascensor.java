import java.util.*;

public class Ascensor {
    private int id;
    private int pisoActual;
    private Direccion direccion;
    private EstadoAscensor estado;
    private Puerta puerta;
    private BotonDeAscensor[] botonesInternos;
    private Queue<Integer> colaDestinos;
    private int capacidadMaxima;
    private int pasajerosActuales;

    public Ascensor(int id, int cantidadPisos) {
        this.id = id;
        this.pisoActual = 1;
        this.direccion = Direccion.DETENIDO;
        this.estado = EstadoAscensor.DETENIDO;
        this.puerta = new Puerta();
        this.botonesInternos = new BotonDeAscensor[cantidadPisos];
        this.colaDestinos = new LinkedList<>();
        this.capacidadMaxima = 8;
        this.pasajerosActuales = 0;
        
        for (int i = 0; i < cantidadPisos; i++) {
            botonesInternos[i] = new BotonDeAscensor(i + 1);
        }
    }

    public void agregarDestino(int piso) {
        if (piso != pisoActual && !colaDestinos.contains(piso)) {
            colaDestinos.offer(piso);
            botonesInternos[piso - 1].presionar();
            System.out.println("📝 Ascensor " + id + ": Piso " + piso + " agregado a la cola");
        }
    }

    public void moverUnPiso() {
        if (colaDestinos.isEmpty()) {
            detenerAscensor();
            return;
        }

        int destino = colaDestinos.peek();
        
        if (destino > pisoActual) {
            direccion = Direccion.SUBIR;
            pisoActual++;
        } else if (destino < pisoActual) {
            direccion = Direccion.BAJAR;
            pisoActual--;
        }
        
        estado = EstadoAscensor.EN_MOVIMIENTO;
        System.out.println("🔼🔽 Ascensor " + id + " " + direccion + " - Piso actual: " + pisoActual);

        if (pisoActual == destino) {
            llegadaAPiso();
        }
    }

    private void llegadaAPiso() {
        colaDestinos.poll();
        detenerAscensor();
        abrirPuertas();
        botonesInternos[pisoActual - 1].apagarLuz();
        
        try {
            Thread.sleep(2000); // Simula tiempo de espera
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        cerrarPuertas();
    }

    public void abrirPuertas() {
        puerta.abrir();
    }

    public void cerrarPuertas() {
        puerta.cerrar();
    }

    public void detenerAscensor() {
        direccion = Direccion.DETENIDO;
        estado = EstadoAscensor.DETENIDO;
        System.out.println("⏹️  Ascensor " + id + " DETENIDO en piso " + pisoActual);
    }

    public void declararEmergencia() {
        estado = EstadoAscensor.EMERGENCIA;
        colaDestinos.clear();
        detenerAscensor();
        abrirPuertas();
        System.out.println("🚨 EMERGENCIA - Ascensor " + id + " detenido");
    }

    public int calcularDistancia(int pisoSolicitado) {
        return Math.abs(pisoActual - pisoSolicitado);
    }

    public boolean estaDisponible() {
        return estado != EstadoAscensor.MANTENIMIENTO && 
               estado != EstadoAscensor.EMERGENCIA;
    }

    public boolean vaEnDireccion(Direccion dir) {
        return this.direccion == dir || this.direccion == Direccion.DETENIDO;
    }

    // Getters
    public int getId() { return id; }
    public int getPisoActual() { return pisoActual; }
    public Direccion getDireccion() { return direccion; }
    public EstadoAscensor getEstado() { return estado; }
    public boolean tieneDestinos() { return !colaDestinos.isEmpty(); }
}
