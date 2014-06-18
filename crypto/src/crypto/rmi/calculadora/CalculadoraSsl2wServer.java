package crypto.rmi.calculadora;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * VM params:
 * -Djavax.net.ssl.trustStore=stores/truststore-servidor.ts -Djavax.net.ssl.trustStorePassword=123456
 * -Djavax.net.ssl.keyStore=stores/keystore-servidor.jks -Djavax.net.ssl.keyStorePassword=123456 
 */
public class CalculadoraSsl2wServer {
	public static void main(String[] args) throws Exception {
		Registry registry = LocateRegistry.createRegistry(1099);
		registry.rebind("Calculadora", new CalculadoraSsl2wImpl());
		System.out.println("Registro RMI iniciado...");
	}
}
