package crypto.random;

import java.security.SecureRandom;

public class Test {
	public static void main(String[] args) throws Exception {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG"); // => Algoritmo/Modo/Padding
		sr.setSeed(1L);
		for (int i = 0; i < 10; i++) {
			System.out.println("Número aleatorio (" + 
					i + "): " + sr.nextInt());
		}
	}
}
