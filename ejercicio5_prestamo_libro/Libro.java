public class Libro {
    private final String titulo;
    private boolean disponible = true;

    public Libro(String titulo) { this.titulo = titulo; }

    public boolean marcarPrestado() {
        if (!disponible) return false;
        disponible = false;
        return true;
    }

    public void marcarDisponible() { disponible = true; }
    public boolean estaDisponible() { return disponible; }
    public String getTitulo() { return titulo; }
}
