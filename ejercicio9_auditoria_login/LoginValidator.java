public class LoginValidator {
 
    private static final String USER = "admin";
    private static final String PASSWORD_HASH = "5f4dcc3b5aa765d61d8327deb882cf99";
 
    public static boolean login(String user, String password) {
        String hash = md5(password);
        return USER.equals(user)
                && PASSWORD_HASH.equals(hash);
    }
 
    private static String md5(String input) {
        try {
            java.security.MessageDigest md =
                    java.security.MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
}
