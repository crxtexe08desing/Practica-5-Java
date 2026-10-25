public class Main {
    public static void main(String[] args) {
        Empleado[] empleados = {
            new EmpleadoPorHora("Marta", "E-01", 15.0, 80),
            new EmpleadoFijo("Pedro", "E-02", 1800.0)
        };
        for (Empleado e : empleados) {
            System.out.printf("%-6s %-5s pago=%.2f%n", e.getNombre(), e.getId(), e.calcularPago());
        }
    }
}
