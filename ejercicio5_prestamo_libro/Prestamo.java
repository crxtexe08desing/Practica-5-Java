public class Prestamo {
    private final Libro libro;
    private final Lector lector;
    private boolean activo = false;

    public Prestamo(Libro libro, Lector lector) {
        this.libro = libro;
        this.lector = lector;
    }

    public boolean registrar() {
        if (activo || !libro.marcarPrestado()) return false;
        activo = true;
        return true;
    }

    public boolean devolver() {
        if (!activo) return false;
        libro.marcarDisponible();
        activo = false;
        return true;
    }

    public boolean estaActivo() { return activo; }

    @Override
    public String toString() {
        return String.format("Prestamo[%s -> %s | activo=%b | libro disponible=%b]",
                libro.getTitulo(), lector.getNombre(), activo, libro.estaDisponible());
    }
}
