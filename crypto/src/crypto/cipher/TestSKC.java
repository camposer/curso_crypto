package crypto.cipher;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import crypto.util.UtilCrypto;

public class TestSKC {
	public static void main(String[] args) throws Exception {
		String nombreFichero = "tmp/quijote.txt";
		File fichero = new File(nombreFichero);
		
		// 1.- Generando la clave
		KeyGenerator kgen = KeyGenerator.getInstance("AES");
		Key key = kgen.generateKey();
		
		// 2.- Cifrando
		Cipher cipher = Cipher.getInstance("AES");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] cifrado = cipher.doFinal(Files.readAllBytes(fichero.toPath()));
		
		System.out.println(UtilCrypto.toHex(cifrado));
		Files.write(
				new File(nombreFichero + ".cifrado").toPath(), 
				cifrado, 
				StandardOpenOption.CREATE);

		System.out.println();
		
		// 3.- Descifrando
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] descifrado = cipher.doFinal(cifrado);
		System.out.println(new String(descifrado));
		Files.write(
				new File(nombreFichero + ".descifrado").toPath(), 
				descifrado, 
				StandardOpenOption.CREATE);
	}
}





