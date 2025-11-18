import java.util.*;

/**
 * Clase principal que modela la cabina del ascensor y su comportamiento.
 * Gestiona el movimiento, la cola de destinos interna y el estado de la puerta.
 */
public class Ascensor {
    private int id;
    private int pisoActual;
    private Direccion direccion;
    private EstadoAscensor estado;
    private Puerta puerta;
    private BotonDeAscensor[] botonesInternos;
    private Queue<Integer> colaDestinos; // Pisos a visitar (internos y asignados)
    private int capacidadMaxima;
    private int pasajerosActuales;

    /**
     * Constructor para crear un Ascensor.
     * @param id Identificador único del ascensor.
     * @param cantidadPisos El número total de pisos del edificio.
     */
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
        
        // Inicializa los botones de destino internos
        for (int i = 0; i < cantidadPisos; i++) {
            botonesInternos[i] = new BotonDeAscensor(i + 1);
        }
    }

    /**
     * Agrega un piso a la cola de destinos del ascensor y presiona el botón interno.
     * Usado tanto para solicitudes internas como externas asignadas.
     * @param piso El número de piso a agregar.
     */
    public void agregarDestino(int piso) {
        if (piso != pisoActual && !colaDestinos.contains(piso)) {
            colaDestinos.offer(piso);
            botonesInternos[piso - 1].presionar(); // Marca el botón como presionado
            System.out.println("📝 Ascensor " + id + ": Piso " + piso + " agregado a la cola");
        }
    }

    /**
     * Simula el movimiento del ascensor un piso a la vez.
     * Si no hay destinos, se detiene. Si llega al siguiente destino, llama a llegadaAPiso().
     */
    public void moverUnPiso() {
        if (colaDestinos.isEmpty()) {
            detenerAscensor();
            return;
        }

        int siguientePiso = colaDestinos.peek();
        
        // Determinar la dirección basada en el siguiente destino
        if (siguientePiso > pisoActual) {
            direccion = Direccion.SUBIR;
            pisoActual++;
        } else if (siguientePiso < pisoActual) {
            direccion = Direccion.BAJAR;
            pisoActual--;
        }

        estado = EstadoAscensor.EN_MOVIMIENTO;
        
        System.out.println("⬆️ Ascensor " + id + " en PISO " + pisoActual + 
                           " (Dir: " + direccion + ", Próximo: " + siguientePiso + ")");

        // Lógica de llegada
        if (pisoActual == siguientePiso) {
            llegadaAPiso(siguientePiso);
        }
    }

    /**
     * Maneja la lógica que ocurre inmediatamente al llegar a un piso de destino.
     * @param pisoDestino El piso al que se ha llegado.
     */
    private void llegadaAPiso(int pisoDestino) {
        colaDestinos.poll(); // Quita el destino de la cola
        detenerAscensor();
        
        // 1. Apagar botón interno
        botonesInternos[pisoDestino - 1].apagarLuz();
        
        // 2. Abrir puertas y esperar
        abrirPuertas();
        
        System.out.println("⏳ Esperando 2 segundos...");
        try {
            Thread.sleep(2000); // Simula tiempo de espera
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
        
        cerrarPuertas();
    }

    /** Simula la apertura de las puertas. */
    public void abrirPuertas() {
        puerta.abrir();
    }

    /** Simula el cierre de las puertas. */
    public void cerrarPuertas() {
        puerta.cerrar();
    }

    /** Detiene el ascensor y cambia su estado. */
    public void detenerAscensor() {
        direccion = Direccion.DETENIDO;
        estado = EstadoAscensor.DETENIDO;
        System.out.println("⏹️  Ascensor " + id + " DETENIDO en piso " + pisoActual);
    }

    /**
     * Pone el ascensor en estado de emergencia, limpiando destinos y deteniéndolo.
     */
    public void declararEmergencia() {
        estado = EstadoAscensor.EMERGENCIA;
        colaDestinos.clear();
        detenerAscensor();
        abrirPuertas();
        System.out.println("🚨 EMERGENCIA - Ascensor " + id + " detenido");
    }

    /**
     * Calcula la distancia absoluta entre la posición actual y un piso solicitado.
     * @param pisoSolicitado El piso de la solicitud.
     * @return La distancia en número de pisos.
     */
    public int calcularDistancia(int pisoSolicitado) {
        return Math.abs(pisoActual - pisoSolicitado);
    }

    /**
     * Determina si el ascensor está en un estado operativo (no mantenimiento, no emergencia).
     * @return true si está disponible para recibir solicitudes, false en caso contrario.
     */
    public boolean estaDisponible() {
        return estado != EstadoAscensor.MANTENIMIENTO && 
               estado != EstadoAscensor.EMERGENCIA;
    }

    /**
     * Verifica si el ascensor se está moviendo en la misma dirección que la solicitada, 
     * o si está detenido.
     * @param dir La dirección de la solicitud.
     * @return true si la dirección actual coincide o está detenido, false si va en contra.
     */
    public boolean vaEnDireccion(Direccion dir) {
        return this.direccion == dir || this.direccion == Direccion.DETENIDO;
    }
    
    /**
     * Verifica si el ascensor tiene destinos pendientes en su cola.
     * @return true si la cola de destinos no está vacía.
     */
    public boolean tieneDestinos() {
        return !colaDestinos.isEmpty();
    }
    // Getters y Setters
    public int getId() { return id; }
    public int getPisoActual() { return pisoActual; }
    public Direccion getDireccion() { return direccion; }
    public EstadoAscensor getEstado() { return estado; }
    public int getCapacidadMaxima() { return capacidadMaxima; }
    public int getPasajerosActuales() { return pasajerosActuales; }}
