package crypto.signature;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;

import crypto.util.UtilCrypto;

public class Generador {
	public static void main(String[] args) throws Exception {
		File[] ficheros = new File[] {
				new File("tmp/quijote.txt"),
				new File("tmp/loremipsum.txt"),
			};

		// 1.- Generar claves públicas y privadas
		KeyPairGenerator kpg = KeyPairGenerator
				.getInstance("RSA");
		
		KeyPair kpair = kpg.generateKeyPair(); // par de claves
		
		// 1.- Firmando documentos
		for (File f : ficheros) {
			Signature sig = Signature.getInstance("SHA1withRSA");
			sig.initSign(kpair.getPrivate()); // Firmando!
			sig.update(Files.readAllBytes(f.toPath()));
			byte[] firma = sig.sign();
			System.out.println("Firma de " + f + ": " +
					UtilCrypto.toHex(firma));
		}
		
		
		
	}
}

