public class EntregaAutomovil extends Entrega {
    public EntregaAutomovil(String destino, double distanciaKm) { super(destino, distanciaKm); }

    @Override
    public double calcularCosto() { return 8.0 + distanciaKm * 2.5; }
}
