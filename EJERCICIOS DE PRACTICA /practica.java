import java.util.Arrays;
import java.util.Scanner;

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

System.out.println("******** EJERCICIO 3: ********");

double x1 = 0.0;

double y1 = 1.1;

double x2 = 4.94;

double y2 = 0.0;

double Pendiente = (y2 - y1)/ (x2- x1);

System.out.println("La Variable Y1 es: " + y1);

System.out.println("La Variable Y2 es: " + y2);

System.out.println("La Variable X1 es: " + x1);

System.out.println("La Variable X2 es: " + x2);

System.out.println("Con los parametros anteriores nos da La Pendiente: "+ Pendiente);

System.out.println("******** EJERCICIO 4: ********");

System.out.println("Juan David" + " Bautista Enciso");

System.out.println("******** EJERCICIO 5: ********");

System.out.println("hello"+ " world");

System.err.println("******** EJERCICIO 6: ********");


        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nElige ejercicio (2..10) o 0 para salir:");
            System.out.println("2 4.2 | 3 4.3 | 4 4.4 | 5 4.5 | 6 4.6 | 7 4.7 | 8 4.8 | 9 4.9 | 10 4.10 | 0 Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            switch(opcion) {
                case 2: ejercicio4_2(sc); break;
                case 3: ejercicio4_3(sc); break;
                case 4: ejercicio4_4(sc); break;
                case 5: ejercicio4_5(sc); break;
                case 6: ejercicio4_6(sc); break;
                case 7: ejercicio4_7(sc); break;
                case 8: ejercicio4_8(sc); break;
                case 9: ejercicio4_9(sc); break;
                case 10: ejercicio4_10(sc); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while(opcion != 0);

        sc.close();
    }

    static void ejercicio4_2(Scanner sc) {
        System.out.print("Ingrese el primer número: ");
        int num1 = sc.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int num2 = sc.nextInt();
        if (num1 > num2) System.out.println("El primer número es el más grande");
        else if (num1 == num2) System.out.println("Los dos números son iguales");
        else System.out.println("El primer número es el más pequeño");
    }

    static void ejercicio4_3(Scanner sc) {
        System.out.print("Ingrese el primer número: ");
        int a = sc.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int b = sc.nextInt();
        System.out.print("Ingrese el tercer número: ");
        int c = sc.nextInt();
        int[] arr = {a,b,c};
        Arrays.sort(arr);
        System.out.println("El número central es: " + arr[1]);
    }

    static void ejercicio4_4(Scanner sc) {
        System.out.print("Ingrese un número (double): ");
        double num = sc.nextDouble();
        if (num < 0) System.out.println("No se puede calcular la raíz cuadrada de un número negativo");
        else System.out.printf("La raíz cuadrada de %.4f es %.4f%n", num, Math.sqrt(num));
    }

    static void ejercicio4_5(Scanner sc) {
        System.out.print("Ingrese un número entero: ");
        int num = sc.nextInt();
        if (num % 2 == 0) System.out.println("Par (con %)");
        else System.out.println("Impar (con %)");
        if ((num & 1) == 0) System.out.println("Par (con operador &)");
        else System.out.println("Impar (con operador &)");
    }

    static void ejercicio4_6(Scanner sc) {
        System.out.print("Dia: "); int d = sc.nextInt();
        System.out.print("Mes: "); int m = sc.nextInt();
        System.out.print("Año: "); int y = sc.nextInt();
        int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31};
        if ((y%4==0 && y%100!=0) || (y%400==0)) diasMes[1]=29;
        if (m < 1 || m > 12 || d < 1 || d > diasMes[m-1]) {
            System.out.println("Fecha inválida");
            return;
        }
        d++;
        if (d > diasMes[m-1]) { d = 1; m++; if (m > 12) { m = 1; y++; } }
        System.out.println("Fecha siguiente: " + d + "/" + m + "/" + y);
    }

    static void ejercicio4_7(Scanner sc) {
        System.out.print("Cantidad de alumnos: ");
        int n = sc.nextInt();
        int menos40=0, entre40y50=0, entre50y60=0, mas60=0;
        for (int i=1; i<=n; i++) {
            System.out.print("Peso alumno " + i + ": ");
            double peso = sc.nextDouble();
            if (peso < 40) menos40++;
            else if (peso < 50) entre40y50++;
            else if (peso < 60) entre50y60++;
            else mas60++;
        }
        System.out.println("menos40: "+menos40+"\n40-50: "+entre40y50+"\n50-60: "+entre50y60+"\nmas60: "+mas60);
    }

    static void ejercicio4_8(Scanner sc) {
        System.out.print("Ingrese el primer número: "); int num1 = sc.nextInt();
        System.out.print("Ingrese el segundo número: "); int num2 = sc.nextInt();
        if (num2 != 0 && num1 % num2 == 0) System.out.println(num1 + " es divisible entre " + num2);
        else if (num1 != 0 && num2 % num1 == 0) System.out.println(num2 + " es divisible entre " + num1);
        else if (num1==0 && num2==0) System.out.println("Ambos son cero: indeterminado");
        else System.out.println("Ninguno es divisible entre el otro");
    }

    static void ejercicio4_9(Scanner sc) {
        System.out.print("Ingrese el ángulo en grados: ");
        int ang = sc.nextInt();
        if (ang > 0 && ang < 90) System.out.println("Agudo");
        else if (ang == 90) System.out.println("Recto");
        else if (ang > 90 && ang < 180) System.out.println("Obtuso");
        else if (ang == 180) System.out.println("Llano");
        else System.out.println("Ángulo fuera de rango (0-180)");
    }

    static void ejercicio4_10(Scanner sc) {
        System.out.print("Ingrese la nota (0-100): ");
        int nota = sc.nextInt();
        if (nota >= 90) System.out.println("A");
        else if (nota >= 80) System.out.println("B");
        else if (nota >= 70) System.out.println("C");
        else if (nota >= 60) System.out.println("D");
        else System.out.println("F");
    }






















































}


