import java.util.*;

public class SistemaControl {
    private List<Ascensor> ascensores;
    private List<Piso> pisos;

    public SistemaControl(int cantidadAscensores, int cantidadPisos) {
        ascensores = new ArrayList<>();
        pisos = new ArrayList<>();
        for (int i = 0; i < cantidadAscensores; i++) {
            ascensores.add(new Ascensor(cantidadPisos));
        }
        for (int i = 0; i < cantidadPisos; i++) {
            pisos.add(new Piso(i + 1, i == 0, i == cantidadPisos - 1));
        }
    }

    public void recibirSolicitud(int piso, String direccion) {
        System.out.println("Solicitud recibida en piso " + piso + " hacia " + direccion);
       
    }

    public void actualizarMovimientos() {
       
    }

    public void detectarFalla() {
        
    }
}