public class Main {
    static int ok = 0, fallos = 0;

    static void verificar(String nombre, boolean condicion) {
        System.out.println((condicion ? "[OK]    " : "[FALLA] ") + nombre);
        if (condicion) ok++; else fallos++;
    }

    public static void main(String[] args) {
        System.out.println("== Reproduccion del defecto en la version ORIGINAL ==");
        CuentaDigitalOriginal o = new CuentaDigitalOriginal(100);
        boolean acepto = o.depositar(Double.NaN);
        System.out.println("depositar(NaN) -> " + acepto + ", saldo = " + o.consultarSaldo());

        System.out.println("\n== Pruebas sobre la version CORREGIDA (5 sugerencias tipicas) ==");
        CuentaDigital c = new CuentaDigital("Ana Ficticia", "CD-001", 100);
        verificar("1. deposito valido incrementa saldo", c.depositar(50) && c.consultarSaldo() == 150);
        verificar("2. retiro igual al saldo deja 0", c.retirar(150) && c.consultarSaldo() == 0);
        verificar("3. retiro con saldo 0 se rechaza", !c.retirar(0.01));
        verificar("4. deposito NaN se rechaza y no corrompe", !c.depositar(Double.NaN) && c.consultarSaldo() == 0);
        verificar("5. deposito infinito se rechaza", !c.depositar(Double.POSITIVE_INFINITY) && c.consultarSaldo() == 0);

        System.out.println("\nResumen: " + ok + " OK, " + fallos + " fallas");
    }
}
