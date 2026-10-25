public class EmpleadoPorHora extends Empleado {
    private final double tarifaHora;
    private final int horas;

    public EmpleadoPorHora(String nombre, String id, double tarifaHora, int horas) {
        super(nombre, id);
        this.tarifaHora = tarifaHora;
        this.horas = horas;
    }

    @Override public double calcularPago() { return tarifaHora * horas; }
}
