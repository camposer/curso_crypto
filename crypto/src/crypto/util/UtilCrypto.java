package crypto.util;

public class UtilCrypto {
	/**
	 * @see http://stackoverflow.com/questions/2817752/java-code-to-convert-byte-to-hexadecimal
	 */
	public static String toHex(byte[] digest) {
	    StringBuilder sb = new StringBuilder();
	    for (byte b : digest) {
	        sb.append(String.format("%02X", b));
	    }
	    
	    return sb.toString();
	}

}
