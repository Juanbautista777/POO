 public class CuentaBancaria {
    private String titular;       // privado para proteger dato
    private String numeroCuenta;  // privado
    private double saldo;         // privado, invariante: saldo >= 0

    // Constructor por defecto
    public CuentaBancaria() {
        this.titular = "Santiago Herrera";
        this.numeroCuenta = "5826JBN";
        this.saldo = 0.0;
    }

    // Constructor parametrizado
    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        setTitular(titular);
        setNumeroCuenta(numeroCuenta);
        setSaldo(saldoInicial);
    }

    // Getters
    public String getTitular() { return titular; }
    public String getNumeroCuenta() { return numeroCuenta; }
    public double getSaldo() { return saldo; }

    // Setters con validación
    public void setTitular(String titular) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("Titular no puede estar vacío");
        }
        this.titular = titular.trim();
    }

    public void setNumeroCuenta(String numeroCuenta) {
        if (numeroCuenta == null || numeroCuenta.trim().length() < 6) {
            throw new IllegalArgumentException("Número de cuenta debe tener al menos 6 dígitos");
        }
        this.numeroCuenta = numeroCuenta.trim();
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("Saldo no puede ser negativo");
        }
        this.saldo = saldo;
    }

    // Método depositar
    public void depositar(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("Monto a depositar debe ser mayor a cero");
        }
        this.saldo += monto;
    }

    // Método retirar
    public boolean retirar(double monto) {
        if (monto <= 0) return false;           
        if (this.saldo >= monto) {
            this.saldo -= monto;
            return true;
        }
        return false; 
        /*
    public boolean retirar(double monto) {
        if (monto <= 0) return false;           
        if ((saldo - monto) >= -50) { 
        saldo -= monto;
        return true;
        }
        return false; 
 */
    }

    @Override
    public String toString() {
        return "CuentaBancaria[titular=" + titular + ", numero=" + numeroCuenta + ", saldo=" + saldo + "]";
    }
}

    

