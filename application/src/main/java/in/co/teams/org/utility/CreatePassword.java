package in.co.teams.org.utility;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CreatePassword {
	
	/* The function takes a parameter defaultDalt as the id of the user and the 
	 * password entered by the user and the function creates a 512 bit hash and returns 
	 * it in a string format.
	*/
	
	public static String createPassword(int defaultSalt,String password) {
		byte[] salt=Integer.toString(defaultSalt).getBytes();
		String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
		return generatedPassword;
	}
	
}
