public class Parcial {

    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria("Juan", "123456",100);

        cuenta.depositar(50);
        cuenta.retirar(170);
        System.out.println(cuenta);

        Producto p1 = new Producto("Laptop", 2500.0, 2, 10);
        System.out.println(p1);

    }
}