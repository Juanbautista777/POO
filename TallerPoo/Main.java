import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("123456", "Juan Bautista");

        Foto foto1 = new Foto("foto_vacaciones.png");
        Producto impresion1 = new Impresion(1, "Color", foto1);

        Producto camara1 = new Camara(2, "Canon", "EOS 2000D");

        Producto[] productos = { impresion1, camara1 };

        Pedido pedido = new Pedido(cliente, productos, new Date(), 987654321);
        pedido.mostrarPedido();
    }
}
