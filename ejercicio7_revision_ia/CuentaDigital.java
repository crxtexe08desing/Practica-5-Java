// Copia de CuentaDigital (ejercicio 1) con la correccion confirmada en las pruebas:
// montos NaN / infinito se rechazaban mal (NaN <= 0 es false) y corrompian el saldo.
public class CuentaDigital {
    private final String titular;
    private final String id;
    private double saldo;

    public CuentaDigital(String titular, String id, double saldoInicial) {
        if (titular == null || titular.isBlank()) throw new IllegalArgumentException("Titular invalido");
        if (id == null || id.isBlank()) throw new IllegalArgumentException("Identificador invalido");
        if (!Double.isFinite(saldoInicial) || saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial invalido");
        this.titular = titular;
        this.id = id;
        this.saldo = saldoInicial;
    }

    private static boolean montoValido(double monto) {
        return Double.isFinite(monto) && monto > 0;   // CORRECCION
    }

    public boolean depositar(double monto) {
        if (!montoValido(monto)) return false;
        saldo += monto;
        return true;
    }

    public boolean retirar(double monto) {
        if (!montoValido(monto) || monto > saldo) return false;
        saldo -= monto;
        return true;
    }

    public double consultarSaldo() { return saldo; }
}
