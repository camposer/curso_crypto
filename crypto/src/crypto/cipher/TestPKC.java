package crypto.cipher;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

import javax.crypto.Cipher;

import crypto.util.UtilCrypto;

public class TestPKC {
	private static final int NUM_BYTES_ENCRYPT = 117;
	private static final int NUM_BYTES_DECRYPT = 128;
	
	public static void main(String[] args) throws Exception {
		String nombreFichero = "tmp/quijote.txt";
		byte[] texto = Files.readAllBytes(
				new File(nombreFichero).toPath());
		
		// 1.- Generando la clave
		KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA");
		kg.initialize(1024); // Tamaño de la clave
		KeyPair kpair = kg.generateKeyPair();
		
		// 2.- Cifrando
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, kpair.getPrivate());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();		
		for (int i = 0; i < texto.length / NUM_BYTES_ENCRYPT; i++) {
			byte[] cifrado = cipher.doFinal(
				texto, 
				NUM_BYTES_ENCRYPT * i, 
				NUM_BYTES_ENCRYPT);
			
			baos.write(cifrado);
		}
		baos.close();
		
		// Escribiendo flujo de bytes
		byte[] textoCifrado = baos.toByteArray();
		System.out.println(UtilCrypto.toHex(textoCifrado));
		Files.write(
				new File(nombreFichero + ".cifrado").toPath(), 
				textoCifrado, 
				StandardOpenOption.CREATE);

		System.out.println();
		
		// 3.- Descifrando
		cipher.init(Cipher.DECRYPT_MODE, kpair.getPublic());
		baos = new ByteArrayOutputStream();
		for (int i = 0; i < textoCifrado.length / NUM_BYTES_DECRYPT; i++) {
			byte[] descifrado = cipher.doFinal(
				textoCifrado, 
				NUM_BYTES_DECRYPT * i, 
				NUM_BYTES_DECRYPT);
			
			baos.write(descifrado);
		}
		
		baos.close();
		
		// Escribiendo flujo de bytes
		byte[] textoDescifrado = baos.toByteArray();
		System.out.println(new String(textoDescifrado));
		Files.write(
				new File(nombreFichero + ".descifrado").toPath(), 
				textoDescifrado, 
				StandardOpenOption.CREATE);
		
	}
}





