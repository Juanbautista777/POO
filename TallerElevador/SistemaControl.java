import java.util.*;

public class SistemaControl {
    private List<Ascensor> ascensores;
    private List<Piso> pisos;
    private Queue<Solicitud> colaSolicitudes;

    public SistemaControl(int cantidadAscensores, int cantidadPisos) {
        ascensores = new ArrayList<>();
        pisos = new ArrayList<>();
        colaSolicitudes = new LinkedList<>();
        
        for (int i = 0; i < cantidadAscensores; i++) {
            ascensores.add(new Ascensor(i + 1, cantidadPisos));
        }
        
        for (int i = 0; i < cantidadPisos; i++) {
            pisos.add(new Piso(i + 1, i == 0, i == cantidadPisos - 1));
        }
        
        System.out.println("🏢 Sistema iniciado: " + cantidadAscensores + 
                         " ascensor(es), " + cantidadPisos + " pisos");
    }

    public void recibirSolicitud(int piso, String direccionStr) {
        Direccion direccion = direccionStr.equalsIgnoreCase("subir") ? 
                             Direccion.SUBIR : Direccion.BAJAR;
        
        Solicitud solicitud = new Solicitud(piso, direccion);
        colaSolicitudes.offer(solicitud);
        
        System.out.println("\n📞 NUEVA SOLICITUD - Piso " + piso + " → " + direccion);
        procesarSolicitud(solicitud);
    }

    private void procesarSolicitud(Solicitud solicitud) {
        Ascensor mejorAscensor = seleccionarMejorAscensor(solicitud);
        
        if (mejorAscensor != null) {
            System.out.println("✅ Asignado: Ascensor " + mejorAscensor.getId());
            mejorAscensor.agregarDestino(solicitud.getPisoOrigen());
        } else {
            System.out.println("⏳ Sin ascensores disponibles, solicitud en espera");
        }
    }

    private Ascensor seleccionarMejorAscensor(Solicitud solicitud) {
        Ascensor mejor = null;
        int menorDistancia = Integer.MAX_VALUE;

        for (Ascensor asc : ascensores) {
            if (!asc.estaDisponible()) continue;

            int distancia = asc.calcularDistancia(solicitud.getPisoOrigen());
            
            // Priorizar ascensores que van en la misma dirección
            boolean mismaDireccion = asc.vaEnDireccion(solicitud.getDireccion());
            
            if (mismaDireccion && distancia < menorDistancia) {
                menorDistancia = distancia;
                mejor = asc;
            } else if (mejor == null && asc.getDireccion() == Direccion.DETENIDO) {
                mejor = asc;
                menorDistancia = distancia;
            }
        }

        return mejor;
    }

    public void simularMovimientos(int ciclos) {
        System.out.println("\n🎬 Iniciando simulación de " + ciclos + " ciclos...\n");
        
        for (int i = 0; i < ciclos; i++) {
            System.out.println("--- Ciclo " + (i + 1) + " ---");
            
            for (Ascensor asc : ascensores) {
                if (asc.tieneDestinos()) {
                    asc.moverUnPiso();
                }
            }
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

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