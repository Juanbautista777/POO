public class Samsung extends MarcaTv {
    private boolean tieneTizen;

    public Samsung(int pulgadas, double precio, boolean tieneTizen) {
        super("Samsung", pulgadas, precio);
        this.tieneTizen = tieneTizen;
    }

    public void mostrarSistema() {
        if (tieneTizen) {
            System.out.println("Este televisor Samsung usa el sistema Tizen.");
        } else {
            System.out.println("Este televisor Samsung no tiene Tizen.");
        }
    }
}