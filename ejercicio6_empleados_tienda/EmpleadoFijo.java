public class EmpleadoFijo extends Empleado {
    private final double sueldoMensual;

    public EmpleadoFijo(String nombre, String id, double sueldoMensual) {
        super(nombre, id);
        this.sueldoMensual = sueldoMensual;
    }

    @Override public double calcularPago() { return sueldoMensual; }
}
