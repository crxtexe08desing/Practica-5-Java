public class Main {
    public static void main(String[] args) {
        CuentaDigital c = new CuentaDigital("Ana Ficticia", "CD-001", 100.0);
        System.out.println("Inicial: " + c);

        System.out.println("Deposito 50 -> " + c.depositar(50) + " | " + c);
        System.out.println("Retiro 30 -> " + c.retirar(30) + " | " + c);
        System.out.println("Deposito -10 -> " + c.depositar(-10) + " | " + c);
        System.out.println("Retiro 1000 -> " + c.retirar(1000) + " | " + c);
        System.out.println("Retiro 0 -> " + c.retirar(0) + " | " + c);
    }
}
