public class Main {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════");
        System.out.println("   SISTEMA DE CONTROL DE ASCENSORES   ");
        System.out.println("═══════════════════════════════════════\n");
        
        // Crear sistema: 2 ascensores, 10 pisos
        SistemaControl sistema = new SistemaControl(2, 10);
        
        // Escenario de prueba
        System.out.println("\n🧪 ESCENARIO DE PRUEBA:");
        
        // Solicitudes desde diferentes pisos
        sistema.recibirSolicitud(3, "subir");
        sistema.recibirSolicitud(7, "bajar");
        sistema.recibirSolicitud(5, "subir");
        
        // Simular movimientos
        sistema.simularMovimientos(20);
        
        // Mostrar estado final
        sistema.mostrarEstado();
        
        System.out.println("\n✅ Simulación completada");
    }
}