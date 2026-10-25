public class Main {
    public static void main(String[] args) {
        System.out.println("== Original (laboratorio, clave ficticia de prueba) ==");
        System.out.println("admin / clave-incorrecta -> " + LoginValidator.login("admin", "clave-incorrecta"));
        System.out.println("otro  / clave-incorrecta -> " + LoginValidator.login("otro", "clave-incorrecta"));

        System.out.println("\n== Version didactica segura ==");
        // Clave inventada solo para la demo; en un caso real vendria de configuracion externa.
        String[] cred = LoginValidatorSeguro.derivarCredencial("Demo-Lab-2026".toCharArray());
        LoginValidatorSeguro v = LoginValidatorSeguro.desdeConfiguracion("lab", cred[0], cred[1]);

        System.out.println("lab / Demo-Lab-2026 -> " + v.login("lab", "Demo-Lab-2026".toCharArray()));
        for (int i = 1; i <= 3; i++) {
            System.out.println("intento fallido " + i + " -> " + v.login("lab", "mal".toCharArray()));
        }
        System.out.println("bloqueado? " + v.estaBloqueado());
        System.out.println("clave correcta tras bloqueo -> " + v.login("lab", "Demo-Lab-2026".toCharArray()));
    }
}
