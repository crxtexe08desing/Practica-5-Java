public class Pedido {
    private static final int CAPACIDAD = 3;
    private final Producto[] productos = new Producto[CAPACIDAD];
    private int cantidad = 0;

    public boolean agregar(Producto p) {
        if (p == null || cantidad >= CAPACIDAD) return false;
        productos[cantidad++] = p;
        return true;
    }

    public double calcularSubtotal() {
        double suma = 0;
        for (int i = 0; i < cantidad; i++) suma += productos[i].getPrecio();
        return suma;
    }

    public double calcularTotal() { return calcularSubtotal(); }

    public void mostrarLineas() {
        for (int i = 0; i < cantidad; i++) {
            System.out.printf("  %d. %-12s %6.2f%n", i + 1, productos[i].getNombre(), productos[i].getPrecio());
        }
    }
}
