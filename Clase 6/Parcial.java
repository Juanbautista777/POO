public class Parcial {
    public static void main(String[] args) {

        // --- Creacion de una cuenta bancaria ---
        CuentaBancaria cuenta = new CuentaBancaria("Juan", "123456", 100);

        cuenta.depositar(50);
        cuenta.retirar(170);
        System.out.println(cuenta);

        // --- Creacion de un producto ---
        Producto1 p1 = new Producto1 ("Laptop", 2500.0, 2, 10);
        System.out.println(p1);
    }
}
