package crypto.cipher;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;

public class TestCipherStreams {

	public static void main(String[] args) throws Exception {
		String nombreArchivo = "tmp/quijote.txt";
		
		// 0.- Obteniendo la clave y obteniendo cipher
		Key key = KeyGenerator.getInstance("DESede").generateKey();
		Cipher cipher = Cipher.getInstance("DESede");
		
		// 1.- Cifrar el contenido del archivo con CipherOutputStream
		cipher.init(Cipher.ENCRYPT_MODE, key);
		FileInputStream fis = new FileInputStream(nombreArchivo);
		FileOutputStream fos = new FileOutputStream(
				nombreArchivo + ".cifrado");
		CipherOutputStream cos = new CipherOutputStream(fos, cipher);
		
	    byte[] b = new byte[8];
	    int i = fis.read(b);
	    while (i != -1) {
	        cos.write(b, 0, i);
	        i = fis.read(b);
	    }
	    cos.flush(); // Escribiendo el archivo cifrado
	    fis.close();
	    cos.close();
	    fos.close();
	    
	    System.out.println(nombreArchivo + " cifrado");
	    
		// 1.- Cifrar el contenido del archivo con CipherOutputStream
		cipher.init(Cipher.DECRYPT_MODE, key);
		fis = new FileInputStream(nombreArchivo + ".cifrado");
		fos = new FileOutputStream(
				nombreArchivo + ".descifrado");
		CipherInputStream cis = new CipherInputStream(fis, cipher);
		
	    b = new byte[8];
	    i = cis.read(b);
	    while (i != -1) {
	        fos.write(b, 0, i);
	        i = cis.read(b);
	    }
	    cis.close();
	    fis.close();
	    fos.close();

	    System.out.println(nombreArchivo + " descifrado");
	}

}
