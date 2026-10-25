class ValidadorClaveOriginal {
    boolean esValida(String clave) {
        return clave.length() >= 8 && clave.contains("123");
    }
}
