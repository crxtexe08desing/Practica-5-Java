// Version original (ejercicio 1) para reproducir el defecto antes de la correccion.
public class CuentaDigitalOriginal {
    private double saldo;
    public CuentaDigitalOriginal(double saldoInicial) { this.saldo = saldoInicial; }

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
}
