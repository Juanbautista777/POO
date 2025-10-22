public class MarcaTv {
    protected String nombre;
    protected int pulgadas;
    protected double precio;

    public MarcaTv(String nombre, int pulgadas, double precio) {
        this.nombre = nombre;
        this.pulgadas = pulgadas;
        this.precio = precio;
    }

    public void mostrarInfo() {
        System.out.println("Marca: " + nombre);
        System.out.println("Pulgadas: " + pulgadas);
        System.out.println("Precio: $" + precio);
    }
}