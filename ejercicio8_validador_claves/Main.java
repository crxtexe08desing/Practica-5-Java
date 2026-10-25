public class Main {
    static int ok = 0, fallos = 0;

    static void caso(String desc, boolean obtenido, boolean esperado) {
        boolean paso = obtenido == esperado;
        System.out.printf("%-8s %-42s obtenido=%-5b esperado=%b%n", paso ? "[OK]" : "[FALLA]", desc, obtenido, esperado);
        if (paso) ok++; else fallos++;
    }

    public static void main(String[] args) {
        ValidadorClaveOriginal vo = new ValidadorClaveOriginal();
        ValidadorClave v = new ValidadorClave();

        System.out.println("== ANTES (codigo inicial) ==");
        caso("'abcdefgh' (8 letras, sin 123)", vo.esValida("abcdefgh"), false);
        caso("'123' (corta)", vo.esValida("123"), false);
        caso("'12345678' (solo digitos)", vo.esValida("12345678"), false);   // el original dice true: falla
        caso("'abc 123 x' (con espacios)", vo.esValida("abc 123 x"), false);  // el original dice true: falla
        System.out.println("\n== DESPUES (version revisada) ==");
        caso("'abcdefgh'", v.esValida("abcdefgh"), false);
        caso("'12345678'", v.esValida("12345678"), false);
        caso("'abc 123 x'", v.esValida("abc 123 x"), false);
        caso("'Prueba2026' (valida)", v.esValida("Prueba2026"), true);
        caso("'a1b2c3' (corta)", v.esValida("a1b2c3"), false);
        caso("null", v.esValida(null), false);
        caso("'' (vacia)", v.esValida(""), false);
        System.out.println("\nResumen: " + ok + " OK, " + fallos + " fallas (las fallas de la seccion ANTES son esperadas: muestran los defectos del original)");
    }
}
