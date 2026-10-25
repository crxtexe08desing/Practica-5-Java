public class Main {
    public static void main(String[] args) {
        Libro libro = new Libro("Estructuras de Datos en Java");
        Lector lector = new Lector("Luis Ficticio");
        Prestamo p = new Prestamo(libro, lector);

        System.out.println("1) Prestar: " + p.registrar() + " | " + p);
        System.out.println("2) Repetir prestamo: " + p.registrar() + " | " + p);
        System.out.println("3) Otro prestamo del mismo libro: " + new Prestamo(libro, new Lector("Otro")).registrar());
        System.out.println("4) Devolver: " + p.devolver() + " | " + p);
        System.out.println("5) Devolver otra vez: " + p.devolver());
    }
}
