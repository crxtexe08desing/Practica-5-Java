public class Producto {
    private final String nombre;
    private final double precio;

    public Producto(String nombre, double precio) {
        if (nombre == null || nombre.isBlank()) throw new IllegalArgumentException("Nombre invalido");
        if (precio <= 0) throw new IllegalArgumentException("El precio debe ser positivo");
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
}
