public class practica {
    public static void main (String[] args){

double R1 = 2200;

double R2 = 10000; 

double V = 10.0;

double VBB = R1 / (R2 + R1);

System.out.println("******** PRACTICA CON EJERCICIOS COMPLEJOS ********");

System.out.println("******** EJERCICIO 1: ********");

System.out.println("La  resistencia #1 es de:" + R1 );

System.out.println("La resistencia es #2 de:" + R2 );

System.out.println("El voltaje es de:" + V );

System.out.println("La Carga de la tension de salida es de:" + VBB );

System.out.println("******** EJERCICIO 2: ********");

double V1 = 1.8;

double V2 = 0.7;

double KO1 = 1000;

double KO2 = 1800;

double Ie = (V1 - V2) / (KO1 + (KO2 / 200.0)) ;

System.out.println("El voltaje #1 es de: "+ V1);

System.out.println("El voltaje #2 es de: "+ V2);

System.out.println("La Resistencia #1 es de: "+ KO1);

System.out.println("La Resistencia #2 es de: "+ KO2);

System.out.println("La Corriente del emisor es de: "+ Ie * 1000);





}


}