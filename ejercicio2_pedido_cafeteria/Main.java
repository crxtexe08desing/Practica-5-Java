public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        pedido.agregar(new Producto("Cafe", 12.50));
        pedido.agregar(new Producto("Croissant", 8.00));
        pedido.agregar(new Producto("Jugo", 10.00));
        System.out.println("Cuarto producto aceptado? " + pedido.agregar(new Producto("Torta", 15.0)));

        System.out.println("Pedido:");
        pedido.mostrarLineas();
        System.out.printf("Subtotal: %.2f%n", pedido.calcularSubtotal());
        System.out.printf("Total:    %.2f%n", pedido.calcularTotal());

        try {
            new Producto("Gratis", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Rechazado: " + e.getMessage());
        }
    }
}
