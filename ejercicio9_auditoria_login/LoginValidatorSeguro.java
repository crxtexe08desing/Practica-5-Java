import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Version DIDACTICA. No es un sistema real de autenticacion.
 * Cambios frente a LoginValidator:
 *  - Sin usuario ni hash codificados en el codigo: se reciben por configuracion.
 *  - PBKDF2 con sal e iteraciones en lugar de MD5 sin sal.
 *  - Codificacion UTF-8 explicita (sin depender del default de la plataforma).
 *  - Comparacion en tiempo constante.
 *  - Limite de intentos fallidos consecutivos.
 */
public class LoginValidatorSeguro {
    private static final int ITERACIONES = 120_000;
    private static final int BITS_CLAVE = 256;
    private static final int MAX_INTENTOS = 3;

    private final String usuario;
    private final byte[] sal;
    private final byte[] hash;
    private int intentosFallidos = 0;

    public LoginValidatorSeguro(String usuario, byte[] sal, byte[] hash) {
        this.usuario = usuario;
        this.sal = sal.clone();
        this.hash = hash.clone();
    }

    /** Utilidad para preparar credenciales de laboratorio (genera sal y hash). */
    public static String[] derivarCredencial(char[] clave) {
        byte[] sal = new byte[16];
        new SecureRandom().nextBytes(sal);
        byte[] h = pbkdf2(clave, sal);
        return new String[] { Base64.getEncoder().encodeToString(sal), Base64.getEncoder().encodeToString(h) };
    }

    public static LoginValidatorSeguro desdeConfiguracion(String usuario, String salB64, String hashB64) {
        return new LoginValidatorSeguro(usuario, Base64.getDecoder().decode(salB64), Base64.getDecoder().decode(hashB64));
    }

    public boolean estaBloqueado() { return intentosFallidos >= MAX_INTENTOS; }

    public boolean login(String user, char[] password) {
        if (estaBloqueado() || user == null || password == null) return false;
        byte[] calculado = pbkdf2(password, sal);
        boolean userOk = MessageDigest.isEqual(
                usuario.getBytes(StandardCharsets.UTF_8), user.getBytes(StandardCharsets.UTF_8));
        boolean passOk = MessageDigest.isEqual(hash, calculado);
        if (userOk && passOk) { intentosFallidos = 0; return true; }
        intentosFallidos++;
        return false;
    }

    private static byte[] pbkdf2(char[] clave, byte[] sal) {
        try {
            PBEKeySpec spec = new PBEKeySpec(clave, sal, ITERACIONES, BITS_CLAVE);
            return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(spec).getEncoded();
        } catch (Exception e) {
            throw new IllegalStateException("No se pudo derivar la clave", e);
        }
    }
}
