package crypto.digest;

import java.io.File;
import java.nio.file.Files;
import java.security.MessageDigest;

import crypto.util.UtilCrypto;

public class Test {
	public static void main(String[] args) throws Exception {
		MessageDigest mdMd5 = MessageDigest.getInstance("MD5");
		MessageDigest mdSha1 = MessageDigest.getInstance("SHA-1");
		
		String[] ficheros = new String[] { 
				"tmp/quijote.txt", 
				"tmp/loremipsum.txt" 
			};
		
		for (String f : ficheros) {
			// Extrayendo MD5
			mdMd5.update(Files.readAllBytes(new File(f).toPath()));
			System.out.println("MD5 de " + f + 
					": " + UtilCrypto.toHex(mdMd5.digest()));

			// Extrayendo SHA-1
			mdSha1.update(Files.readAllBytes(new File(f).toPath()));
			System.out.println("SHA-1 de " + f + 
					": " + UtilCrypto.toHex(mdSha1.digest()));
			
			System.out.println();
		}
	}
}
