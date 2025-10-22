public class LG extends MarcaTv {

    private boolean tieneWebOS;

   
    public LG(int pulgadas, double precio, boolean tieneWebOS) {
        super("LG", pulgadas, precio);  
        this.tieneWebOS = tieneWebOS;
    }

   
    public void mostrarSistema() {
        if (tieneWebOS) {
            System.out.println("Este televisor LG usa el sistema WebOS.");
        } else {
            System.out.println("Este televisor LG no tiene WebOS.");
        }
    }
}

