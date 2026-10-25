public class SensorHumedad extends Sensor {
    private final double valor;

    public SensorHumedad(String id, String ubicacion, double valor) {
        super(id, ubicacion);
        this.valor = valor;
    }

    @Override public double leer() { return valor; }
}
