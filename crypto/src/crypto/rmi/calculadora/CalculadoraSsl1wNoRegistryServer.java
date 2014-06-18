package crypto.rmi.calculadora;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * VM params: 
 * -Djavax.net.ssl.keyStore=stores/keystore.jks -Djavax.net.ssl.keyStorePassword=123456 
 */
public class CalculadoraSsl1wNoRegistryServer {
	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry.getRegistry("localhost", 1099);
		registry.rebind("Calculadora", new CalculadoraSsl1wImpl());
		System.out.println("Objeto enlazado...");
	}
}
