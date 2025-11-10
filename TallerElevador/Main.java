public class Main {
    public static void main(String[] args) {
        SistemaControl sistema = new SistemaControl(1, 5);

        // Ejemplo de prueba inicial
        sistema.recibirSolicitud(3, "subir");
        sistema.recibirSolicitud(5, "bajar");
    }
}