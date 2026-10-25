public class Main {
    public static void main(String[] args) {
        SensorTemperatura temp = new SensorTemperatura("T-01", "Zona A", 24.0);
        Sensor[] sensores = { temp, new SensorHumedad("H-01", "Zona B", 61.0) };

        System.out.println("Antes de calibrar:");
        for (Sensor s : sensores) System.out.println("  " + s.reporte());

        temp.calibrar(-1.5);
        System.out.println("Despues de calibrar T-01 (-1.5):");
        for (Sensor s : sensores) System.out.println("  " + s.reporte());
    }
}
