import java.util.*;

/**
 * Clase central que gestiona la lógica de despacho de los ascensores.
 * Recibe solicitudes externas, asigna la mejor cabina y coordina el movimiento.
 */
public class SistemaControl {
    private List<Ascensor> ascensores;
    private List<Piso> pisos;
    private Queue<Solicitud> colaSolicitudes; // Cola para solicitudes externas pendientes

    /**
     * Constructor del SistemaControl. Inicializa las entidades físicas del edificio.
     * @param cantidadAscensores Número de cabinas de ascensor a crear.
     * @param cantidadPisos Número total de pisos en el edificio.
     */
    public SistemaControl(int cantidadAscensores, int cantidadPisos) {
        ascensores = new ArrayList<>();
        pisos = new ArrayList<>();
        colaSolicitudes = new LinkedList<>();
        
        // Crea los ascensores
        for (int i = 0; i < cantidadAscensores; i++) {
            ascensores.add(new Ascensor(i + 1, cantidadPisos));
        }
        
        // Crea los pisos, excluyendo botones de llamada en los extremos
        for (int i = 0; i < cantidadPisos; i++) {
            pisos.add(new Piso(i + 1, i == 0, i == cantidadPisos - 1));
        }
        
        System.out.println("🏢 Sistema iniciado: " + cantidadAscensores + 
                         " ascensor(es), " + cantidadPisos + " pisos");
    }

    /**
     * Recibe una solicitud de llamada desde un piso (botón externo).
     * @param piso El piso donde se realiza la llamada.
     * @param direccionStr La dirección deseada ("subir" o "bajar").
     */
    public void recibirSolicitud(int piso, String direccionStr) {
        Direccion direccion = direccionStr.equalsIgnoreCase("subir") ? 
                             Direccion.SUBIR : Direccion.BAJAR;
        
        Solicitud solicitud = new Solicitud(piso, direccion);
        colaSolicitudes.offer(solicitud);
        
        System.out.println("\n📞 NUEVA SOLICITUD - Piso " + piso + " → " + direccion);
        // Procesar la solicitud inmediatamente al recibirla
        procesarSolicitud(solicitud);
    }

    /**
     * Procesa la solicitud más reciente: identifica el mejor ascensor 
     * y le asigna el destino.
     * @param solicitud El objeto Solicitud a procesar.
     */
    private void procesarSolicitud(Solicitud solicitud) {
        Ascensor mejorAscensor = seleccionarMejorAscensor(solicitud);
        
        if (mejorAscensor != null) {
            // Asignar el piso de origen de la solicitud como destino interno del ascensor
            mejorAscensor.agregarDestino(solicitud.getPisoOrigen());
            System.out.println("✅ Asignada al Ascensor " + mejorAscensor.getId());
        } else {
            System.out.println("❌ No se encontró un ascensor óptimo. Solicitud pendiente.");
            // La solicitud se mantiene en la cola para ser reintentada en el siguiente ciclo
        }
    }

    /**
     * Implementa la lógica de despacho para encontrar el ascensor más adecuado.
     * Prioriza por: 
     * 1. Ascensor disponible que ya va en la misma dirección y está más cerca (más eficiente).
     * 2. Ascensor detenido más cercano.
     * @param solicitud La solicitud que necesita ser atendida.
     * @return El objeto Ascensor seleccionado o null si no hay opciones.
     */
    private Ascensor seleccionarMejorAscensor(Solicitud solicitud) {
        Ascensor mejor = null;
        int menorDistancia = Integer.MAX_VALUE;
        int pisoSolicitado = solicitud.getPisoOrigen();

        for (Ascensor asc : ascensores) {
            if (!asc.estaDisponible()) continue; // Ignorar ascensores en mantenimiento/emergencia

            int distancia = asc.calcularDistancia(pisoSolicitado);
            Direccion dirAscensor = asc.getDireccion();
            boolean mismaDireccion = asc.vaEnDireccion(solicitud.getDireccion());
            
            // Prioridad 1: Ascensores en movimiento que pueden recoger la solicitud en el camino
            if (dirAscensor != Direccion.DETENIDO && mismaDireccion) {
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    mejor = asc;
                }
            } 
            // Prioridad 2: Ascensores detenidos o el primer ascensor encontrado como fallback
            else if (dirAscensor == Direccion.DETENIDO || mejor == null) {
                if (distancia < menorDistancia) {
                    menorDistancia = distancia;
                    mejor = asc;
                }
            }
        }

        return mejor;
    }

    /**
     * Ejecuta la simulación del movimiento de todos los ascensores durante un número de ciclos.
     * @param ciclos Número de ciclos (segundos simulados) que debe durar la simulación.
     */
    public void simularMovimientos(int ciclos) {
        System.out.println("\n🎬 Iniciando simulación de " + ciclos + " ciclos...\n");
        
        for (int i = 0; i < ciclos; i++) {
            System.out.println("--- Ciclo " + (i + 1) + " ---");
            
            for (Ascensor asc : ascensores) {
                if (asc.tieneDestinos()) {
                    // Mover el ascensor un piso si tiene destinos pendientes
                    asc.moverUnPiso();
                }
            }
            
            try {
                // Pausa para simular el paso de un segundo
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }

    /**
     * Imprime el estado actual de todos los ascensores al finalizar la simulación.
     */
    public void mostrarEstado() {
        System.out.println("\n📊 ESTADO DEL SISTEMA:");
        for (Ascensor asc : ascensores) {
            System.out.println("  Ascensor " + asc.getId() + 
                             " - Piso: " + asc.getPisoActual() + 
                             " - Estado: " + asc.getEstado() +
                             " - Dirección: " + asc.getDireccion());
        }
    }
}