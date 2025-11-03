public class Impresion extends Producto {
    private String color;
    private Foto foto;

    public Impresion(int numero, String color, Foto foto) {
        super(numero);
        this.color = color;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Impresión [#" + numero + "] Color: " + color + ", " + foto.toString();
    }
}
