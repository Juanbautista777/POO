public class PracticaDeCondicionales {

    public static void main(String[] args) {

        /* ejercicio 4.1 A) */

        double angulo = 80;

        if (angulo == 90) {

            System.out.println("el angulo si es un angulo recto");
        } else {
            System.out.println("el angulo no es un angulo recto ");
        }

        /* ejercicio 4.1 B) */

        double temperatura = 100;

        if (temperatura > 100) {
            System.out.println("por encima del punto de ebullición del agua");

        } else {
            System.out.println("por debajo del punto de ebullición del agua");
        }

        /* ejercicio 4.1 C) */

        int positivos = 0;
        int negativos = 0;
        int numero = 10;

        if (numero >= 0) {
            int TOTALPOSITIVOS = positivos + numero;
            System.out.println("total positivos: " + TOTALPOSITIVOS);
        } else {
            int TOTALNEGATIVOS = negativos + numero;
            System.out.println("Total negativos: " + TOTALNEGATIVOS);
        }

        /* ejercicio 4.1 D) */

        int x = 100;
        int y = 20;
        int z = 10;

        if (x > y && z < 20) {
            int P = x * y;
            System.out.println("La distancia P es: " + P);

        } else {
            System.out.println("no es posible calcular distancia para P ");
        }

        /* ejercicio 4.1 E) */

        int distancia = 21;

        if (distancia > 20 && distancia < 35) {
            int tiempo = 100;
            System.out.println("el tiempo vale: " + tiempo + " segundos");
        }

        else {
            System.out.println("no es posible calcular el tiempo ");
        }


         /* ejercicio 4.9  */
        
         int Angulo = 1;
        if (Angulo < 90) { System.out.println("este es un angulo agudo");
            
        } else { 
            if (Angulo > 90) { System.out.println("este angulo es obtuso ");
                
            } else {   System.out.println(" es un angulo recto ");}
        }


    }
}
