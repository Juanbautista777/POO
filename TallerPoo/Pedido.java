import java.util.Date;

public class Pedido {
    private Cliente cliente;
    private Producto[] productos;
    private Date fecha;
    private int numeroTarjetaCredito;

    public Pedido(Cliente cliente, Producto[] productos, Date fecha, int numeroTarjetaCredito) {
        this.cliente = cliente;
        this.productos = productos;
        this.fecha = fecha;
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }

    public void mostrarPedido() {
        System.out.println(cliente.toString());
        System.out.println("Fecha: " + fecha);
        System.out.println("Número de tarjeta: " + numeroTarjetaCredito);
        System.out.println("Productos:");
        for (Producto p : productos) {
            System.out.println("  - " + p.toString());
        }
    }
}
