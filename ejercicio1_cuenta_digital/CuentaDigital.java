public class CuentaDigital {
    private final String titular;
    private final String id;
    private double saldo;

    public CuentaDigital(String titular, String id, double saldoInicial) {
        if (titular == null || titular.isBlank()) throw new IllegalArgumentException("Titular invalido");
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Identificador invalido");
        if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial negativo");
        this.titular = titular;
        this.id = id;
        this.saldo = saldoInicial;
    }

    public boolean depositar(double monto) {
        if (monto <= 0) return false;
        saldo += monto;
        return true;
    }

    public boolean retirar(double monto) {
        if (monto <= 0 || monto > saldo) return false;
        saldo -= monto;
        return true;
    }

    public double consultarSaldo() { return saldo; }
    public String getTitular() { return titular; }
    public String getId() { return id; }

    @Override
    public String toString() {
        return String.format("Cuenta[%s | %s | saldo=%.2f]", id, titular, saldo);
    }
}
