package crypto.signature;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Hashtable;
import java.util.Map;

import crypto.util.UtilCrypto;

public class Generador {
	public static void main(String[] args) throws Exception {
		File[] ficheros = new File[] {
				new File("tmp/quijote.txt"),
				new File("tmp/loremipsum.txt"),
			};
		Map<File, byte[]> firmas = 
				new Hashtable<File, byte[]>();

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
			firmas.put(f, firma);
			System.out.println("Firma de " + f + ": " +
					UtilCrypto.toHex(firma));
		}
		
		System.out.println();
		
		// 2. Verificando la firma
		for (File f : ficheros) {
			Signature sig = Signature.getInstance("SHA1withRSA");
			sig.initVerify(kpair.getPublic()); // Verificando!
			sig.update(Files.readAllBytes(f.toPath()));

			boolean verificado = sig.verify(firmas.get(f));
			if (verificado)
				System.out.println(f + " ha sido verificado");
			else
				System.out.println(f + " no ha sido verificado");
		}
		
	}
}

