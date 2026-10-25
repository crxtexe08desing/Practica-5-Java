public class ValidadorClave {
    private static final int LONGITUD_MINIMA = 8;

    public boolean esValida(String clave) {
        if (clave == null) return false;
        return longitudSuficiente(clave) && sinEspacios(clave) && tieneVariedad(clave);
    }

    private boolean longitudSuficiente(String clave) { return clave.length() >= LONGITUD_MINIMA; }

    private boolean sinEspacios(String clave) {
        for (int i = 0; i < clave.length(); i++) {
            if (Character.isWhitespace(clave.charAt(i))) return false;
        }
        return true;
    }

    // Regla 3: al menos una letra y un digito
    private boolean tieneVariedad(String clave) {
        boolean letra = false, digito = false;
        for (int i = 0; i < clave.length(); i++) {
            char c = clave.charAt(i);
            if (Character.isLetter(c)) letra = true;
            if (Character.isDigit(c)) digito = true;
        }
        return letra && digito;
    }
}
