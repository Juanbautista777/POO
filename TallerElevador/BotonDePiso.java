public class BotonDePiso extends Boton {
    private Direccion direccion;
    
    public BotonDePiso(Direccion direccion) {
        super();
        this.direccion = direccion;
    }

    @Override
    public void presionar() {
        super.presionar();
        System.out.println("   Dirección solicitada: " + direccion);
    }

    public Direccion getDireccion() { return direccion; }
}
