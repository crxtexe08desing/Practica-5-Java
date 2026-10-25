public abstract class Sensor {
    protected final String id;
    protected final String ubicacion;

    protected Sensor(String id, String ubicacion) {
        this.id = id;
        this.ubicacion = ubicacion;
    }

    public abstract double leer();

    public String reporte() {
        return String.format("[%s @ %s] %.1f", id, ubicacion, leer());
    }
}
