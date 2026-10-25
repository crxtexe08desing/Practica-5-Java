public class SensorTemperatura extends Sensor implements Calibrable {
    private double offset = 0;
    private final double base;

    public SensorTemperatura(String id, String ubicacion, double base) {
        super(id, ubicacion);
        this.base = base;
    }

    @Override public double leer() { return base + offset; }
    @Override public void calibrar(double offset) { this.offset = offset; }
}
