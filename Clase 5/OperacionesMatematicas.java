public class OperacionesMatematicas {
     private int n1;
    private int n2;


     public OperacionesMatematicas(int n1, int n2){
         this.n1 = n1; 
         this.n2 = n2;
     }
        public int sumar(){
         return n1 + n2;
        }

        public int restar (){
        return n1 - n2;
        }

        public int multiplicar(){
        return n1 * n2;

        }
        
        public int dividir (){
        return n1 / n2; 
            
        }
        public static double elevarCuadrado(double num) {
        return Math.pow(num, 2);
    }

    public static double elevarCubo(double num) {
        return Math.pow(num, 3);
    }

    public static double elevarN(double num, int n) {
        return Math.pow(num, n);
    }

    public static double raizCuadrada(double num) {
        return Math.sqrt(num);
    }

    public static double raizCubica(double num) {
        return Math.cbrt(num);
    }

    public static double raizN(double num, int n) {
        return Math.pow(num, 1.0 / n);
    
     }
     }
   