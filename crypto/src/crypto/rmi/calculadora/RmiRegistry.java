package crypto.rmi.calculadora;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * -Djavax.net.ssl.trustStore=stores/truststore.ts -Djavax.net.ssl.trustStorePassword=123456
 *
 */
public class RmiRegistry {
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry.createRegistry(1099);
		System.out.println("Registro RMI iniciado...");
		Thread.sleep(Long.MAX_VALUE);
	}
}
