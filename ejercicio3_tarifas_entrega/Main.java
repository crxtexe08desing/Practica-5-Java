public class Main {
    public static void main(String[] args) {
        Entrega[] entregas = {
            new EntregaBicicleta("Plaza Central", 4),
            new EntregaAutomovil("Terminal", 12)
        };
        for (Entrega e : entregas) {
            System.out.printf("%-14s %-18s costo=%.2f%n",
                    e.getDestino(), e.getClass().getSimpleName(), e.calcularCosto());
        }
        System.out.printf("Auto con recargo 0.5/km: %.2f%n", entregas[1].calcularCosto(0.5));
    }
}
