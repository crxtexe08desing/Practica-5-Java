public abstract class Empleado {
    protected final String nombre;
    protected final String id;

    public Empleado(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public abstract double calcularPago();

    public String getNombre() { return nombre; }
    public String getId() { return id; }
}
