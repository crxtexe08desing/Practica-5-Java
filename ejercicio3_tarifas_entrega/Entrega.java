public class Entrega {
    protected final String destino;
    protected final double distanciaKm;

    public Entrega(String destino, double distanciaKm) {
        if (distanciaKm < 0) throw new IllegalArgumentException("Distancia negativa");
        this.destino = destino;
        this.distanciaKm = distanciaKm;
    }

    public double calcularCosto() { return distanciaKm * 1.0; }

    // Sobrecarga: distinto numero de parametros
    public double calcularCosto(double recargoPorKm) {
        return calcularCosto() + distanciaKm * recargoPorKm;
    }

    public String getDestino() { return destino; }
}
