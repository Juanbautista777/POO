public class Foto {
    private String fichero;

    public Foto(String fichero) {
        this.fichero = fichero;
    }

    public void print() {
        System.out.println("Imprimiendo foto: " + fichero);
    }

    @Override
    public String toString() {
        return "Foto: " + fichero;
    }
}
