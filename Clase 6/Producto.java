public class Producto {

    //  Atributos 
    private String nombre;
    private double precioUnitario;
    private int cantidad;
    private double descuento; 

    //  Constructor por defecto 
    public Producto() {
        this.nombre = "Sin nombre";
        this.precioUnitario = 0.0;
        this.cantidad = 0;
        this.descuento = 0.0;
    }

    //  Constructor parametrizado
    public Producto(String nombre, double precioUnitario, int cantidad, double descuento) {
        setNombre(nombre);
        setPrecioUnitario(precioUnitario);
        setCantidad(cantidad);
        setDescuento(descuento);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getDescuento() {
        return descuento;
    }

    //  Setters (para modificar valores con validación)
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario < 0) {
            throw new IllegalArgumentException("El precio unitario no puede ser negativo");
        }
        this.precioUnitario = precioUnitario;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
    }

    public void setDescuento(double descuento) {
        if (descuento < 0 || descuento > 100) {
            throw new IllegalArgumentException("El descuento debe estar entre 0 y 100%");
        }
        this.descuento = descuento;
    }

    //  Método para calcular el total con descuento y con impuesto del 8%
    public double calcularTotal() {
        double subtotal = precioUnitario * cantidad;
        double totalConDescuento = subtotal - (subtotal * descuento / 100);
        double totalConImpuesto = totalConDescuento * 1.08; // se aplica el impuesto del 8%
        return totalConImpuesto;
    }

    // Método toString() para mostrar la información del producto
    @Override
    public String toString() {
        return "Producto: " + nombre +
               "\nPrecio unitario: $" + precioUnitario +
               "\nCantidad: " + cantidad +
               "\nDescuento: " + descuento + "%" +
               "\nTotal con impuesto (8%): $" + calcularTotal();
    }
}
