public class Marcas {
    public static void main(String[] args) {
        LG tv1 = new LG(55, 2500000, true);
        Samsung tv2 = new Samsung(65, 3000000, true);

        tv1.mostrarInfo();
        tv2.mostrarInfo();

        tv1.mostrarSistema();
        tv2.mostrarSistema();
    }
}
    

